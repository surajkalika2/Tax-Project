package com.learning.j10.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.jbbwebsolutions.dao.IQuery;
import com.jbbwebsolutions.service.IService;
import com.jbbwebsolutions.utility.CSVFileUtility;
import com.jbbwebsolutions.utility.FieldMetaData;
import com.learning.j10.dao.TaxRuleCSVDAO;
import com.learning.j10.dao.TaxRuleSQLDAO;
import com.learning.j10.model.TaxRule;
import com.learning.j10.utility.Utility;

public class TaxRuleLookupService implements IService<Float, TaxRule> {

	private static final Predicate<TaxRule> pSingle = e -> e.getStatus().equals("S");
	private static final Predicate<TaxRule> pHeadOfHouseHold = e -> e.getStatus().equals("HH");
	private static final Predicate<TaxRule> pMarriedFilingJointly = e -> e.getStatus().equals("MFJ");
	private static final Predicate<TaxRule> pMarriedFilingSingle = e -> e.getStatus().equals("MFS");

	
	private static final Map< String,Predicate<TaxRule> > mapRules = new HashMap<>();
	
	static {
		mapRules.put("S", pSingle);
		mapRules.put("HH", pHeadOfHouseHold);
		mapRules.put("MFJ", pMarriedFilingJointly);
		mapRules.put("MFS", pMarriedFilingSingle);
	}
	
	
	private IQuery<TaxRule> dao = null;

	public TaxRuleLookupService() {
		dao = new TaxRuleSQLDAO();
	}
	
	public TaxRuleLookupService(IQuery<TaxRule> dao) {
		this.dao = dao;

	}
	
	@Override
	public List<TaxRule> search(Map<String, Object> search) {
		
		if(search == null) {
			return new ArrayList<>();
		}
		
		String status = Utility.ifNull(search::get, "status", "S"); //(String) search.get("status");
		int year = Utility.ifNull(search::get, "year", 2020); //(int) search.get("year");
		float salary = Utility.ifNull(search::get, "salary", 5_000f);

		Predicate<TaxRule> pInput = mapRules.get(status);
		
		
		
		pInput = pInput.and(e -> e.getYear() == year) ;
		
		
		List<TaxRule> taxRules = dao.findBy(pInput);
		
		taxRules.stream()
				.map(e -> {
					if(e.getRange1() <= salary)
					e.setMarker("*");
					return e;
				})
				.collect(Collectors.toList());
		
		return taxRules;
	}

}
