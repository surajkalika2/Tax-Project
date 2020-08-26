package com.learning.j10.test;

import com.learning.j10.utility.Utility;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestIn {

	@Test
	@DisplayName("Checking for X")
	public void test1() {
		
		Character[] vowels = {'A','E','I','O','U'};
		Character letter = 'X';
		
		
		boolean status = Utility.in(letter, vowels);
		assertFalse(status);
		
	
		
	}

	@Test
	@DisplayName("Checking for A")
	public void test2() {
		
		Character[] vowels = {'A','E','I','O','U'};
		Character letter = 'A';
		
		
		boolean status = Utility.in(letter, vowels);
		assertTrue(status);
		
	
		
	}

	@Test
	@DisplayName("Checking for E")
	public void test3() {
		
		Character[] vowels = {'A','E','I','O','U'};
		Character letter = 'E';
		
		
		boolean status = Utility.in(letter, vowels);
		assertTrue(status);
		
	
		
	}

	
	@DisplayName("Checking for D,F,G,H,K")
	public void test4() {
		
		Character[] vowels = {'A','E','I','O','U'};
		Character letter = 'E';
		
		
		boolean status = Utility.in(letter, vowels);
		assertTrue(status);
		
	
		
	}
	
	
	
}
