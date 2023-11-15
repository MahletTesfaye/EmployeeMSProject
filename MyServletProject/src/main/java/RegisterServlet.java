import java.io.*;
import java.sql.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
	
	//get PrintWriter
	PrintWriter pw = resp.getWriter();
	//set content type
	resp.setContentType("text/html");
	//load the jdbc driver
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException cnf) {
		cnf.printStackTrace();
	}
	//generate the connection
	try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "Mysql94!");
		pw.println("Successfully connected!");
		Statement ps = conn.createStatement();
	} catch (SQLException se) {
		se.printStackTrace();
		pw.println("<h1>" + se.getMessage() + "</h1>");
	} catch (Exception e) {
		e.printStackTrace();
		pw.println("<h1>" + e.getMessage() + "</h1>");
		}
	}
	@Override
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doGet(req, resp);
	}
}
