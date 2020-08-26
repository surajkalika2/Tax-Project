package com.learning.j10.dao;

import java.util.List;

import com.jbbwebsolutions.dao.IQuery;
import com.jbbwebsolutions.exception.DataRepositoryCustomException;
import com.jbbwebsolutions.utility.ESQL;
import com.jbbwebsolutions.utility.SQLExecutable;
import com.jbbwebsolutions.utility.SQLUtility;
import com.learning.j10.model.LoginCredentials;
import com.learning.j10.utility.GLOBAL;

public class LoginDAO implements IQuery<LoginCredentials> {

	private ESQL eSQL;
	private String url;
	private String addOn;
	private LoginCredentials model;
	
	private final static String SQL = " SELECT USERID, ENCRYPTEDPASSWORD " 
									+ " FROM TAXUSER.USERIDANDENCRYPTEDPASSWORD "
									+ " where (1 = 1)";
	
	public LoginDAO(ESQL eSQL, String url) {
		super();
		this.eSQL = eSQL;
		this.url = url;
	}
	
	public LoginDAO() {
		this.eSQL = ESQL.DATASOURCE;
		this.url = GLOBAL.SERVURL;
	}
	
	@Override
	public List<LoginCredentials> findBy(LoginCredentials model) throws DataRepositoryCustomException {
		addOn = SQL + " and (USERID = ?)";
		addOn +=      " and (ENCRYPTEDPASSWORD = ?)";
		this.model = model;
		return this.findAll();
	}
	

	@Override
	public List<LoginCredentials> findAll() throws DataRepositoryCustomException {

		
		SQLExecutable<LoginCredentials> executable = rs -> {
			
			String userName = rs.getString("USERID");
			String password = rs.getString("ENCRYPTEDPASSWORD");
			
			
			return new LoginCredentials(userName, password);

		};
		System.out.println("SQL SENT: " +addOn);
		System.out.println("Model: " +model);
		List<LoginCredentials> login = SQLUtility.execute(addOn, url, eSQL, executable
								, model.getUserName()
								, model.getPassword());

		
		return login;
		
		
		
		

	}



	

}
