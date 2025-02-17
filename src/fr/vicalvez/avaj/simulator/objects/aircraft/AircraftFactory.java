package fr.vicalvez.avaj.simulator.objects.aircraft;

import fr.vicalvez.avaj.simulator.exceptions.InvalidAircraftParamException;

public final class AircraftFactory {

	private static AircraftFactory instance;
	private int aircraftId = 1;

	private AircraftFactory() {}

	public static AircraftFactory getInstance()
	{
		if (instance == null) instance = new AircraftFactory();
		return instance;
	}

	public Flyable newAircraft(String type, String name, Coordinates coordinates) throws InvalidAircraftParamException {
		AircraftType aircraftType = AircraftType.getByType(type);
		if (aircraftType == null)
			throw new InvalidAircraftParamException("Invalid aircraft type: " + type);

		long id = aircraftId;
		aircraftId++;
		Flyable flyable;
		try {
			flyable = aircraftType.getClazz()
					.getConstructor(long.class, String.class, Coordinates.class)
					.newInstance(id, name, coordinates);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return flyable;
	}

}
