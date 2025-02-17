package fr.vicalvez.avaj.simulator.objects.aircraft;

import java.util.Arrays;

public enum AircraftType {

	BALOON("Baloon", Baloon.class),
	HELICOPTER("Helicopter", Helicopter .class),
	JET_PLANE("JetPlane", JetPlane.class)

	;

	private final String type;
	private final Class<? extends Flyable> clazz;

	AircraftType(String type, Class<? extends Flyable> clazz)
	{
		this.type = type;
		this.clazz = clazz;
	}

	public static AircraftType getByType(String type)
	{
		return Arrays.stream(values()).filter(aircraftType -> aircraftType.getType().equalsIgnoreCase(type)).findFirst().orElse(null);
	}

	public static AircraftType getByClass(Class<? extends Flyable> clazz)
	{
		return Arrays.stream(values()).filter(aircraftType -> aircraftType.getClazz() == clazz).findFirst().orElse(null);
	}

	public Class<? extends Flyable> getClazz() {
		return clazz;
	}

	public String getType() {
		return type;
	}

	public static AircraftType getByFlyable(Flyable flyable)
	{
		return getByClass(flyable.getClass());
	}
}
