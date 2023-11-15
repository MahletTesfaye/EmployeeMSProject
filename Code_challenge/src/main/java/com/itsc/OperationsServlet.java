package com.itsc;
import java.io.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("opertion")
public class OperationsServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException { 
		int sum = (int) req.getAttribute("sum");
		int product = (int) req.getAttribute("product");
		
		PrintWriter pw = res.getWriter();
		pw.println(sum);
	}
}
