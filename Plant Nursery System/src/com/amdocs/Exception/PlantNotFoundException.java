package com.amdocs.Exception;

public class PlantNotFoundException extends Exception{
	private String message;
	
	public PlantNotFoundException()
	{}
	
	public PlantNotFoundException(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "PlantNotFoundException [message=" + message + "]";
	}


}
