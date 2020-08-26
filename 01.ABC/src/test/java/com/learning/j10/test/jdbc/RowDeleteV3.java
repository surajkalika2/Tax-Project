package com.learning.j10.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.learning.j10.model.Clients;
import com.learning.j10.utility.GLOBAL;

public class RowDeleteV3 {

    public static void main(String[] args) {


    	String SQL = "DELETE FROM TAXUSER.CLIENTS "   
    			   +"WHERE CLIENTID= ? ";
    	
    	
		try (Connection conn = DriverManager.getConnection(GLOBAL.URL);
             PreparedStatement ps = conn.prepareStatement(SQL)) {
			
            Clients client = new Clients(1000, "Suraj", "Kalika", 500_000, "S");
            
            ps.setInt(1, client.getClientID());
            
            int row = ps.executeUpdate();
            System.out.println("update status is....: " + row);
        }
        
         catch (Exception e) {
            e.printStackTrace();
        }

    }

}