package com.itsc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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
            String query = "select * from users where email = ? and password = ?";
            PreparedStatement stmnt = conn.prepareStatement(query);
            stmnt.setString(1, email);
            stmnt.setString(2, password);

            ResultSet rs = stmnt.executeQuery();
            if(rs.next()) {
            //authentication successful
	            response.sendRedirect("Welcome.jsp");
            }else {
            //authentication failed
	            response.sendRedirect("Login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}