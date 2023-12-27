package com.itsc.ioc.Messageioc;

public class EmailService implements MessageService {

	@Override
	public void sendMessage(String message) {
		System.out.println("Message through an email: " + message);
		
	}

}
