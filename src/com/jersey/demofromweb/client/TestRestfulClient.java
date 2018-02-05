package com.jersey.demofromweb.client;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.jersey.po.SyncRequest;
import com.jersey.po.SyncResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestRestfulClient {

  //请求的url
 final static String serhost = "http://localhost:8080/RESTful_webService/rest/SyncIptvStbLogService";
 //拼接url
 final static String synciptvlog = serhost + "/SyncInterface";
 //使用jersey提供的client
 static Client client = Client.create();
 //使用jersey对象映射类：数据转换
 static ObjectMapper mapper = new ObjectMapper();

 public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException{
  System.out.println();
  //调用客户端请求代码
  mapper.writeValueAsString(TestSyncStbLogs());
 }
 
 public static SyncResponse TestSyncStbLogs(){
  //打印开始时间
  long begin = System.currentTimeMillis();
  try {
   //发送单条数据：封装
   SyncRequest request = new SyncRequest();
   request.setName("xgx");

   System.out.println(">>>>>>>>>>>>req: " + mapper.writeValueAsString(request) + " serverurl:" + synciptvlog);
   //创建WebResource对象，给URL
   WebResource webResource = client.resource(synciptvlog);
   //设置响应接受参数类型并发送请求
   ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).post(ClientResponse.class, request);
   //获取响应状态
   int status = response.getStatus();
   
   System.out.println(">>>>>>>>>>>>status:" + status);
   if (status == 200) {
    //获取响应结果
    return response.getEntity(SyncResponse.class);
   } else
    return null;
  } catch (Exception ex) {
   ex.printStackTrace();
   return null;
  }finally {
    //打印请求使用的时间
   System.out.println("execute TestSyncStbLogs time:" + (System.currentTimeMillis()-begin));
  }
 }
}