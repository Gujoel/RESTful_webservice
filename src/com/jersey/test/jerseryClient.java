package com.jersey.test;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jersey.po.SyncRequest;
import com.jersey.po.SyncResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * restful 客服端调用//HttpPost请求
 * @author admin
 *单条数据测试
 *jersey框架简单方便
 */
public class jerseryClient {
	public static void main(String[] args) throws IOException{
		//jackson的mapper对象
		ObjectMapper mapper = new ObjectMapper();
		 //jersey创建client客户端
		 Client client = Client.create();
		 WebResource webResource = client.resource("http://localhost:8080/RESTful_webService/rest/helloworld");
		
		SyncRequest req = new SyncRequest();
		req.setName("xgx");
	//	String string = mapper.writeValueAsString(req);
		//提交请求MediaType.APPLICATION_JSON不是枚举：使用的是静态变量:也可以使用枚举
		String type = MediaType.APPLICATION_JSON;
		   ClientResponse response = webResource.accept(type).type(MediaType.APPLICATION_JSON)
				     .post(ClientResponse.class, req);
		   int status = response.getStatus();
		   //接受放回数据
		SyncResponse entity = response.getEntity(SyncResponse.class);
		String string = mapper.writeValueAsString(entity);
		System.out.println(string);//{"result":"{\"msg\":'My name is xgx, Hello World!'}"}
		
	}
}
