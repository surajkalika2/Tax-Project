package com.learning.j10.test.security;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.citytech.basicsecurity.SimpleEncryption;

public class T1 {

	@Test
	public void Test1() {
		String encyptedPassword = SimpleEncryption.encrypt("password1234");
		String result = "#!Z?!ZZ!ZH?ZZ)((?(?((H!(X?(X?($F$#((";
		
		assertEquals(encyptedPassword, result);
		//String depcryptedPassword = SimpleEncryption.decrypt(encyptedPassword);
	}
	
}
