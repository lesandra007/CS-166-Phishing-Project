package com.example.demo;

import java.sql.*;

public class DatabaseConnection {

    static public Connection tryConnecting() {
        String url = "jdbc:mysql://localhost:3306/phishingdatabase";
        String username = "root";
        String password = "password";

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");
//            connection.close();
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return connection;



//        try{
//            //Class.forName("com.mysql.jdbc.Driver");
//            String url = "jdbc:mysql://" + "localhost" +":" + "3306" + "/" + "PhishingDatabase";
//
//            return DriverManager.getConnection(url, "root", "password");
//        }
//        catch(Exception e) {
//            return null;
//        }
    }
}
