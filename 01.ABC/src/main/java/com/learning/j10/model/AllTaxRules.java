package com.learning.j10.model;

import java.util.ArrayList;
import java.util.List;

public class AllTaxRules {
	private int year;
	private List<TaxRule> taxRules = new ArrayList<>();

	public AllTaxRules(int year, List<TaxRule> taxRules) {
		this.year = year;
		this.taxRules = taxRules;
	}
	
	@Override
	public String toString() {
		return "AllTaxRules [year=" + year + ", taxRules=" + taxRules + "]";
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {   
		this.year = year;
	}
	public List<TaxRule> getTaxRules() {
		return taxRules;
	}
	public void setTaxRules(List<TaxRule> taxRules) {
		this.taxRules = taxRules;
	}
	
	
}
