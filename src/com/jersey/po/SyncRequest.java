package com.jersey.po;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Rest webservice请求数据封装的pojo
 * @author admin
 *关键：使用注解--@XmlRootElement
 */
@XmlRootElement(name="syncrequest")
public class SyncRequest {
	private String name;
	
	public SyncRequest(){}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
