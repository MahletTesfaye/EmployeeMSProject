package com.itsc.ioc.Messageioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessagingApp {
	public static void main (String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("message-config.xml");
		MessageService messanger = context.getBean("email", MessageService.class);
		messanger.sendMessage("Hi!");
		
	}
}
