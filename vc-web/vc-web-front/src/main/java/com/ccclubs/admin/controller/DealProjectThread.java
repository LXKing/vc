package com.ccclubs.admin.controller;

import com.ccclubs.admin.model.SrvProject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 
 ****************************
 * 版权所有：车厘子 所有权利
 * 创建日期: 2017-10-18
 * 创建作者：zkm
 * 类名称　：DealProjectThread.java
 * 版　　本：
 * 功　　能：项目批量处理线程，提高页面响应速度
 * 最后修改：
 * 修改记录：
 *****************************
 */
public class DealProjectThread
{
    /**
     * 数量
     */
    private int count;
    
    /**
     * 索引
     */
    private int index = 0;

    /**
     * 总数
     */
    private int TESKSIZE = 20;

    private Map<String,Object> resultMap = new HashMap<String,Object>();
    
    private Map<String,Object> checkLimits = new HashMap<String,Object>();


    /**
     * 对象锁
     */
    public Object lock = new Object();
    
    private static Integer exps[] =
        { 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536 };
    
    private ExecutorService threadPool = Executors.newFixedThreadPool(5);//使用5个线程，根据业务量可以动态调配

    private Map<Long, Integer> limitMap;
    
    private Long userId;
    
    List<SrvProject> projects;
    
    public DealProjectThread(List<SrvProject> projects,Map<Long, Integer> limitMap,Long userId){
        this.userId = userId;
        this.projects = projects;
        this.limitMap = limitMap;
    }

    public Map<String, Object> run()
    {
        count = getCount(projects.size());// 计算count
        final CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++)
        {
            try
            {
                // 执行线程
                threadPool.execute(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        List<SrvProject> excuteProject = getSubList(count,
                                projects);
                        Map<String, Object> result = new HashMap<String, Object>();
                        String[] limitpath = null;
                        Integer slLimit = null;
                        Map<String, Object> limit = new HashMap<String, Object>();
                        Map<String, String> checkLimit = new HashMap<String, String>();
                        String path =null;
                        String[] expLimits = null;
                        for (SrvProject project : excuteProject)
                        {
                            // 权限值
                            slLimit = getLimitMap().get(
                                    project.getSpId().longValue());
                            if (slLimit == null)
                                continue;
                            // 处理后台校验权限
                            path = project.getSpUrl();
                            if (path != null && !"".equals(path))
                            {
                                if(path.indexOf("//")!=-1){//url转化
                                    path = path.replaceAll("//", "/");
                                }
                                path = path.replaceAll("\r\n", "");// 空格替换
                                path.replaceAll("，", ",");
                                limitpath = path.split(",");
                                if(limitpath.length<3)
                                {
                                    continue;
                                }
                                for(int i =0 ; i<limitpath.length ;i++)
                                {
                                    if(limitpath[i].indexOf("/")==0)//排除第一位是/的可能
                                    {
                                        limitpath[i] = limitpath[i].substring(1,limitpath[i].length());
                                    }
                                    if(i < 4)//扩展权限另外处理
                                    {
                                        Double pow = Math.pow(2, (i+1));
                                        if(limitpath[i].indexOf("|")!=-1)
                                        {
                                            expLimits = limitpath[i].split("\\|");//一个按钮多种操作权限
                                            for(String exp : expLimits)
                                            {
                                                if(exp.indexOf("/")==0)//排除第一位是/的可能
                                                {
                                                    exp = exp.substring(1,exp.length());
                                                }
                                                checkLimit.put(exp,((slLimit & pow.intValue()) == pow.intValue()) ? "true": "false");
                                            }
                                        }else
                                        {
                                            checkLimit.put(limitpath[i],((slLimit & pow.intValue()) == pow.intValue()) ? "true": "false");
                                        }
                                    }
                                }
//                                // 增加权限
//                                checkLimit.put(limitpath[i],((slLimit & pow.intValue()) == 2) ? "true": "false");
//                                // 更新权限
//                                checkLimit.put(limitpath[1],((slLimit & 4) == 4) ? "true": "false");
//                                // 删除权限
//                                checkLimit.put(limitpath[2],((slLimit & 8) == 8) ? "true": "false");
//                                // 导出权限
//                                checkLimit.put(limitpath[3],((slLimit & 16) == 16) ? "true": "false");
                                if (limitpath.length > 4)// 扩展权限
                                {
                                    for (int i = 4; i < limitpath.length; i++)
                                    {
                                        if(limitpath[i].indexOf("|")!=-1)
                                        {
                                            expLimits = limitpath[i].split("\\|");//一个按钮多种操作权限
                                            for(String exp : expLimits)
                                            {
                                                if(exp.indexOf("/")==0)//排除第一位是/的可能
                                                {
                                                    exp = exp.substring(1,exp.length());
                                                }
                                                checkLimit.put(exp,((slLimit & exps[i - 4]) == exps[i - 4]) ? "true": "false");
                                            }
                                        }else
                                        {
                                            checkLimit.put(limitpath[i],((slLimit & exps[i - 4]) == exps[i - 4]) ? "true": "false");
                                        }
                                    }
                                }
                                

                            }
                            // 处理页面显示权限
                            limit.put("canView", ((slLimit & 1) == 1) ? 1 : 0);
                            limit.put("detail", ((slLimit & 1) == 1) ? 1 : 0);
                            limit.put("add", ((slLimit & 2) == 2) ? 1 : 0);
                            limit.put("update", ((slLimit & 4) == 4) ? 1 : 0);
                            limit.put("del", ((slLimit & 8) == 8) ? 1 : 0);
                            limit.put("batchDel", ((slLimit & 8) == 8) ? 1 : 0);
                            limit.put("exportData", ((slLimit & 16) == 16) ? 1: 0);
                            limit.put("canStats", ((slLimit & 32) == 32) ? 1: 0);
                            //处理扩展权限
                            int canExp[] = new int[exps.length];
                            for (int i = 0; i < exps.length; i++)
                            {
                                canExp[i] = (slLimit & exps[i]) == exps[i] ? 1
                                        : 0;
                            }
                            limit.put("canExp", canExp);
                            result.put(project.getSpUrl(), limit);
                        }
                        checkLimits.putAll(checkLimit);
                        resultMap.putAll(result);
                        countDownLatch.countDown();//释放计数器
                    }
                });

            }
            catch (Exception e)
            {
                countDownLatch.countDown();//释放计数器
            }
        }
        try
        {
            countDownLatchAwait(countDownLatch, "权限加载");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return resultMap;
    }
    
    /**
     * 拆分list 
     * @param listSize
     * @return int
     * @exception/throws
     * @see
     */
    private synchronized List<SrvProject> getSubList(int count,List<SrvProject> projects)
    {
        List<SrvProject> excuteProject = null;
        if (count - 1 == index)
        {
            excuteProject = new ArrayList<SrvProject>();
            excuteProject.addAll(projects.subList(
                    index * TESKSIZE, projects.size()));
        }
        else
        {
            excuteProject = new ArrayList<SrvProject>(
                    TESKSIZE);
            excuteProject.addAll(projects.subList(
                    index * TESKSIZE, (index + 1)
                            * TESKSIZE));
        }
        index++;
        return excuteProject;
    }
    
    /**
     * 降低圈复杂度 
     * @param listSize
     * @return int
     * @exception/throws
     * @see
     */
    private int getCount(int listSize)
    {
        int count = listSize / TESKSIZE;
        if (!(listSize % TESKSIZE == 0))
        {
            count++;
        }
        return count;
    }

    /**
     *降低圈复杂度 
     * @param countDownLatch
     * @throws Exception
     * @exception/throws
     */
    private void countDownLatchAwait(CountDownLatch countDownLatch,
            String threadName) throws Exception
    {
        try
        {
            countDownLatch.await();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
            throw new Exception(threadName + "线程处理失败!");
        }
    }


    public Map<Long, Integer> getLimitMap()
    {
        return limitMap;
    }
    public void setLimitMap(Map<Long, Integer> limitMap)
    {
        this.limitMap = limitMap;
    }
    public Long getUserId()
    {
        return userId;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }
    public List<SrvProject> getProjects()
    {
        return projects;
    }
    public void setProjects(List<SrvProject> projects)
    {
        this.projects = projects;
    }

}

