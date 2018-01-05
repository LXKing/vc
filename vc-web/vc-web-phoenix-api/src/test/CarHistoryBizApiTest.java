import com.alibaba.fastjson.JSON;
import com.ccclubs.phoenix.input.CarStateHistoryParam;
import com.ccclubs.phoenix.orm.model.CarState;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * CarHistoryBizApi Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ʮ���� 9, 2017</pre>
 */
public class CarHistoryBizApiTest {



    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    //@Test
    public void testQueryCarStateList() throws Exception {

        CloseableHttpClient httpclient = HttpClients.createDefault();//114.55.173.208:7002  127.0.0.1:8888 101.37.178.63
        HttpPost httpPost = new HttpPost("http://101.37.178.63/history/states-query");
        httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
        CarStateHistoryParam param = new CarStateHistoryParam();
        param.setStart_time("2017-12-25 10:22:29");
        param.setCsVin("LS5A2AJX4GA003002");
        param.setPage_no(1);
        param.setEnd_time("2017-12-25 14:04:55");
        param.setOrder("asc");
        param.setQuery_fields("speed,current_time,latitude,add_time,longitude");
        String s = JSON.toJSONString(param);
        String value = DigestUtils.md5Hex(s);
        String sign = HmacUtils.hmacSha1Hex("appkey", value);
        httpPost.addHeader("sign", sign);
        httpPost.addHeader("appId", "1000005");
        httpPost.setEntity(new StringEntity(s, ContentType.APPLICATION_JSON));
        long stime=System.currentTimeMillis();
        CloseableHttpResponse response = httpclient.execute(httpPost);
        this.checkResponse(response);
        long etime=System.currentTimeMillis();
        System.out.println("use time:"+(etime-stime));

    }





    //@Test
    public void testPutCsStateList()throws Exception {

        for (int i=0;i<20;i++){
           Thread thread = new TestStateThread(i);
           thread.start();
           thread.join();
        }

    }



    private class TestStateThread extends Thread{
        private int threadNum;

        public TestStateThread(int threadNum) {
            this.threadNum = threadNum;
        }

        @Override
        public void run() {
            for (int i=0;i<10;i++){
                CloseableHttpClient httpclient = HttpClients.createDefault();//114.55.173.208:7002  127.0.0.1:8888 101.37.178.63
                HttpPost httpPost = new HttpPost("http://116.62.29.30:7007/history/states");
                httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
                List<CarState> carStateList=new ArrayList<>();
                for (int j=0;j<1000;j++){
                    CarState carState=new CarState();
                    long addTime=System.currentTimeMillis()+j;
                    carState.setAdd_time(addTime);
                    carState.setCurrent_time(addTime-2000);
                    carState.setCs_number("FJT03698"+10+(threadNum));
                    carState.setGear(1);
                    carState.setBase_ci("");
                    carState.setBase_lac("");
                    carState.setCharging_status(1);
                    carState.setCs_access(1);
                    carState.setCompre_status(1);
                    carState.setCircular_mode(1);
                    carState.setCur_order("");
                    carState.setDirection_angle(10F);
                    carState.setDoor_status(1);
                    carState.setElec_miles(200F);
                    carState.setEndur_miles(100F);
                    carState.setEngine_status(1);
                    carState.setEngine_tempe(20F);
                    carState.setEv_battery(0F);
                    carState.setFan_mode(4);
                    carState.setFuel_miles(1000F);
                    carState.setGps_num(4);
                    carState.setGps_strength(0);
                    carState.setGps_valid(1);
                    carState.setKey_status(1);
                    carState.setLatitude(43.185427);
                    carState.setLight_status(0);
                    carState.setLock_status(0);
                    carState.setLongitude(31.415926);
                    carState.setMotor_speed(100F+j);
                    carState.setNet_strength(4);
                    carState.setNet_type("");
                    carState.setObd_miles(10000F+j);
                    carState.setOil_cost(0F+j);
                    carState.setPower_reserve(0F);
                    carState.setPtc_status(1);
                    carState.setRent_flg(0);
                    carState.setRfid("");
                    carState.setSaving_mode(0);
                    carState.setSpeed(0F+100*i+j+10000*threadNum);
                    carState.setTempe(20F);
                    carState.setTotal_miles(500F+j);
                    carState.setUser_rfid(null);
                    carState.setWarn_code("0");
                    carStateList.add(carState);
                }
                String s = JSON.toJSONString(carStateList);
                httpPost.setEntity(new StringEntity(s, ContentType.APPLICATION_JSON));
                try {
                    httpclient.execute(httpPost);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //carStateHistoryInf.saveOrUpdate(carStateList);

            }
        }
    }


    /*@Test
    public void testQueryCarGbList() throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();//114.55.173.208:7002  127.0.0.1:8888 101.37.178.63
        HttpPost httpPost = new HttpPost("http://116.62.29.30:7007/history/states");
        String baseUrl="http://116.62.29.30:7007/history/gbs";
        //HttpGet httpGet = new HttpGet();
        //httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
        CarGbHistoryParam param = new CarGbHistoryParam();
        param.setStart_time("2017-12-03 00:00:00");
        param.setCs_vin("LJ8E3C1M6HD301230");
        param.setEnd_time("2017-12-09 00:00:00");
        param.setPage_no(1);
        String s = JSON.toJSONString(param);
        String value = DigestUtils.md5Hex(s);
        String sign = HmacUtils.hmacSha1Hex("appkey", value);
        httpPost.addHeader("sign", sign);
        httpPost.addHeader("appId", "1000002");
        httpPost.setEntity(new StringEntity(s, ContentType.APPLICATION_JSON));
        CloseableHttpResponse response = httpclient.execute(httpPost);
        this.checkResponse(response);
    }*/




    //@Test
    public void testQueryDrivePaces() throws Exception {


        CloseableHttpClient httpclient = HttpClients.createDefault();//114.55.173.208:7002  127.0.0.1:8888 101.37.178.63
        HttpPost httpPost = new HttpPost("http://101.37.178.63/history/drivepaces-query");
        httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
        CarStateHistoryParam param = new CarStateHistoryParam();
        param.setStart_time("2017-11-03 00:00:00");
        param.setCsVin("LJ8E3C1M6HD301230");
        param.setEnd_time("2017-11-09 00:00:00");
        String s = JSON.toJSONString(param);
        String value = DigestUtils.md5Hex(s);
        String sign = HmacUtils.hmacSha1Hex("appkey", value);
        httpPost.addHeader("sign", sign);
        httpPost.addHeader("appId", "1000002");
        httpPost.setEntity(new StringEntity(s, ContentType.APPLICATION_JSON));
        CloseableHttpResponse response = httpclient.execute(httpPost);
        this.checkResponse(response);


    }


   /* @Test
    public void testQueryCarCanList() throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();//114.55.173.208:7002  127.0.0.1:8888 101.37.178.63
        HttpPost httpPost = new HttpPost("http://116.62.29.30:7007/history/cans");
        //httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
        CarCanHistoryParam param = new CarCanHistoryParam();
        param.setStart_time("2017-12-03 00:00:00");
        param.setCsVin("LJ8E3C1M6HD301230");
        //param.setCs_number(null);
        param.setEnd_time("2017-12-09 00:00:00");
        String s = JSON.toJSONString(param);
        String value = DigestUtils.md5Hex(s);
        String sign = HmacUtils.hmacSha1Hex("appkey", value);
        httpPost.addHeader("sign", sign);
        httpPost.addHeader("appId", "1000002");
        httpPost.setEntity(new StringEntity(s, ContentType.APPLICATION_JSON));
        CloseableHttpResponse response = httpclient.execute(httpPost);

        try {
            System.out.println(response.getStatusLine());
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                String result = IOUtils.toString(entity.getContent(), "UTF-8");
                System.out.println(result);
                EntityUtils.consume(entity);
            }

        } finally {
            response.close();
        }
    }
*/


    @Test
    public void testQueryChargingPaces() throws Exception {
    }



   /* public void testSaveState() throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();//114.55.173.208:7002  127.0.0.1:8888 101.37.178.63
        HttpPost httpPost = new HttpPost("http://116.62.29.30:7007/history/states");
        httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
        String s = JSON.toJSONString(null);
        String value = DigestUtils.md5Hex(s);
        httpPost.setEntity(new StringEntity(s, ContentType.APPLICATION_JSON));
        CloseableHttpResponse response = httpclient.execute(httpPost);
        this.checkResponse(response);

    }*/




    private static HashMap<String,String> getFieldsValues(Object obj) {
        HashMap<String,String> map=new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        /**
         * 基本类型、包装类型、String类型
         */
        String[] types = {"java.lang.Integer",
                "java.lang.Double",
                "java.lang.Float",
                "java.lang.Long",
                "java.lang.Short",
                "java.lang.Byte",
                "java.lang.Boolean",
                "java.lang.Character",
                "java.lang.String",
                "int", "double", "long", "short", "byte", "boolean", "char", "float"};
        for (Field f : fields) {
            f.setAccessible(true);
            try {
                for (String str : types) {
                    if (f.getType().getName().equals(str))
                        if (f.get(obj)!=null)
                            map.put(f.getName(),f.get(obj).toString());
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    private static String dealObjToParam(Object obj) {

        String result = "";
        List<String> paramList=new ArrayList<>();
        HashMap<String,String> map=getFieldsValues(obj);

        Set<String> keys=map.keySet();
        for (String key:keys){
            String value=map.get(key);
            if (null!=value&&!value.isEmpty()){
                paramList.add(key+"="+value);
            }
        }
        if (paramList.size()>0){
            result="?";
            for (int i=0;i<paramList.size();i++){
                result=result+paramList.get(i)+"&";
            }
            result=result.substring(0,result.length()-1);
            result=result.replaceAll(" ","%20");
        }

        return result;

    }


    private void checkResponse(CloseableHttpResponse response) throws IOException {
        try {
            System.out.println(response.getStatusLine());
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                String result = IOUtils.toString(entity.getContent(), "UTF-8");
                System.out.println(result);
                EntityUtils.consume(entity);
            }

        } finally {
            response.close();
        }
    }

} 
