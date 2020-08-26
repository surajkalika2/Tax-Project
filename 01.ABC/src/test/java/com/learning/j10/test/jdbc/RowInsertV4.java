package com.learning.j10.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.learning.j10.model.Clients;
import com.learning.j10.utility.GLOBAL;

public class RowInsertV4 {

    public static void main(String[] args) {


    	String SQL = "INSERT INTO TAXUSER.CLIENTS " 
    			   + "(CLIENTID, FIRSTNAME, LASTNAME, CURRENTSALARY, STATUS) "
    			   + "VALUES(?, ?, ?, ?, ?)";
    	
    	
		try (Connection conn = DriverManager.getConnection(GLOBAL.URL);
             PreparedStatement ps = conn.prepareStatement(SQL)) {
			
            Clients client = new Clients(1000, "Suraj", "Kalika", 500_000, "S");
            
            ps.setInt(1, client.getClientID());
            ps.setString(2, client.getFirstName());
            ps.setString(3, client.getLastName());
            ps.setDouble(4, client.getCurrentSalary());
            ps.setString(5, client.getStatus());
            
            int row = ps.executeUpdate();
            System.out.println("insert status is....: " + row);
        }
        
         catch (Exception e) {
            e.printStackTrace();
        }

    }

}