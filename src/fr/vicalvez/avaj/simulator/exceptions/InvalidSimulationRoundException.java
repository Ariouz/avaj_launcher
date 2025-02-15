package fr.vicalvez.avaj.simulator.exceptions;

public class InvalidSimulationRoundException extends Exception{

	public InvalidSimulationRoundException(){}

	public InvalidSimulationRoundException(String message)
	{
		super(message);
	}

	public InvalidSimulationRoundException(Throwable cause)
	{
		super(cause);
	}

	public InvalidSimulationRoundException(String message, Throwable cause) {
		super(cause);
	}

}
