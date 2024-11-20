package fr.vicalvez.avaj.simulator.objects.aircraft.entities;

import fr.vicalvez.avaj.simulator.objects.aircraft.Aircraft;
import fr.vicalvez.avaj.simulator.objects.aircraft.Coordinates;
import fr.vicalvez.avaj.simulator.objects.utils.LoggerUtil;
import fr.vicalvez.avaj.simulator.objects.weather.WeatherProvider;
import fr.vicalvez.avaj.simulator.objects.weather.WeatherType;

public class JetPlane extends Aircraft {

	public JetPlane(long id, String name, Coordinates coordinate) {
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
				latitude += 10;;
				height += 2;
				break ;
			case RAIN:
				latitude += 5;
				break;
			case FOG:
				latitude += 1;
				break;
			case SNOW:
				height -= 7;
				break;
			default:
				break;
		}

		coordinates.setLatitude(latitude);
		coordinates.setLongitude(longitude);

		coordinates.setHeight(Math.min(height, 100));
	}
}
