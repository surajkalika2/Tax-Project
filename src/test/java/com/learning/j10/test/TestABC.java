package com.learning.j10.test;

import static com.learning.j10.utility.Utility.in;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestABC {

	@Test
	@DisplayName("Checking for X")
	public void test1() {
		
		String[] vowels = {"A","E","I","O","U"};
		String letter = "X";
		
		
		boolean status = in(letter, vowels);
		assertFalse(status);
	
		
	}
		
	}
	
	
	

