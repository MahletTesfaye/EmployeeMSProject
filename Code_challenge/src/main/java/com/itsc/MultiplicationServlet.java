package com.itsc;
import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/multiply")
public class MultiplicationServlet  extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter pw = res.getWriter();
		
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		int product = num1 * num2;
		
		pw.printf("The product of %s and %s is: %d", num1, num2, product);
		req.setAttribute("product", product);
		
		RequestDispatcher rd = req.getRequestDispatcher("operation");
		rd.forward(req, res);
	}
}

