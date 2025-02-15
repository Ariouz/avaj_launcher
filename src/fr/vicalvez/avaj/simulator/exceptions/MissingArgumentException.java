package fr.vicalvez.avaj.simulator.exceptions;

public class MissingArgumentException extends Exception{

	public MissingArgumentException(){}

	public MissingArgumentException(String message)
	{
		super(message);
	}

	public MissingArgumentException(Throwable cause)
	{
		super(cause);
	}

	public MissingArgumentException(String message, Throwable cause)
	{
		super(cause);
	}

}
