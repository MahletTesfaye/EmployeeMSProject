package com.itsc;
import java.io.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddServlets extends HttpServlet{
	
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp){
//		
//	}
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
	
	PrintWriter pw = res.getWriter();
	//Retrieve values of num1 and num2 from the request
	int n1 = Integer.parseInt(req.getParameter("num1"));
	int n2 = Integer.parseInt(req.getParameter("num2"));
	
//	System.out.println(n1 + n2);
	pw.printf("The sum of %s and %s is: %d", n1, n2, n1+n2);
	}
	
}