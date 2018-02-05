package com.jersey.test;

import com.jersey.po.SyncRequest;
import com.jersey.po.SyncResponse;

public class HelloService {
	    public String sayHello(){  
	        return "hello";  
	    }     
	    public String sayHelloToPerson(String name){          
	        if(name==null){  
	            name = "nobody";  
	        }  
	        return "hello,"+name;  
	    }  
	    
	    public SyncResponse getData(SyncRequest req){
	    	SyncResponse response = new SyncResponse();
	    	String name = req.getName();
	    	response.setResult(name+"You are so handsome!");
			return response;
	    	
	    }
	}  
