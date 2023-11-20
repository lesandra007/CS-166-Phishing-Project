package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sjsu.okta.com")
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Bean bean = new Bean(req.getParameter("student_id"), req.getParameter("password"));

        int validation = bean.store();

        System.out.println("what's in the validation var? " + validation);

        if(validation != 0){
            // TODO Should send to actual sjsu login page
            PrintWriter pr = resp.getWriter();
            pr.write("going to sjsu page");
        }
        else {
            System.out.println("Couldn't get the login information");
            req.getRequestDispatcher("signin.jsp").forward(req, resp);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("signin.jsp").forward(req, resp);
    }



}
