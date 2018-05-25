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
 * @since <pre>5月, 14日, 2018年</pre>
 */
public class PhoenixHistoryApiTest {

    //Phoenix node1 正式    ：   118.178.104.94:7007
    //Phoenix node2 正式    ：   114.55.236.120:7007
    //本地                  ：   127.0.0.1:12007
    //SLB 正式              ：   101.37.178.63

    private static final String IP="114.55.236.120:7007";

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

        HttpPost httpPost = new HttpPost("http://"+IP+"/history/getMqttStates");
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

        HttpPost httpPost = new HttpPost("http://"+IP+"/history/getJt808Position");//118.178.104.94:7007  101.37.178.63
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

        HttpPost httpPost = new HttpPost("http://"+IP+"/history/getCan");//118.178.104.94:7007
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

        HttpPost httpPost = new HttpPost("http://"+IP+"/history/getGbMessage");//118.178.104.94:7007
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

} 
