package com.learning.j10.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.learning.j10.model.Clients;
import com.learning.j10.utility.GLOBAL;

public class RowUpdateV2 {

    public static void main(String[] args) {


    	String SQL = "UPDATE TAXUSER.CLIENTS "  
    			   +"SET FIRSTNAME= ? , LASTNAME= ? , CURRENTSALARY= ? , STATUS= ?   " 
    			   +"WHERE CLIENTID= ? ";
    	
    	
		try (Connection conn = DriverManager.getConnection(GLOBAL.URL);
             PreparedStatement ps = conn.prepareStatement(SQL)) {
			
            Clients client = new Clients(1000, "Suraj", "Kalika", 500_000, "S");
            
            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getLastName());
            ps.setDouble(3, client.getCurrentSalary());
            ps.setString(4, client.getStatus());
            ps.setInt(5, client.getClientID());
            
            int row = ps.executeUpdate();
            System.out.println("update status is....: " + row);
        }
        
         catch (Exception e) {
            e.printStackTrace();
        }

    }

}