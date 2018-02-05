package com.jersey.po;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * Rest webservic请求响应封装实体pojo
 * @author admin
 *
 */
@XmlRootElement
public class SyncResponse {
	private String result;
	
	//构造方法：无void
	public SyncResponse(){}
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}
