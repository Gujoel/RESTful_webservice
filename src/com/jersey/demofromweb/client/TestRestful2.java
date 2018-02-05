package com.jersey.demofromweb.client;
//----------这里最关键的重要地方是方法的入参必须是数组，注意是一个数组 SyncRequest[] syncRequest

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;

import com.jersey.po.SyncRequest;
import com.jersey.po.SyncResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

//（2）客户端代码

public class TestRestful2 {

 final static String serhost = "http://localhost:8080/RESTful_webService/rest/multi";
 final static String synciptvlog = serhost + "/SyncInterface";
 static Client client = Client.create();
 static ObjectMapper mapper = new ObjectMapper();

 public static void main(String[] args) throws IOException{
  System.out.println();
  mapper.writeValueAsString(TestSyncStbLogs());
 }
 
 public static SyncResponse TestSyncStbLogs(){
  long begin = System.currentTimeMillis();

  try {
   //多条
   SyncRequest[] request = new SyncRequest[2];
   request[0] = new SyncRequest();
   request[1] = new SyncRequest();
   request[0].setName("xp");
   request[1].setName("zyg");
 

   System.out.println(">>>>>>>>>>>>req: " + mapper.writeValueAsString(request) + " serverurl:" + synciptvlog);

   WebResource webResource = client.resource(synciptvlog);
   ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON)
     .post(ClientResponse.class, request);
   int status = response.getStatus();
   
   System.out.println(">>>>>>>>>>>>status:" + status);
   if (status == 200) {
    return response.getEntity(SyncResponse.class);
   } else
    return null;
  } catch (Exception ex) {
   ex.printStackTrace();
   return null;
  }finally {
   System.out.println("execute TestSyncStbLogs time:" + (System.currentTimeMillis()-begin));
  }
 }
}