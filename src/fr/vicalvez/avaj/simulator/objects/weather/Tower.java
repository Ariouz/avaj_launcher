package fr.vicalvez.avaj.simulator.objects.weather;

import fr.vicalvez.avaj.simulator.objects.aircraft.Aircraft;
import fr.vicalvez.avaj.simulator.objects.aircraft.Flyable;
import fr.vicalvez.avaj.simulator.objects.aircraft.AircraftType;
import fr.vicalvez.avaj.simulator.objects.utils.LoggerUtil;

import java.util.ArrayList;
import java.util.List;

public class Tower {

	private final List<Flyable> observers = new ArrayList<>();

	public void register(Flyable flyable)
	{
		LoggerUtil.getInstance().logRegister(flyable);
		this.observers.add(flyable);
	}

	public void unregister(Flyable flyable)
	{
		AircraftType type = AircraftType.getByFlyable(flyable);
		Aircraft aircraft = (Aircraft) flyable;

		LoggerUtil.getInstance().logUnregister(flyable);
		this.observers.remove(flyable);
	}

	protected void conditionChanged()
	{
		new ArrayList<Flyable>(observers).forEach(flyable -> {
			flyable.updateConditions();

			if (!(flyable instanceof Aircraft aircraft)) return ;

			if (aircraft.getCoordinates().getHeight() <= 0)
			{
				LoggerUtil.getInstance().logLand(flyable);
				this.unregister(flyable);
			}
		});
	}

}
