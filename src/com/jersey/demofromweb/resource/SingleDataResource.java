package com.jersey.demofromweb.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jersey.po.SyncRequest;
import com.jersey.po.SyncResponse;
@Path("/SyncIptvStbLogService")
public class SingleDataResource {
	    @POST  
	    @Path("/SyncInterface")  
	    @Consumes(MediaType.APPLICATION_JSON)  
	    @Produces(MediaType.APPLICATION_JSON)  
	    //接受单条请求数据SyncRequest
	    public SyncResponse syncStbLogsFromYniptvToRedisQueue(SyncRequest syncRequest){  
	        SyncResponse response = new SyncResponse();  
	        response.setResult("ok");
	        return response;  
	        }  
}
