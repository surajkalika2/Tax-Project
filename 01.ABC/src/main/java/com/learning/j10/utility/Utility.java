package com.learning.j10.utility;

import java.util.function.Function;

public class Utility {

	
	public static <T> boolean in(T input, T... data) {

		boolean isfound = false;
		
		for (T row : data) {
			if(input.equals(row)) {
				isfound = true;
				break;
				
			}
		}
		
		return isfound;	
		
	}

	public static String isNull(Function<String,String> func, String parameter	, String defaultValue) {
		String value = func.apply(parameter);
		value = value == null ? defaultValue : value;
		
		
		return value;
	}
	// K = Key, V = Value, R = Return
	@SuppressWarnings("unchecked")
	public static <K,V,R> R ifNull(Function<K,V> func, K parameter, R defaultValue) {
		
		R value =(R) func.apply(parameter);
		value = value == null ? defaultValue : value;

		
		return value;
	}
	
	
	
}
