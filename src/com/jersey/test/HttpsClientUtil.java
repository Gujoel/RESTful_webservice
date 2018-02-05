package com.jersey.test;

import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 
 */
public class HttpsClientUtil {

	/**
	 * post请求
	 * @param url
	 * @param json
	 * @return
	 */
	
	public static JSONObject doPost(String url,String json){
		//DefaultHttpClient client = new DefaultHttpClient();
		//CloseableHttpClient client = HttpClientBuilder.create().build();
		CloseableHttpClient client = HttpClients.createDefault();//Factory methods for {@link CloseableHttpClient} instances.
		//A request with an entity.
	
		HttpPost post = new HttpPost(url);
		JSONObject response = null;
		try {
			//json字符串实体
			StringEntity s = new StringEntity(json.toString());
			//设置Entity的编码及其类型
			s.setContentEncoding("UTF-8");
			s.setContentType("application/json");
			post.setEntity(s);
			HttpResponse resp = client.execute(post);
			if(resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				// An entity that can be sent or received with an HTTP message.
				HttpEntity entity = resp.getEntity();
				String result = EntityUtils.toString(entity);// 返回json格式1
				response = JSONObject.fromObject(result);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}


}

