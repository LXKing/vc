
import com.alibaba.fastjson.JSON;
import com.ccclubs.phoenix.input.CarStateHistoryParam;
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
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author alban
 * @create 2018-02-06
 **/

public  class PostGetTest{

    @Test
    public void postTest() throws Exception, Throwable {
        CloseableHttpClient httpclient = HttpClients.createDefault();//114.55.173.208:7002  127.0.0.1:8888 101.37.178.63
        HttpPost httpPost = new HttpPost("http://127.0.0.1:12007/history/states-query");//query  101.37.178.63  116.62.29.30:7007
        //http://101.37.178.63/history/drivepaces-query
        //httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
        CarStateHistoryParam input=new CarStateHistoryParam();
        //LS5A2AJXXGA001531
        input.setCsVin("LS5A2AJXXGA001531");
        input.setCs_number("T6710202");
        input.setStart_time("2018-02-02 10:22:29");
        input.setEnd_time("2018-02-04 14:04:55");
        String s = JSON.toJSONString(input);
        String value = DigestUtils.md5Hex(s);
        String sign = HmacUtils.hmacSha1Hex("lfj@qew#ofj_gq", value);
        httpPost.addHeader("sign", sign);
        httpPost.addHeader("appId", "1000003");
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

}

