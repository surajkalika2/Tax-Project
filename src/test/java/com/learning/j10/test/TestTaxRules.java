package com.learning.j10.test;

import static com.learning.j10.utility.Utility.in;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.learning.j10.model.TaxRule;
import com.jbbwebsolutions.service.IService;
import com.learning.j10.service.TaxRuleLookupService;
import com.learning.j10.service.TaxService;

public class TestTaxRules {
/*
	@Test
	@DisplayName("Testing Tax Paid for Single Person making 9k")
	public void test1() {
		
		
		IService<Float,Float> service = new TaxService();	

		Map<String, Object> map = new HashMap<>();
		map.put("status","S"); //Represents a Single person
		map.put("salary",9_000f);
		
		float taxPaid = service.calculate(map);
		assertEquals(900, taxPaid);
		
	}

	@Test
	@DisplayName("Testing Tax Paid for Single Person making 150k")
	public void test2() {
		
		
		IService<Float,Float> service = new TaxService();	
	
		Map<String, Object> map = new HashMap<>();
		map.put("status","S"); //Represents a Single person
		map.put("salary",150_000f);
		
		float taxPaid = service.calculate(map);
		assertEquals(30_079.50f, taxPaid);
		
	}
	
	@Test
	@DisplayName("Testing Tax Paid for Single Person making 1mil")
	public void test3() {
		
		
		IService<Float,Float> service = new TaxService();	
	
		Map<String, Object> map = new HashMap<>();
		map.put("status","S"); //Represents a Single person
		map.put("salary",1_000_000f);
		
		float taxPaid = service.calculate(map);
		assertEquals(334_427f, taxPaid);
		
	}
/*
	@Test
	@DisplayName("TestLookup, Search for all Rules")
	public void test4() {
		
		TaxRuleLookupService service = new TaxRuleLookupService();
		Map<String, Object> search = new HashMap<>();
		search.put("status", "S");
		search.put("year", 2020);
		List<TaxRule> list = service.search(search);
		
		int count = list.size();
		list.forEach(System.out::println);
		
		assertTrue(count > 5);
		
	}
	*/	
	}

	

