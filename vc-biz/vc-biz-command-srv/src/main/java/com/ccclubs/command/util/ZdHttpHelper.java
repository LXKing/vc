package com.ccclubs.command.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author qsxiaogang
 * @create 2017-11-06
 **/
@Component
public class ZdHttpHelper {

    private static Logger logger = LoggerFactory.getLogger(ZdHttpHelper.class);

    @Value("${zd.update.url}")
    private String ZD_UPDATE_URL;
    @Value("${zd.validate.url}")
    private String ZD_VALIDATE_URL;

    /**
     * 调用http接口，返回json字符串,获取升级指令
     *
     * @param simNo 手机号
     */
    public String getCmd(String simNo) {
        try {
            return JSONObject.parseObject(httpDoGet(ZD_UPDATE_URL + "&simCode=" + simNo, "UTF-8"))
                    .getString("cmd");
        } catch (Exception e) {
            logger.error("中导升级错误：发送消息到http接口出错:" + e.getMessage(), e);
            return null;
        }
    }

    public String validate(String simNo) {
        try {
            return JSONObject.parseObject(httpDoGet(ZD_VALIDATE_URL + "&simCode=" + simNo, "UTF-8"))
                    .getString("version");
        } catch (Exception e) {
            logger.error("中导升级验证错误：发送消息到http接口出错:" + e.getMessage(), e);
            return null;
        }
    }

    /**
     * 发送GET请求
     * @param url
     * @param encoding
     * @return
     * @throws Exception
     */
    public String httpDoGet(String url, String encoding) throws Exception {
        String result = "";
        CloseableHttpClient httpclient = HttpClients
                .createDefault();//114.55.173.208:7002  127.0.0.1:8888 101.37.178.63
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = httpclient.execute(httpPost);
        System.out.println(response.getStatusLine());
        int statusCode = response.getStatusLine().getStatusCode();
        // 200正常
        if (statusCode == 200) {
            HttpEntity entity = response.getEntity();
            result = IOUtils.toString(entity.getContent(), encoding);
        }
        response.close();

        return result;
    }

}
