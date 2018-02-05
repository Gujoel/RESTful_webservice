package com.jersey.po;

public enum MediaType {
	//1、Define an enum Object with parameter in enum a class.
	APPLICATION_JSON("application/json");
	//2、Provide property for  enum Object.
	private String type;
	//3、Provide Constructor for  enum Object.
	MediaType(String str){
		this.type = str;
	}
	public String getType() {
		return type;
	}
	
}
