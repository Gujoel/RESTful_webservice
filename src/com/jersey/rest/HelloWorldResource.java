package com.jersey.rest;

	import javax.servlet.http.HttpServletResponse;
	import javax.ws.rs.*;
	import javax.ws.rs.core.*;

import com.jersey.po.SyncRequest;
import com.jersey.po.SyncResponse;
/**
 * 定义rest资源
 * @author admin
 *get/post/put/delete四种处理资源请求
 *注解：pathParam 和 QueryParam的区别：
 *		pathParam在url中传递参数
 *		QueryParam是在url请求方式的?后面传递参数
 *问题1：如何取到请求的参数？
 *问题2：四种方式的客户端请求方式如何写？
 */
	@Path("/helloworld")
	public class HelloWorldResource {
	    @Context
	    HttpServletResponse response;

	    @GET
	    @Produces(MediaType.TEXT_PLAIN)
	    @Path("/template/{name}")//http://localhost:8080/RESTful_webService/rest/helloworld/template/张超
	    public String getResult(@PathParam("name") String name){
	    	System.out.println(name);
	        return result(name);
	    }
	    
	    /**
	     * 如何取到请求的参数
	     * @param name
	     * @return
	     */
	    @POST
	    @Consumes({ MediaType.APPLICATION_JSON })
	    @Produces({ MediaType.APPLICATION_JSON })
	    public SyncResponse postResult(SyncRequest syncrequest){//http://localhost:8080/RESTful_webService/rest/helloworld
	    	 String result = result(syncrequest.getName());
	    	 SyncResponse response = new SyncResponse();
	    	 response.setResult(result);
	        return response;
	    }
	    @PUT
	    @Produces(MediaType.TEXT_PLAIN)
	    public String putResult(@QueryParam("name") String name){
	    	return result(name);
	    }
	    @DELETE
	    @Produces(MediaType.TEXT_PLAIN)
	    public String deleteResult(@QueryParam("name") String name){
	    	return result(name);
	    }

	    private String result(String name){
	        response.setCharacterEncoding("UTF-8"); // 解决变量name含有中文时出现的乱码问题
	        String msg = "My name is " + name + ", Hello World!";
	        return "{\"msg\":'"+msg+"'}";
	    }
	}
