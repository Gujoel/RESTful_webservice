package com.jersey.test;

import java.rmi.RemoteException;


import com.seeyon.apps.acepbDock.service.HelloServiceStub;
import com.seeyon.apps.acepbDock.service.HelloServiceStub.SayHello;
import com.seeyon.apps.acepbDock.service.HelloServiceStub.SayHelloResponse;
import com.seeyon.apps.acepbDock.service.HelloServiceStub.SayHelloToPerson;
import com.seeyon.apps.acepbDock.service.HelloServiceStub.SayHelloToPersonResponse;
/**
 * 但要注意的是，wsdl2java.bat命令生成的Stub类将WebService方法的参数都封装在了相应的类中，
  类名为方法名，例如，sayHelloToPerson方法的参数都封装在了SayHelloToPerson类中，
  要想调用sayHelloToPerson方法，必须先创建SayHelloToPerson类的对象实例。 
 * @author admin
 *
 */
public class AxisClient {
	public static void main(String[] args) throws RemoteException {
		//1、实例化服务类
		HelloServiceStub stub = new HelloServiceStub();  
		
		//2、实例化参数类
		SayHello say = new SayHello();
		SayHelloToPerson sayTo = new SayHelloToPerson();
		
		//3、设置参数
		sayTo.setArgs0("我是刘俊猪");
		
		
		//4、调用服务
		SayHelloResponse sayHello = stub.sayHello(say);
		SayHelloToPersonResponse sayHelloToPerson = stub.sayHelloToPerson(sayTo);
		
		//5、获取返回对象，取值
		String resp = sayHello.get_return();
		String string = sayHelloToPerson.get_return();
		
		//6、输出
		System.out.println(resp);
		System.out.println(string);
	}
}
