package com.learning.j10.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.learning.j10.dao.TaxRuleCSVDAO;
import com.learning.j10.service.TaxService;

public class TestPaidTaxesLogic {
	
	@DisplayName("TaxService test")
	@CsvSource({"2020, S, 1000, 100"
			 ,"2020, S, 5000, 500"
			 ,"2020, S, 5500, 550"
	 })
	@ParameterizedTest
	public void test1(int year,String status, float salary, float taxOwed) {
		
	
		
		Map<String, Object> search = new HashMap<String, Object>();
		search.put("salary",salary);
		search.put("status",status);
		search.put("year", year);
		
		TaxService service = new TaxService(new TaxRuleCSVDAO());
		float taxPaid = service.calculate(search);
		
		
		assertEquals(taxPaid, taxOwed);;
	
	
		
	}
	
}
	
	
	

