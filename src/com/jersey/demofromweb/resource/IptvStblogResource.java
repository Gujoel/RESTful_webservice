package com.jersey.demofromweb.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jersey.po.SyncRequest;
import com.jersey.po.SyncResponse;

//二.客户端以JSON格式传递一次传递多条记录
//
    //(1)服务端代码
 @Path("/multi")
 public class IptvStblogResource {
 
@POST
 @Path("/SyncInterface")
 @Consumes(MediaType.APPLICATION_JSON)
 @Produces(MediaType.APPLICATION_JSON)
 //注意入参是数组：客户端需要发送数组
 public SyncResponse syncStbLogsFromYniptvToRedisQueue(SyncRequest[] syncRequest){
  SyncResponse response = new SyncResponse();

  for(int i =0;i<syncRequest.length;i++){
  }
  response.setResult("请求成功");
  return response;
  }
}