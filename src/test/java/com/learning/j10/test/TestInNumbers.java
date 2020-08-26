package com.learning.j10.test;

import static com.learning.j10.utility.Utility.in;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestInNumbers {

	@Test
	@DisplayName("Checking for X")
	public void test1() {
		
		String[] vowels = {"A","E","I","O","U"};
		String letter = "X";
		
		
		boolean status = in(letter, vowels);
		assertFalse(status);
	
		
	}

	@Test
	@DisplayName("Checking for Number 65")
	public void test2() {
		
		Integer[] vowels = {45,100,32,100};
		Integer letter = 65;
		
		
		boolean status = in(letter, vowels);
		assertFalse(status);
	
		
	}

	@Test
	@DisplayName("Checking for Number 10")
	public void test3() {
		
	
		
		
		boolean status = in(10, 42,43,77,100);
		assertFalse(status);
	
		
	}

	
		
	}
	
	
	

