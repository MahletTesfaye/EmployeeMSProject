package com.itsc.ioc.Messageioc;

public class SMSService implements MessageService {

	@Override
	public void sendMessage(String message) {
		System.out.println("Message through sms: " + message);
		
	}
	
}
