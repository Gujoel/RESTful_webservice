package com.jersey.po;

public class Enumtest {
	public static void main(String[] args ){
		String name1 = MediaType.APPLICATION_JSON.name();
		String name2 = MediaType.APPLICATION_JSON.toString();
		String type = MediaType.APPLICATION_JSON.getType();
		System.out.println(name1);
		System.out.println(name2);
		System.out.println(type);
		
	}
}
