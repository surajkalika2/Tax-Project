package com.learning.j10.service;

import java.util.List;
import java.util.Map;

import com.citytech.basicsecurity.SimpleEncryption;
import com.jbbwebsolutions.dao.IQuery;
import com.jbbwebsolutions.exception.CustomException;
import com.jbbwebsolutions.service.IService;
import com.learning.j10.dao.LoginDAO;
import com.learning.j10.model.LoginCredentials;

public class LoginService implements IService<String, Boolean> {

	private IQuery<LoginCredentials> dao = null;
	
	public LoginService() {
		this.dao = new LoginDAO();
	}
	
	
	
	public LoginService(IQuery<LoginCredentials> dao) {
		super();
		this.dao = dao;
	}

	@Override
	public Boolean calculate(Map<String, Object> search) throws CustomException {

		
		String password = search.get("password").toString();
		String userId = search.get("userId").toString();
		String encyptedPassword = SimpleEncryption.encrypt(password);

		LoginCredentials model = new LoginCredentials();
		model.setUserName(userId);
		model.setPassword(encyptedPassword);
		
		boolean isValidPassword = false;

		List<LoginCredentials> login = dao.findBy(model);
		if(!login.isEmpty()) {
			isValidPassword = true;
		}
		
	   //isValidPassword = dao.findBy(model).size() != 0;	
	   
		if(userId.equals("user-1") && password.equals("pwd-1234")) {
			isValidPassword = true; // kept this for so there's login credentials that always work for now
		}
		
		
		return isValidPassword;
	}

}
