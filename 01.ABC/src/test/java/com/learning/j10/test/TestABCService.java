package com.learning.j10.test;

import static com.learning.j10.utility.Utility.in;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.learning.j10.model.ABC;
import com.learning.j10.service.ABCService;

public class TestABCService {

	@Test
	@DisplayName("Checking for ABC displayMode=abc, highlight=abc")
	public void test1() {
		
		ABCService service = new ABCService();
		
		String displayMode = "abc"; // vow, abc, con
		String highlight = "abc"; 
		
		/*
		 * displayMode = abc, highlight = abc    -  show everything and highlight nothing
		 * displayMode = abc, highlight = vow    -  show everything and highlight vowels
		 */
		ABC[] letters = service.getAlphabets(displayMode, highlight);
		
		
		
		
		
		boolean status = letters.length == 26;
		assertTrue(status);
	
		
	}

	@Test
	@DisplayName("Checking for ABC displayMode=vow, highlight=abc")
	public void test2() {
		
		ABCService service = new ABCService();
		
		String displayMode = "vow"; // vow, abc, con
		String highlight = "abc"; 
		
		/*
		 * displayMode = vow, highlight = abc    -  show only vowels and highlight nothing
		 * displayMode = abc, highlight = vow    -  show everything and highlight vowels
		 */
		ABC[] letters = service.getAlphabets(displayMode, highlight);
		
		
		
		
		
		boolean status = letters.length == 5;
		assertTrue(status);
	
		
	}

	@Test
	@DisplayName("Checking for ABC displayMode=con, highlight=abc")
	public void test3() {
		
		ABCService service = new ABCService();
		
		String displayMode = "con"; // vow, abc, con
		String highlight = "abc"; 
		
		/*
		 * displayMode = vow, highlight = abc    -  show only vowels and highlight nothing
		 * displayMode = abc, highlight = vow    -  show everything and highlight vowels
		 */
		ABC[] letters = service.getAlphabets(displayMode, highlight);
		
		
		
		
		
		boolean status = letters.length == 21;
		assertTrue(status);
	
		
	}
		
	}
	
	
	

