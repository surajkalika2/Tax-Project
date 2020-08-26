package com.learning.j10.test;

import static com.learning.j10.utility.Utility.in;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestLoop {

	//Predicate
	public static boolean isEven(Integer n) {
		return n % 2 == 0;
	}
	//Consumer
	public static void booboo(int x) {
		System.out.println(x*2);
	}
	
	
	@Test
	@DisplayName("Testing Loop")
	public void test1() {
		
		System.out.println("hello world");
		
		IntConsumer x = TestLoop::booboo;
		IntConsumer y = System.out::print;
		
	IntStream.rangeClosed(1,30)
			.filter(e -> e % 2 == 0)
			.forEach(y);
	}
		
	}
	
	
	

