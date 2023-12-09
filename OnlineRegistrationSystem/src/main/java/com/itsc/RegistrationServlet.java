//package com.itsc;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.*;
//
//@WebServlet("/register")
//public class RegistrationServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/RegistrationDB", "MahiT", "Mysql94!");
//			
//			String query = "insert into users (id, name, email, password) values(?, ?, ?);";
//			PreparedStatement stmnt = conn.prepareStatement(query);
//			stmnt.setInt(1, 1);
//			stmnt.setString(2, name);
//			stmnt.setString(3, email);
//			stmnt.setString(4, password);
//			
//			stmnt.executeUpdate();
//			conn.close();
//			response.sendRedirect("Confirmation.jsp");
//		}
//		catch (ClassNotFoundException |SQLException e){
////			System.out.println("connection failed");
//			e.printStackTrace();
//		}
//		
//	}
//
//}

package com.itsc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection conn; // Declare the Connection object as an instance variable

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/RegistrationDB", "MahiT", "Mysql94!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            String query = "insert into users (name, email, password) values(?, ?, ?);";
            PreparedStatement stmnt = conn.prepareStatement(query);
            stmnt.setString(1, name);
            stmnt.setString(2, email);
            stmnt.setString(3, password);

            stmnt.executeUpdate();
            response.sendRedirect("Confirmation.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}