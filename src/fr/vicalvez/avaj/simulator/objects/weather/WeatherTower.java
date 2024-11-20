package fr.vicalvez.avaj.simulator.objects.weather;

import fr.vicalvez.avaj.simulator.objects.aircraft.Coordinates;

public class WeatherTower extends Tower {

	public String getWeather(Coordinates coordinates)
	{
		return WeatherProvider.getInstance().getCurrentWeather(coordinates);
	}

	public void changeWeather()
	{
		super.conditionChanged();
	}

}