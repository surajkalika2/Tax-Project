package com.learning.j10.dao;

import java.util.List;

import com.jbbwebsolutions.dao.IQuery;
import com.jbbwebsolutions.dao.IUpdate;
import com.jbbwebsolutions.exception.DataRepositoryCustomException;
import com.jbbwebsolutions.utility.ESQL;
import com.jbbwebsolutions.utility.SQLExecutable;
import com.jbbwebsolutions.utility.SQLUtility;
import com.learning.j10.model.Clients;
import com.learning.j10.model.TaxRule;
import com.learning.j10.utility.GLOBAL;

public class clientSQLDAO extends AbstractClientDAO {
	
private ESQL eSQL;
private String url;
private final static String SQL = " SELECT CLIENTID, FIRSTNAME, LASTNAME, CURRENTSALARY, STATUS "
									+ "FROM TAXUSER.CLIENTS " 
									+ "where (1 = 1)";

private final static String DELETE_SQL
		= 	" DELETE FROM TAXUSER.CLIENTS " 
		+ 	" WHERE CLIENTID = ? "; 
	
	private String addOn;
	private Clients model;
	
	
	public clientSQLDAO(ESQL eSQL, String url) {
		super();
		this.eSQL = eSQL;
		this.url = url;
	}
	
	public clientSQLDAO() {
		this.eSQL = ESQL.DATASOURCE;
		this.url = GLOBAL.SERVURL;
	}
	
	@Override
	public List<Clients> findBy(Clients model){
		addOn = SQL + " and (status = ? or 'ALL' = ?)";
		addOn +=      " and (clientID = ? or -999 = ?)";
		this.model = model;
		return this.findAll();
	}
	
	
	
	@Override
	public List<Clients> findAll() {
		
		
		
		SQLExecutable<Clients> executable = rs -> {
			
			int clientID = rs.getInt("clientID");
			String firstName = rs.getString("firstName");
			String lastName = rs.getString("lastName");
			double currentSalary = rs.getDouble("currentSalary");
			String status = rs.getString("status");
			
			return new Clients(clientID, firstName, lastName, currentSalary, status);

		};
		System.out.println("SQL SENT: " +addOn);
		System.out.println("Model: " +model);
		List<Clients> clients = SQLUtility.execute(addOn, url, eSQL, executable
								, model.getStatus(), model.getStatus()
								, model.getClientID(), model.getClientID());

		//clients.forEach(System.out::println);
		
		return clients;
	}

	@Override
	public String toString() {
		return "clientSQLDAO [eSQL=" + eSQL + ", url=" + url + "]";
	}

	

	final static String UPDATE_SQL =  " UPDATE TAXUSER.CLIENTS "  
			   		 +	" SET STATUS = ? , CURRENTSALARY = ?   " 
			   		 +	" WHERE CLIENTID = ? ";
	
	@Override
	public int save(Clients client) throws DataRepositoryCustomException{

    	int status = 0;
		try {
			status = SQLUtility.update(UPDATE_SQL, url, eSQL 
					, client.getStatus()
					, client.getCurrentSalary()
					, client.getClientID());
		} catch (Exception e) {

			throw  new DataRepositoryCustomException(e.getMessage());
		}
    	
    	
			return status;
	}

	@Override
	public int delete(Clients client) throws DataRepositoryCustomException {
		
		int status = SQLUtility.update(DELETE_SQL, url, eSQL , client.getClientID());

		return status;
	}

}
