package com.learning.j10.test.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jbbwebsolutions.service.IService;
import com.jbbwebsolutions.utility.ESQL;
import com.learning.j10.dao.clientSQLDAO;
import com.learning.j10.model.Clients;
import com.learning.j10.service.ClientsLookupService;
import com.learning.j10.utility.GLOBAL;

public class TestClientDAO {

	public static void main(String[] args) {
		
		clientSQLDAO dao = new clientSQLDAO(ESQL.CONNECTION, GLOBAL.URL);
		
		IService<Clients, Clients> service = new ClientsLookupService(dao);
		
		Map<String, Object> search = new HashMap<String, Object>();
		/*
		*search.put("status", "ALL");
		*search.put("clientID", 1001);
		*/
		service.search(search)
				.forEach(System.out::println);
		
		
	}
	@Test
	@DisplayName("Testing for Id 1001")
	public void t1(){
		
		clientSQLDAO dao = new clientSQLDAO(ESQL.CONNECTION, GLOBAL.URL);
		
		IService<Clients, Clients> service = new ClientsLookupService(dao);
		
		Map<String, Object> search = new HashMap<String, Object>();
		
		search.put("status", "ALL");
		search.put("clientID", 1001);
		
		int count = service.search(search).size();
		
		assertEquals(1, count);
		
	}
	@Test
	@DisplayName("Testing for no parameter passed in ")
	public void t2(){
		
		clientSQLDAO dao = new clientSQLDAO(ESQL.CONNECTION, GLOBAL.URL);
		
		IService<Clients, Clients> service = new ClientsLookupService(dao);
		
		Map<String, Object> search = new HashMap<String, Object>();
		
		
		
		int size = service.search(search).size();
		
		assertTrue(size >100);
		
	}
	
	@Test
	@DisplayName("Testing for status equal to ALL ")
	public  void t3() {
		
		clientSQLDAO dao = new clientSQLDAO(ESQL.CONNECTION, GLOBAL.URL);
		
		IService<Clients, Clients> service = new ClientsLookupService(dao);
		
		Map<String, Object> search = new HashMap<String, Object>();
		
		search.put("status", "ALL");
		
		int count = service.search(search).size();
		
		assertTrue(count > 100);
		
		
		
	}
	@Test
	@DisplayName("Client Update, for record 1002")
	public  void t4() {
		
		clientSQLDAO dao = new clientSQLDAO(ESQL.CONNECTION, GLOBAL.URL);
		
		IService<Clients, Clients> service = new ClientsLookupService(dao);
		
		
		Clients client = new Clients();
		client.setStatus("S");
		service.save(client );
		
		
		
		//assertTrue(count > 100);
		
		
		
	}
	

}
