package fr.vicalvez.avaj.simulator.objects.utils;

import fr.vicalvez.avaj.simulator.objects.aircraft.Aircraft;
import fr.vicalvez.avaj.simulator.objects.aircraft.Flyable;
import fr.vicalvez.avaj.simulator.objects.aircraft.entities.AircraftType;
import fr.vicalvez.avaj.simulator.objects.weather.WeatherType;

import javax.xml.transform.Source;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public final class LoggerUtil {

	private static LoggerUtil instance;
	private File outputFile;
	private FileWriter fileWriter;

	private LoggerUtil()
	{
		outputFile = new File("simulation.txt");
		try {
			outputFile.createNewFile();
			fileWriter = new FileWriter(outputFile);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		instance = this;
	}

	public String getStringId(Flyable flyable){
		AircraftType type = AircraftType.getByFlyable(flyable);
		Aircraft aircraft = (Aircraft) flyable;

		return String.format("%s#%s(%s)", type.getType(), aircraft.getName(), aircraft.getId());
	}

	public void logRegister(Flyable flyable)
	{
		String log = String.format("Tower says: %s registered to weather tower.\n", getStringId(flyable));
		writeLog(log);

	}

	public void logUnregister(Flyable flyable)
	{
		String log = String.format("Tower says: %s unregistered to weather tower.\n", getStringId(flyable));
		writeLog(log);
	}

	public void logWeatherChange(Flyable flyable, WeatherType weatherType)
	{
		String log = String.format("%s %s\n", getStringId(flyable), weatherType.getWeatherMessage());
		writeLog(log);
	}

	public void logLand(Flyable flyable)
	{
		String log = String.format("%s landing.\n", getStringId(flyable));
		writeLog(log);
	}

	public static LoggerUtil getInstance() {
		if (instance == null) instance = new LoggerUtil();
		return instance;
	}

	public void writeLog(String log)
	{
		try {
			fileWriter.append(log);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public FileWriter getFileWriter() {
		return fileWriter;
	}


}
