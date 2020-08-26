package com.learning.j10.service;

import java.util.Map;
import java.util.function.Function;

import com.jbbwebsolutions.dao.IQuery;
import com.jbbwebsolutions.service.IService;
import com.learning.j10.dao.TaxRuleSQLDAO;
import com.learning.j10.model.TaxRule;
import com.learning.j10.utility.Utility;

public class TaxService implements IService<Float, Float> {

	private IQuery<TaxRule> dao;

	public TaxService(IQuery<TaxRule> dao) {
		this.dao = dao;
	}
	
	public TaxService() {
		this.dao = new TaxRuleSQLDAO();
	}

	@Override
	public Float calculate(Map<String, Object> search) {

		
		TaxRuleLookupService service = new TaxRuleLookupService(this.dao);
		float salary = Utility.ifNull(search::get, "salary", 150_000f);
	
		
		Function<TaxRule,TaxRule> mapper = e -> {
			boolean status = e.getRange1() <=salary;
			boolean isLastRow = salary >= e.getRange1() && salary<=e.getRange2();
			
			if(isLastRow) {
				float taxPaid =(salary - e.getRange1()) * e.getRate();
				e.setTaxPaid(taxPaid);
			}
			else if (!status)
			e.setTaxPaid(0);
			
			return e;
		};
		
		float taxPaid = (float)service.search(search )
								.stream()
								.map(mapper)
								.mapToDouble(TaxRule::getTaxPaid)
								.sum();
		
		
		return taxPaid;
	}

}
