package com.learning.j10.test;

import static com.learning.j10.utility.Utility.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestIfNull {

	static String booboo(String s) {
		if(s.equals("lovecode"))
			return "yes";
		
		return null;
	}
	
	static String len(String s) {
		
		
		return s.length()+"";
	}
	
	@Test
	@DisplayName("Testing ifNull (1)")
	public void test1() {
		
		String results = ifNull(TestIfNull::booboo, "lovecode", "hatecode");
		boolean status = results.equals("yes");
		
		assertTrue(status);
	}

	@Test
	@DisplayName("Testing ifNull (2)")
	public void test2() {
		
		String results = ifNull(TestIfNull::booboo, "no", "hatecode");
		boolean status = results.equals("hatecode");
		
		assertTrue(status);
	}

	@Test
	@DisplayName("Testing ifNull (3)")
	public void test3() {
		
		String results = ifNull(TestIfNull::len, "peter", "hatecode");
		boolean status = results.equals("5");
		
		assertTrue(status);
	}
	
	@Test
	@DisplayName("Testing ifNull with a Map")
	public void test4() {
		
		Map<String, Object> map = new HashMap<>();
		map.put("salary",50_000f);
		
		float results = ifNull(map::get, "salary", 0f);
		boolean status = results == (50_000f);
		
		assertTrue(status);
	}

	@Test
	@DisplayName("Testing ifNull with a Map, when key is missing")
	public void test5() {
		
		Map<String, Object> map = new HashMap<>();
		map.put("salary",50_000f);
		
		float results = ifNull(map::get, "wage", 0f);
		boolean status = results == 0;
		
		assertTrue(status);
	}
	
		
	}
	
	
	

