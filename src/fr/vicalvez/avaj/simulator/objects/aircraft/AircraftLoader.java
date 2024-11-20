package fr.vicalvez.avaj.simulator.objects.aircraft;

public class AircraftLoader {

	public static Flyable parseFlyable(String line)
	{
		String[] params = line.split(" ");
		if (params.length != 5)
		{
			System.out.println("Invalid number of params:" + line);
			return null;
		}

		int latitude;
		int longitude;
		int height;

		try {
			latitude = Integer.parseInt(params[2]);
			longitude = Integer.parseInt(params[3]);
			height = Integer.parseInt(params[4]);
		} catch (NumberFormatException e)
		{
			System.out.println("Invalid coordinates value (must be a positive integer): " + line);
			return null;
		}

		if (height < 0 || height > 100)
		{
			System.out.println("Invalid height value (must be between 0-100): " + line);
			return null;
		}

		Coordinates coordinates = new Coordinates(latitude, longitude, height);

		Flyable flyable = AircraftFactory.getInstance().newAircraft(params[0], params[1], coordinates);
		return flyable;
	}

}
