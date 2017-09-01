package com.ccclubs.demo.api;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.ccclubs.demo.mod.IEVPOPInput;

public class DemoApiTest {
 
	@Test
	public  void test() throws Exception, Throwable {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://127.0.0.1:8081/remoteIEVPOP");
		IEVPOPInput input = new IEVPOPInput();
		input.setClient("1"); 
		input.setHost(3);
		String s = JSON.toJSONString(input);
		String value = DigestUtils.md5Hex(s);
		String sign = HmacUtils.hmacSha1Hex("appKey", value);
		httpPost.addHeader("sign", sign);
		httpPost.addHeader("appId", "appId");
		httpPost.setEntity(new StringEntity(s));
		CloseableHttpResponse response2 = httpclient.execute(httpPost);

		try {
			System.out.println(response2.getStatusLine());
			int statusCode = response2.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				HttpEntity entity2 = response2.getEntity();

				String s2 = IOUtils.toString(entity2.getContent(), "UTF-8");
				System.out.println(s2);

				EntityUtils.consume(entity2);
			}

		} finally {
			response2.close();
		}
	}
}
