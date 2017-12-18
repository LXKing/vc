import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONObject;
import com.ccclubs.frm.spring.util.DESUtil;
import com.ccclubs.terminal.dto.TerminalListQryInput;
import com.ccclubs.terminal.dto.TerminalQryInput;
import com.ccclubs.terminal.dto.VersionQryInput;
import com.ccclubs.vehicle.dto.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 参数注解测试
 *
 * @author jianghaiyang
 * @create 2017-07-06
 **/
public class TestVtsearch {

    @Test
    public void vehicleRegister() throws Exception, Throwable {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("http://127.0.0.1:8081/operate/vehicleRegister");//114.55.109.165:7001
        httpPost.setHeader("Content-Type", "application/json");
//        String ss = "{\"inputs\":[{\"csvColorCode\":\"1\",\"csvModel\":\"A800\",\"teNo\":\"CFXT31603230126\",\"csvBataccuCode\":\"222\",\"csvCarNo\":\"浙A31233\",\"csvProdDate\":\"2017-12-1\",\"csvVin\":\"212334\",\"csvEngineNo\":\"222\"}]}";
        String ss = "{\"inputs\":[{\"csvColorCode\":0,\"csvModel\":\"S_EADO17H_\",\"csvProdDate\":\"2017-12-03\",\"csvVin\":\"LS5A2AJX1HJ700001\",\"csvCertific\":\"WDV036017154771\",\"csvEngineNo\":\"HD1J000657\"}]}";
        String value = DigestUtils.md5Hex(ss);
        String sign = HmacUtils.hmacSha1Hex("fa@sd_n38f2f_3qb", value);
        httpPost.addHeader("sign", sign);
        httpPost.addHeader("appId", "1000005");
        httpPost.setEntity(new StringEntity(ss, ContentType.APPLICATION_JSON));
        CloseableHttpResponse response = httpclient.execute(httpPost);

        try {
            System.out.println(response.getStatusLine());
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();

                String s2 = IOUtils.toString(entity.getContent(), "UTF-8");
                System.out.println(s2);

                EntityUtils.consume(entity);
            }

        } finally {
            response.close();
        }
    }

    @Test
    public void modelRegister() throws Exception, Throwable {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("http://127.0.0.1:8081/operate/modelRegister");
        httpPost.setHeader("Content-Type", "application/json");
        String ss = "{\"inputs\":[{\"csmName\":\"信息\",\"csmFlag\":\"1\",\"csmType\":\"1\",\"csmFile\":\"1\",\"csmCatagory\":\"1\",\"csmTankCapacity\":\"1.2\",\"csmBatteryCapacity\":\"2.4\"},{\"csmName\":\"qqq\",\"csmFlag\":\"www2eee\",\"csmType\":\"2\",\"csmFile\":\"0\",\"csmCatagory\":\"2\",\"csmTankCapacity\":\"5\",\"csmBatteryCapacity\":\"0\"}]}";
        String value = DigestUtils.md5Hex(ss);
        String sign = HmacUtils.hmacSha1Hex("appkey", value);
        httpPost.addHeader("sign", sign);
        httpPost.addHeader("appId", "1000002");
        httpPost.setEntity(new StringEntity(ss, ContentType.APPLICATION_JSON));
        CloseableHttpResponse response = httpclient.execute(httpPost);

        try {
            System.out.println(response.getStatusLine());
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                String s2 = IOUtils.toString(entity.getContent(), "UTF-8");
                System.out.println(s2);

                EntityUtils.consume(entity);
            }

        } finally {
            response.close();
        }
    }

    @Test
    public void searchTerminalInfo() throws Exception, Throwable {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //114.55.109.165:7001
        HttpPost httpPost = new HttpPost("http://101.37.178.63/search/searchTerminalInfo");
        httpPost.setHeader("Content-Type", "application/json");
        TerminalListQryInput input = new TerminalListQryInput();
        input.setKey("6710");

        String ss = JSON.toJSONString(input);
        System.err.println(ss);
        String value = DigestUtils.md5Hex(ss);
        String sign = HmacUtils.hmacSha1Hex("lfj@qew#ofj_gq", value);
        httpPost.addHeader("sign", sign);
        httpPost.addHeader("appId", "1000003");
        httpPost.setEntity(new StringEntity(ss, ContentType.APPLICATION_JSON));
        CloseableHttpResponse response = httpclient.execute(httpPost);

        try {
            System.out.println(response.getStatusLine());
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();

                String s2 = IOUtils.toString(entity.getContent(), "UTF-8");
                System.out.println(s2);

                EntityUtils.consume(entity);
            }

        } finally {
            response.close();
        }
    }

    @Test
    public void isLatestVersion() throws Exception, Throwable {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //114.55.109.165:7001
        HttpPost httpPost = new HttpPost("http://101.37.178.63/search/isLatestVersion");
        httpPost.setHeader("Content-Type", "application/json");
        VersionQryInput input = new VersionQryInput();
        input.setVin("LJ8E3C1M9GB003295");

        String ss = JSON.toJSONString(input);
        System.err.println(ss);
        String value = DigestUtils.md5Hex(ss);
        String sign = HmacUtils.hmacSha1Hex("appkey", value);
        httpPost.addHeader("sign", sign);
        httpPost.addHeader("appId", "1000002");
        httpPost.setEntity(new StringEntity(ss, ContentType.APPLICATION_JSON));
        CloseableHttpResponse response = httpclient.execute(httpPost);

        try {
            System.out.println(response.getStatusLine());
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();

                String s2 = IOUtils.toString(entity.getContent(), "UTF-8");
                System.out.println(s2);

                EntityUtils.consume(entity);
            }

        } finally {
            response.close();
        }
    }

    @Test
    public void unbindVehicle() throws Exception, Throwable {
        CloseableHttpClient httpclient = HttpClients.createDefault();//127.0.0.1:8081
        HttpPost httpPost = new HttpPost("http://127.0.0.1:8081/operate/unbindVehicle");
        httpPost.setHeader("Content-Type", "application/json");
        UnBindVehicleInput input = new UnBindVehicleInput();
        input.setVin("LJ8E3C1M4GB003303");//LJ8E3C1M4GB003303
        input.setTeNo("CFXT31603230127");//CFXT31603230127
        String ss = JSON.toJSONString(input);
        System.err.println(ss);
        String value = DigestUtils.md5Hex(ss);
        String sign = HmacUtils.hmacSha1Hex("appkey", value);
        httpPost.addHeader("sign", sign);
        httpPost.addHeader("appId", "1000002");
        httpPost.setEntity(new StringEntity(ss, ContentType.APPLICATION_JSON));
        CloseableHttpResponse response = httpclient.execute(httpPost);

        try {
            System.out.println(response.getStatusLine());
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();

                String s2 = IOUtils.toString(entity.getContent(), "UTF-8");
                System.out.println(s2);

                EntityUtils.consume(entity);
            }

        } finally {
            response.close();
        }
    }

    @Test
    public void bindVehicle() throws Exception, Throwable {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("http://101.37.178.63/operate/bindVehicle");
        httpPost.setHeader("Content-Type", "application/json");
        UnBindVehicleInput input = new UnBindVehicleInput();
        input.setVin("LS5A2AJX2GA001281");
        input.setTeNo("67D1943");
        String ss = JSON.toJSONString(input);
        System.err.println(ss);
        String value = DigestUtils.md5Hex(ss);
        String sign = HmacUtils.hmacSha1Hex("fa@sd_n38f2f_3qb", value);
        httpPost.addHeader("sign", sign);
        httpPost.addHeader("appId", "1000005");
        httpPost.setEntity(new StringEntity(ss, ContentType.APPLICATION_JSON));
        CloseableHttpResponse response = httpclient.execute(httpPost);

        try {
            System.out.println(response.getStatusLine());
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();

                String s2 = IOUtils.toString(entity.getContent(), "UTF-8");
                System.out.println(s2);

                EntityUtils.consume(entity);
            }

        } finally {
            response.close();
        }
    }
    @Test
    public void getTerminal() throws Exception, Throwable {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("http://101.37.178.63/search/getTerminalInfo");
        httpPost.setHeader("Content-Type", "application/json");
        TerminalQryInput input = new TerminalQryInput();
        input.setVin("LS5A2AJX0FA000774");//LJ8E3C1M9GB003314 富士康 LJ8E3C1M8GB007676 中导  HZ60112345678 tl
        String ss = JSON.toJSONString(input);
        System.err.println(ss);
        String value = DigestUtils.md5Hex(ss);
        String sign = HmacUtils.hmacSha1Hex("fa@sd_n38f2f_3qb", value);
        httpPost.addHeader("sign", sign);
        httpPost.addHeader("appId", "1000005");
        httpPost.setEntity(new StringEntity(ss, ContentType.APPLICATION_JSON));
        CloseableHttpResponse response = httpclient.execute(httpPost);

        try {
            System.out.println(response.getStatusLine());
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();

                String s2 = IOUtils.toString(entity.getContent(), "UTF-8");
                System.out.println(s2);

                EntityUtils.consume(entity);
            }

        } finally {
            response.close();
        }
    }
    @Test
    public void vehicleModify() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("http://127.0.0.1:8081/operate/vehicleModify");
        httpPost.setHeader("Content-Type", "application/json");
        ModifyVehicleInput input = new ModifyVehicleInput();
        input.setVin("LJ8E3C1M9GB003314");//LJ8E3C1M9GB003314 富士康 LJ8E3C1M8GB007676 中导
        input.setCsvProdDate("1998-11-22");
        String ss = JSON.toJSONString(input);
        System.err.println(ss);
        String value = DigestUtils.md5Hex(ss);
        String sign = HmacUtils.hmacSha1Hex("appkey", value);
        httpPost.addHeader("sign", sign);
        httpPost.addHeader("appId", "1000002");
        httpPost.setEntity(new StringEntity(ss, ContentType.APPLICATION_JSON));
        CloseableHttpResponse response = httpclient.execute(httpPost);

        try {
            System.out.println(response.getStatusLine());
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();

                String s2 = IOUtils.toString(entity.getContent(), "UTF-8");
                System.out.println(s2);

                EntityUtils.consume(entity);
            }

        } finally {
            response.close();
        }
    }

    @Test
    public void factoryVehiclePush() throws Exception, Throwable {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("http://101.37.178.63/operate/factory/vehiclePush");
        httpPost.setHeader("Content-Type", "application/json");
        VehiclePushInput input = new VehiclePushInput();
        input.setCsvVin("LJ8E3C1M3HD313884");//LJ8E3C1M9GB003314 富士康 LJ8E3C1M8GB007676 中导  HZ60112345678 tl
        input.setCsvBataccuCode("2101020A-W11#2705Z#20171202#00093");
//        input.setCsvCertific("");
        input.setCsvColorCode("红套黑");
        input.setCsvInteriorColorCode("全黑内饰");
        input.setCsvEngineNo("20171204150");
        input.setCsvInteriorColorCode("");
        input.setCsvMachine("67F5945");
        input.setCsvModel("JNJ7000EVK1");
        input.setCsvModelCode("JNJ7000EVK1-JNPMSM320-30");
        input.setCsvProdDate("2017-12-12");
        input.setCsvType("飞鱼座");

        String ss = JSON.toJSONString(input);

//        System.err.println(ss);
//        String value = DigestUtils.md5Hex(ss);
//        String sign = HmacUtils.hmacSha1Hex("fa@sd_n38f2f_3qb", value);
//        httpPost.addHeader("sign", sign);
//        httpPost.addHeader("appId", "1000005");
        httpPost.setEntity(new StringEntity(DESUtil.encrypt(ss,"0F8987F17765D72BR713A939"), ContentType.APPLICATION_JSON));
        CloseableHttpResponse response = httpclient.execute(httpPost);

        try {
            System.out.println(response.getStatusLine());
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();

                String s2 = IOUtils.toString(entity.getContent(), "UTF-8");
                System.out.println(s2);

                EntityUtils.consume(entity);
            }

        } finally {
            response.close();
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
//        System.err.println(UUID.randomUUID());
//        System.err.println(UUID.randomUUID());
//        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//        System.out.println(DigestUtils.md5Hex(Base64.encodeBase64String(UUID.randomUUID().toString().replaceAll("-", "").getBytes("UTF-8"))));
//        System.out.println(DigestUtils.md5Hex(Base64.encodeBase64String(UUID.randomUUID().toString().replaceAll("-", "").getBytes("UTF-8"))));
//        System.out.println(DigestUtils.md5Hex(Base64.encodeBase64String(UUID.randomUUID().toString().replaceAll("-", "").getBytes("UTF-8"))));
//        System.out.println(DigestUtils.md5Hex(Base64.encodeBase64String(UUID.randomUUID().toString().replaceAll("-", "").getBytes("UTF-8"))));
//        System.out.println(DigestUtils.md5Hex(Base64.encodeBase64String(UUID.randomUUID().toString().replaceAll("-", "").getBytes("UTF-8"))));
//        System.out.println(DigestUtils.md5Hex(Base64.encodeBase64String(UUID.randomUUID().toString().replaceAll("-", "").getBytes("UTF-8"))));
//        System.out.println(DigestUtils.md5Hex(Base64.encodeBase64String(UUID.randomUUID().toString().replaceAll("-", "").getBytes("UTF-8"))));
//        System.out.println(DigestUtils.md5Hex(Base64.encodeBase64String(UUID.randomUUID().toString().replaceAll("-", "").getBytes("UTF-8"))));

        int id = 1000003;
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(DigestUtils.md5Hex(String.valueOf(id) + Base64.encodeBase64String(uuid.getBytes("UTF-8")) + String.valueOf(id)));
        System.err.println("==="+"1000002".equals(Integer.toString(id)));
        System.err.println("---");
    }
}
