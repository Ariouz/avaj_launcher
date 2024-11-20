package fr.vicalvez.avaj.simulator.objects.weather;

import fr.vicalvez.avaj.simulator.objects.aircraft.Coordinates;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public final class WeatherProvider {

	private static WeatherProvider instance;

	private String[] weather;

	private WeatherProvider() {
		WeatherType[] weatherValues = WeatherType.values();

		weather = new String[weatherValues.length];
		for (int i = 0; i < weatherValues.length; i++)
			weather[i] = weatherValues[i].getWeatherId();
	}

	public static WeatherProvider getInstance()
	{
		if (instance == null) {
			instance = new WeatherProvider();
		}
		return instance;
	}

	public String getCurrentWeather(Coordinates coordinates)
	{
		int seed = Objects.hash(coordinates.getLatitude(), coordinates.getLongitude(), coordinates.getHeight());
		Random random = new Random(seed);

		int weatherIndex = random.nextInt(weather.length);

		return weather[weatherIndex];
	}

}
