package fr.vicalvez.avaj.simulator.objects.aircraft;

import fr.vicalvez.avaj.simulator.objects.weather.WeatherProvider;
import fr.vicalvez.avaj.simulator.objects.weather.WeatherType;

public class Helicopter extends Aircraft {

	public Helicopter(long id, String name, Coordinates coordinate) {
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
				longitude += 10;
				height += 2;
				break ;
			case RAIN:
				longitude += 5;
				break;
			case FOG:
				longitude += 1;
				break;
			case SNOW:
				height -= 12;
				break;
			default:
				break;
		}

		coordinates = new Coordinates(latitude, longitude, Math.min(height, 100));
	}

}
