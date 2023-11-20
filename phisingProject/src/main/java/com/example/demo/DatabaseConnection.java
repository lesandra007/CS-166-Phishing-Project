package com.example.demo;

import java.sql.*;

public class DatabaseConnection {

    static public Connection tryConnecting(){
        try{
            //Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://" + "localhost" +":" + "3306" + "/" + "phising";

            return DriverManager.getConnection(url, "root", "password123");
        }
        catch(Exception e) {
            return null;
        }
    }
}
