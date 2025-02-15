package fr.vicalvez.avaj.simulator.exceptions;

public class InvalidFlyableException extends Exception{

	public InvalidFlyableException(){}

	public InvalidFlyableException(String message)
	{
		super(message);
	}

	public InvalidFlyableException(Throwable cause)
	{
		super(cause);
	}

	public InvalidFlyableException(String message, Throwable cause)
	{
		super(cause);
	}

}
