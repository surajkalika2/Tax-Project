package com.learning.j10.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.learning.j10.model.Clients;
import com.learning.j10.utility.GLOBAL;

public class RowUpdateV1 {

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                GLOBAL.URL);
             Statement statement = conn.createStatement()) {

        	
            Clients client = new Clients(1000, "Suraj", "Kalika", 500_000, "S");
			int row = statement.executeUpdate(updateClient(client ));

            // rows affected
            System.out.println(row);

        }
        
         catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String updateClient(Clients client) {
    	
    	String SQL = "UPDATE TAXUSER.CLIENTS "  
    			   +"SET FIRSTNAME='$fname', LASTNAME='$lname', CURRENTSALARY=$salary, STATUS='$status'   " 
    			   +"WHERE CLIENTID=$clientId";
    	
    	String newSQL = SQL.replace("$fname",client.getFirstName() )
    			   	 .replace("$lname",client.getLastName() )
    			     .replace("$status",client.getStatus() )
    			   	 .replace("$salary",client.getCurrentSalary() +"" )
    			   	 .replace("$clientId",client.getClientID() +"" );
    	System.out.println(newSQL);
    	
        return newSQL;

    }
}