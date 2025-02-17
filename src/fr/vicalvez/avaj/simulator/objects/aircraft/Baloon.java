package fr.vicalvez.avaj.simulator.objects.aircraft;

import fr.vicalvez.avaj.simulator.objects.weather.WeatherProvider;
import fr.vicalvez.avaj.simulator.objects.weather.WeatherType;

public class Baloon extends Aircraft {

	public Baloon(long id, String name, Coordinates coordinate) {
		super(id, name, coordinate);
	}

	public void updateConditions()
	{
		super.updateConditions();

		int latitude = coordinates.getLatitude();
		int longitude = coordinates.getLongitude();
		int height = coordinates.getHeight();

		WeatherType weatherType = WeatherType.getByWeatherId(WeatherProvider.getInstance().getCurrentWeather(this.coordinates));
		switch (weatherType)
		{
			case SUN:
				longitude += 2;
				height += 4;
				break ;
			case RAIN:
				height -= 5;
				break;
			case FOG:
				height -= 3;
				break;
			case SNOW:
				height -= 15;
				break;
			default:
				break;
		}
		coordinates = new Coordinates(latitude, longitude, Math.min(height, 100));
	}

}
