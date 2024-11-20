package fr.vicalvez.avaj.simulator.objects.weather;

import java.util.Arrays;

public enum WeatherType {

	RAIN("rain", "Water droplets are falling!"),
	FOG("fog", "I can't see anything :("),
	SUN("sun", "Am i flying over the Sahara ?"),
	SNOW("snow", "This weather is freezing :O")
	;

	private final String weatherId;
	private final String weatherMessage;

	WeatherType(String weatherId, String weatherMessage)
	{
		this.weatherId = weatherId;
		this.weatherMessage = weatherMessage;
	}

	public static WeatherType getByWeatherId(String weatherId)
	{
		return Arrays.stream(values()).filter(weatherType -> weatherType.getWeatherId().equals(weatherId)).findFirst().orElse(null);
	}

	public String getWeatherId() {
		return weatherId;
	}

	public String getWeatherMessage() {
		return weatherMessage;
	}
}
