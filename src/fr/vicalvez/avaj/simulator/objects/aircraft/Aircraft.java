package fr.vicalvez.avaj.simulator.objects.aircraft;

import fr.vicalvez.avaj.simulator.objects.utils.LoggerUtil;
import fr.vicalvez.avaj.simulator.objects.weather.WeatherProvider;
import fr.vicalvez.avaj.simulator.objects.weather.WeatherType;

public class Aircraft extends Flyable {

	protected final long id;
	protected final String name;
	protected final Coordinates coordinates;

	protected Aircraft(long id, String name, Coordinates coordinate)
	{
		this.id = id;
		this.name = name;
		this.coordinates = coordinate;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	@Override
	public void updateConditions() {
		WeatherType weatherType = WeatherType.getByWeatherId(WeatherProvider.getInstance().getCurrentWeather(this.coordinates));
		LoggerUtil.getInstance().logWeatherChange(this, weatherType);
	}

}
