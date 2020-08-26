package com.learning.j10.test.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLIntegrityConstraintViolationException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jbbwebsolutions.exception.DataRepositoryCustomException;
import com.jbbwebsolutions.utility.ESQL;
import com.jbbwebsolutions.utility.SQLUtility;
import com.learning.j10.dao.clientSQLDAO;
import com.learning.j10.model.Clients;
import com.learning.j10.utility.GLOBAL;

public class RowUpdateV5 {
    
    @Test
    @DisplayName("Testing for Exception")
    public void t1() {
    
    	Assertions.assertThrows(DataRepositoryCustomException.class, () -> {
        	TestInvalidStatus();

    	});
    }
    
    
    public static void TestInvalidStatus() {
    	
    	ESQL eSQL = ESQL.CONNECTION;
		String url = GLOBAL.URL;
		clientSQLDAO dao = new clientSQLDAO(eSQL, url);
    	
    	Clients client = new Clients();
    	client.setClientID(1002);
    	
    	/* MFY is an invalid status that we are testing */
    	client.setStatus("MFY");
    	
		int status = dao.save(client );
		
		assertEquals(status, 1);
    	
    }
    
    @Test
    @DisplayName("Testing for ID 1002")
    public void t2() {

    	ESQL eSQL = ESQL.CONNECTION;
		String url = GLOBAL.URL;
		clientSQLDAO dao = new clientSQLDAO(eSQL, url);
    	
    	Clients client = new Clients();
    	client.setClientID(1002);
    	client.setStatus("MFJ");
    	
		int status = dao.save(client );
		
		assertEquals(status, 1);
		
	}
}