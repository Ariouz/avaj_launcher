package fr.vicalvez.avaj.simulator.objects.aircraft;

import fr.vicalvez.avaj.simulator.exceptions.InvalidAircraftParamException;

public class AircraftLoader {

	public static Flyable parseFlyable(String line) throws InvalidAircraftParamException {
		String[] params = line.split(" ");
		if (params.length != 5)
			throw new InvalidAircraftParamException("Invalid number of params:" + line);

		int latitude;
		int longitude;
		int height;

		try {
			latitude = Integer.parseInt(params[2]);
			longitude = Integer.parseInt(params[3]);
			height = Integer.parseInt(params[4]);
		} catch (NumberFormatException e){
			throw new InvalidAircraftParamException("Invalid coordinates value (must be a positive integer): " + line);
		}

		if (height < 0 || height > 100)
			throw new InvalidAircraftParamException("Invalid height value (must be between 0-100): " + line);

		Coordinates coordinates = new Coordinates(latitude, longitude, height);

		return AircraftFactory.getInstance().newAircraft(params[0], params[1], coordinates);
	}

}
