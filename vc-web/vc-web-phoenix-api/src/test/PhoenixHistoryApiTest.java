import com.alibaba.fastjson.JSON;
import com.ccclubs.phoenix.input.CanParam;
import com.ccclubs.phoenix.input.GbMessageParam;
import com.ccclubs.phoenix.input.Jt808PositionParam;
import com.ccclubs.phoenix.input.MqttStateParam;
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
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * PhoenixHistoryApi Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 14, 2018</pre>
 */
public class PhoenixHistoryApiTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: queryCarStateList(@RequestBody MqttStateParam param)
     */
    @Test
    public void testQueryMqttStateList() throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("http://127.0.0.1:12007/history/getMqttStates");//118.178.104.94:7007
        httpPost.setHeader("Content-Type", "application/json");
        MqttStateParam value = new MqttStateParam();
        value.setVin("LJ8E3A1M7GB001128");
        //value.setTeNumber("T6793010");
        value.setStartTime("2018-05-10 00:00:00");
        value.setEndTime("2018-05-16 18:00:00");
        value.setQueryFields("*");
        value.setPageNum(2);
        value.setPageSize(20);
        String s = JSON.toJSONString(value);
        String md5Hex = DigestUtils.md5Hex(s);
        String sign = HmacUtils.hmacSha1Hex("d@j3m&s12$@2", md5Hex);
        httpPost.addHeader("sign", sign);
        httpPost.addHeader("appId", "1000008");
        httpPost.setEntity(new StringEntity(s, ContentType.APPLICATION_JSON));
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
    public void testQueryJt808List() throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("http://127.0.0.1:12007/history/getJt808Position");//118.178.104.94:7007
        httpPost.setHeader("Content-Type", "application/json");
        Jt808PositionParam value = new Jt808PositionParam();
        value.setVin("LJ8E3A1M7GB001128");
        //value.setTeNumber("T6793010");
        value.setStartTime("2018-05-10 00:00:00");
        value.setEndTime("2018-05-16 18:00:00");
        value.setQueryFields("*");
        value.setPageNum(2);
        value.setPageSize(20);
        String s = JSON.toJSONString(value);
        String md5Hex = DigestUtils.md5Hex(s);
        String sign = HmacUtils.hmacSha1Hex("d@j3m&s12$@2", md5Hex);
        httpPost.addHeader("sign", sign);
        httpPost.addHeader("appId", "1000008");
        httpPost.setEntity(new StringEntity(s, ContentType.APPLICATION_JSON));
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
    public void testQueryCanList() throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("http://127.0.0.1:12007/history/getCan");//118.178.104.94:7007
        httpPost.setHeader("Content-Type", "application/json");
        CanParam value = new CanParam();
        value.setVin("LJ8E3C1M0HD305502");
        //value.setTeNumber("T6793010");
        value.setStartTime("2018-05-10 00:00:00");
        value.setEndTime("2018-05-16 18:00:00");
        value.setQueryFields("*");
        value.setPageNum(2);
        value.setPageSize(20);
        String s = JSON.toJSONString(value);
        String md5Hex = DigestUtils.md5Hex(s);
        String sign = HmacUtils.hmacSha1Hex("d@j3m&s12$@2", md5Hex);
        httpPost.addHeader("sign", sign);
        httpPost.addHeader("appId", "1000008");
        httpPost.setEntity(new StringEntity(s, ContentType.APPLICATION_JSON));
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
    public void testQueryGbMessageList() throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("http://127.0.0.1:12007/history/getGbMessage");//118.178.104.94:7007
        httpPost.setHeader("Content-Type", "application/json");
        GbMessageParam value = new GbMessageParam();
        value.setVin("LJ8E3A1M7GB001128");
        //value.setTeNumber("T6793010");
        value.setStartTime("2018-05-10 00:00:00");
        value.setEndTime("2018-05-16 18:00:00");
        value.setQueryFields("*");
        value.setPageNum(2);
        value.setPageSize(20);
        String s = JSON.toJSONString(value);
        String md5Hex = DigestUtils.md5Hex(s);
        String sign = HmacUtils.hmacSha1Hex("d@j3m&s12$@2", md5Hex);
        httpPost.addHeader("sign", sign);
        httpPost.addHeader("appId", "1000008");
        httpPost.setEntity(new StringEntity(s, ContentType.APPLICATION_JSON));
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

    /**
     * Method: paramTimeCheck(String startTime, String endTime)
     */
    @Test
    public void testParamTimeCheck() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = PhoenixHistoryApi.getClass().getMethod("paramTimeCheck", String.class, String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: paramCheck(String pointQueryKey, String startTime, String endTime, Integer pageNo, Integer pageSize)
     */
    @Test
    public void testParamCheck() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = PhoenixHistoryApi.getClass().getMethod("paramCheck", String.class, String.class, String.class, Integer.class, Integer.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
