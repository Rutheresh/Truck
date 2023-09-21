package com.amdocs.exception;

public class TruckNotFoundException extends Exception{
	
	public TruckNotFoundException(String message) {
		System.out.println(message);
	}

}
