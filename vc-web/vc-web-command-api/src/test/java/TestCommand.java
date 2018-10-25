import com.alibaba.fastjson.JSON;
import com.ccclubs.command.dto.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.TeeOutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;


/**
 * 指令测试
 *
 * @author jianghaiyang
 * @create 2017-07-06
 **/
public class TestCommand {

    @BeforeClass
    public static void setUpValidator() {

    }
    @Test
    public void upgrade() throws Exception, Throwable {
        CloseableHttpClient httpclient = HttpClients.createDefault();//114.55.173.208:7002  127.0.0.1:8888 101.37.178.63
        HttpPost httpPost = new HttpPost("http://101.37.178.63/command/oneKeyUpgrade");
        //httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
        UpgradeInput input = new UpgradeInput();
        input.setVin("LJ8E3C1M3GB006029");
        String s = JSON.toJSONString(input);
        String value = DigestUtils.md5Hex(s);
        String sign = HmacUtils.hmacSha1Hex("pfadf2pfavyybd", value);
        httpPost.addHeader("sign", sign);
        httpPost.addHeader("appId", "1000001");
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

    @Test
    public void sendSimpleCmd() throws Exception, Throwable {
        CloseableHttpClient httpclient = HttpClients.createDefault();//114.55.173.208:7002  127.0.0.1:8888 101.37.178.63
        HttpPost httpPost = new HttpPost("http://116.62.29.30:7004/command/sendSimpleCmd");
        //httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
        SimpleCmdInput input = new SimpleCmdInput();
        input.setVin("CHEJIZHONGXING006");
        input.setCmd(3);
        input.setResultType(2);
        String s = JSON.toJSONString(input);
        String value = DigestUtils.md5Hex(s);
        String sign = HmacUtils.hmacSha1Hex("3c9ec675b63359e884f97cab9b4f6861", value);
        httpPost.addHeader("sign", sign);
        httpPost.addHeader("appId", "1000013");
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

    @Test
    public void airConditionerMonoCtrl() throws Exception, Throwable {
        CloseableHttpClient httpclient = HttpClients.createDefault();//114.55.173.208:7002
        HttpPost httpPost = new HttpPost("http://127.0.0.1:8888/command/airConditionerMonoCtrl");
        //httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
        AirMonoInput input = new AirMonoInput();
        input.setVin("LJ8E3C1M7GB006101");
        input.setItem(2);//PTC
        input.setValue(1);//ON
        String s = JSON.toJSONString(input);
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

    @Test
    public void issueOrderData() throws Exception, Throwable {
        CloseableHttpClient httpclient = HttpClients.createDefault();//114.55.173.208:7002
        HttpPost httpPost = new HttpPost("http://127.0.0.1:8888/command/issueOrderData");
        //httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
        IssueOrderInput input = new IssueOrderInput();
        input.setVin("LJ8E3C1M7GB006101");
        input.setOrderId(2L);//PTC
        input.setStartTime("2017-07-19 09:50:00");//ON
        input.setEndTime("2017-07-19 10:50:00");//ON
        input.setGender(new Short(("1")));
        input.setRealName("test");
        input.setMobile("12564589552");
        String s = JSON.toJSONString(input);
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
    @Test
    public void timeSynchronization() throws Exception, Throwable {
        CloseableHttpClient httpclient = HttpClients.createDefault();//114.55.173.208:7002
        HttpPost httpPost = new HttpPost("http://101.37.178.63/command/timeSynchronization");
        //httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
        TimeSyncInput input = new TimeSyncInput();
        input.setVin("LJ8E3C1M7GB006101");
        input.setTime("2017-07-19 10:00:00");
        String s = JSON.toJSONString(input);
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

    @Test
    public void powerModeSwitch() throws Exception, Throwable {
        CloseableHttpClient httpclient = HttpClients.createDefault();//114.55.173.208:7002
        HttpPost httpPost = new HttpPost("http://116.62.29.30:7004/command/powerModeSwitch");
        //httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
        PowerModeInput input = new PowerModeInput();
        input.setVin("CHEJIZHONGXING006");
        input.setType(new Byte("1"));//0:标准模式,1:最佳省电模式,2:极度省电模式
        input.setSecond(new Short("100"));//休眠秒数
        String s = JSON.toJSONString(input);
        String value = DigestUtils.md5Hex(s);
        String sign = HmacUtils.hmacSha1Hex("3c9ec675b63359e884f97cab9b4f6861", value);
        httpPost.addHeader("sign", sign);
        httpPost.addHeader("appId", "1000013");
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

    @Test
    public void confirm() throws Exception, Throwable {
        CloseableHttpClient httpclient = HttpClients.createDefault();//114.55.173.208:7002
        HttpPost httpPost = new HttpPost("http://116.62.29.30:7004/command/confirm");
        ConfirmInput input = new ConfirmInput();
        input.setMessageId(11L);
        String s = JSON.toJSONString(input);
        String value = DigestUtils.md5Hex(s);
        String sign = HmacUtils.hmacSha1Hex("3c9ec675b63359e884f97cab9b4f6861", value);
        httpPost.addHeader("sign", sign);
        httpPost.addHeader("appId", "1000013");
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

    /**
     * 语音下发测试
     * */
    @Test
    public void voice()throws Exception, Throwable{
        CloseableHttpClient httpclient = HttpClients.createDefault();//114.55.173.208:7002
        HttpPost httpPost = new HttpPost("http://116.62.29.30:7004/command/voice");
        //httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
        VoiceIssuedInput input = new VoiceIssuedInput();
        input.setVin("CHEJIZHONGXING006");
        input.setVoiceNum(1);

        String s = JSON.toJSONString(input);
        String value = DigestUtils.md5Hex(s);
        String sign = HmacUtils.hmacSha1Hex("3c9ec675b63359e884f97cab9b4f6861", value);
        httpPost.addHeader("sign", sign);
        httpPost.addHeader("appId", "1000013");
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

    /**
     * 站点下发测试
     * */
    @Test
    public void site()throws Exception, Throwable{
        CloseableHttpClient httpclient = HttpClients.createDefault();//114.55.173.208:7002
        HttpPost httpPost = new HttpPost("http://116.62.29.30:7004/command/site");
        //httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
        SiteIssuedInput input = new SiteIssuedInput();
        input.setVin("CHEJIZHONGXING007");
        input.setSiteNum(1);

        String s = JSON.toJSONString(input);
        String value = DigestUtils.md5Hex(s);
        String sign = HmacUtils.hmacSha1Hex("3c9ec675b63359e884f97cab9b4f6861", value);
        httpPost.addHeader("sign", sign);
        httpPost.addHeader("appId", "1000013");
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

    @Test
    public void gpsAutoDriveCtrl() throws Throwable {
        CloseableHttpClient httpclient = HttpClients.createDefault();//114.55.173.208:7002  127.0.0.1:8888 101.37.178.63
        HttpPost httpPost = new HttpPost("http://localhost:8888/command/gpsAutoDrive");
        //httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
        GpsAutoDriveInput input = new GpsAutoDriveInput();
        input.setVin("ki6i6678")
                .setDriveCmd(1)
                .setLog("0")
                .setLat("0")
                .setResultType(2);

        setHeaderWithAuthInfo(httpPost, input, "1000016", "6v03rxubziqojalgtn");
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

    /**
     * 根据appId、appKey设置请求头部
     * @param httpPost
     * @param input
     * @param appId
     * @param appKey
     * @param <T>
     */
    private <T extends CommonInput> void setHeaderWithAuthInfo(HttpPost httpPost, T input, String appId, String appKey) {
        String inputJsonStr = JSON.toJSONString(input);
        String value = DigestUtils.md5Hex(inputJsonStr);
        String sign = HmacUtils.hmacSha1Hex(appKey, value);
        httpPost.addHeader("sign", sign);
        httpPost.addHeader("appId", appId);
        httpPost.setEntity(new StringEntity(inputJsonStr, ContentType.APPLICATION_JSON));
    }
}
