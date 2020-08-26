package com.learning.j10.test.jdbc;

public class WaterService implements AutoCloseable{

	@Override
	public void close() throws Exception {
	System.out.println("Closing Water.......: ");
		
	}

}
