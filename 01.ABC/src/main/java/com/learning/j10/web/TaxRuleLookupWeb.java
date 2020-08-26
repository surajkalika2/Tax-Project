package com.learning.j10.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.jbbwebsolutions.utility.BasicUtility.*;
import com.learning.j10.model.AllTaxRules;
import com.learning.j10.model.TaxRule;
import com.learning.j10.service.TaxRuleLookupService;
import com.learning.j10.utility.Utility;


public class TaxRuleLookupWeb extends _AbstractWeb {
	private static final long serialVersionUID = 1L;
       
	protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mode = this.getURLPattern(request);
		int yearSelection = -999;
		if(mode.equals("taxrule-2020")) {
			yearSelection = 2020;
		}
		else if(mode.equals("taxrule-2019")) {
			yearSelection = 2019;
		}
		
		float salary = whatIfNull(request::getParameter, "salary", 52_000f, Float.class);
		
		
		int iyear = whatIfNull(request::getParameter, "year", yearSelection, Integer.class);

		String status = Utility.isNull(request::getParameter, "status", "S");
		
		String statusdesc = "";
		
		if(status.equals("S")) {
			 statusdesc = "Single";
		}
		else if(status.equals("HH")) {
			 statusdesc = "Head of House Hold";
		}
		if(status.equals("MFJ")) {
			 statusdesc = "Married Filing Jointly";
		}
		if(status.equals("MFS")) {
			 statusdesc = "Married Filing Single";
		}
		
		Integer[] years = Stream.of(2017,2018,2019,2020)
							.filter(e -> e == iyear || iyear == -999) 
							.toArray(Integer[]::new);
		
		TaxRuleLookupService service = new TaxRuleLookupService();
		Map<String, Object> search = new HashMap<>();
		
		List<AllTaxRules> rules = new ArrayList<>();

		search.put("status", status);
		search.put("salary", salary);
		for (int year : years) {
			search.put("year", year);
			List<TaxRule> taxRules = service.search(search);
			
			AllTaxRules aRule = new AllTaxRules(year, taxRules);
			rules.add(aRule);
		}
		
		request.setAttribute("developer", "kalika, suraj");
		request.setAttribute("date", new Date());
		request.setAttribute("years", years);
		request.setAttribute("rules", rules);
		request.setAttribute("salary", salary);
		
		
		
		request.setAttribute("status", statusdesc);


		
		redirect("/WEB-INF/taxrule.jsp", request, response);

		
	}



}
