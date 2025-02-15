package fr.vicalvez.avaj.simulator.exceptions;

public class ScenarioNotFoundException extends Exception{

	public ScenarioNotFoundException(){}

	public ScenarioNotFoundException(String message)
	{
		super(message);
	}

	public ScenarioNotFoundException(Throwable cause)
	{
		super(cause);
	}

	public ScenarioNotFoundException(String message, Throwable cause)
	{
		super(cause);
	}

}
