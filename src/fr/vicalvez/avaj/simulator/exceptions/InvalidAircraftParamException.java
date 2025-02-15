package fr.vicalvez.avaj.simulator.exceptions;

public class InvalidAircraftParamException extends Exception{

	public InvalidAircraftParamException(){}

	public InvalidAircraftParamException(String message)
	{
		super(message);
	}

	public InvalidAircraftParamException(Throwable cause)
	{
		super(cause);
	}

	public InvalidAircraftParamException(String message, Throwable cause)
	{
		super(cause);
	}

}
