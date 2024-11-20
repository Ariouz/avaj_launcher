package fr.vicalvez.avaj.simulator.objects.aircraft;

import fr.vicalvez.avaj.simulator.objects.weather.WeatherTower;

public abstract class Flyable {

	protected WeatherTower weatherTower;

	public abstract void updateConditions();

	public void registerTower(WeatherTower tower)
	{
		this.weatherTower = tower;
	}

}
