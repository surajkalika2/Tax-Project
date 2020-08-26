package com.learning.j10.test.security;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.citytech.basicsecurity.SimpleEncryption;
import com.jbbwebsolutions.utility.ESQL;
import com.learning.j10.dao.LoginDAO;
import com.learning.j10.model.LoginCredentials;
import com.learning.j10.utility.GLOBAL;

public class SelectUserPassword {

	@Test
	@DisplayName("Testing for user-109")
	public void Test1() {
		
		ESQL eSQL = ESQL.CONNECTION;
		String url = GLOBAL.URL;
		LoginDAO dao = new LoginDAO(eSQL, url);
		
		LoginCredentials login = new LoginCredentials();
		
		login.setUserName("user-109");
		String encyptedPassword = SimpleEncryption.encrypt("password1243");
		login.setPassword(encyptedPassword);
		
		int status = dao.findBy(login).size();
		
		assertEquals(status, 1);

		
	}
	@Test
	@DisplayName("Testing for user-109 failure using wrong password")
	public void Test2() {
		
		ESQL eSQL = ESQL.CONNECTION;
		String url = GLOBAL.URL;
		LoginDAO dao = new LoginDAO(eSQL, url);
		
		LoginCredentials login = new LoginCredentials();
		
		login.setUserName("user-109");
		String encyptedPassword = SimpleEncryption.encrypt("password1234");
		login.setPassword(encyptedPassword);
		
		int status = dao.findBy(login).size();
		
		assertEquals(status, 0);

		
	}
	
	@Test
	@DisplayName("Testing for all(31) user and passwords")
	public void Test3() {
		
		ESQL eSQL = ESQL.CONNECTION;
		String url = GLOBAL.URL;
		LoginDAO dao = new LoginDAO(eSQL, url);
		
		LoginCredentials login = new LoginCredentials();
		
		String users[] = { "user-100:password1234", "user-101:password1235", "user-102:password1236",
				"user-103:password1237", "user-104:password1238", "user-105:password1239", "user-106:password1240",
				"user-107:password1241", "user-108:password1242", "user-109:password1243", "user-110:password1244",
				"user-111:password1245", "user-112:password1246", "user-113:password1247", "user-114:password1248",
				"user-115:password1249", "user-116:password1250", "user-117:password1251", "user-118:password1252",
				"user-119:password1253", "user-120:password1254", "user-121:password1255", "user-122:password1256",
				"user-123:password1257", "user-124:password1258", "user-125:password1259", "user-126:password1260",
				"user-127:password1261", "user-128:password1262", "user-129:password1263", "user-130:password1264" };		
		int status = 0;

		for (String string : users) {
			String[] data = string.split(":");			
			String spassword = SimpleEncryption.encrypt(data[1]);			
			login.setUserName(data[0]);
			login.setPassword(spassword);
			status += dao.findBy(login).size();

			
		}	
		
	
		
		
		assertEquals(status, 31);

		
	}
	
	
}
