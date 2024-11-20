package fr.vicalvez.avaj.simulator;

import fr.vicalvez.avaj.simulator.objects.aircraft.AircraftLoader;
import fr.vicalvez.avaj.simulator.objects.aircraft.Flyable;
import fr.vicalvez.avaj.simulator.objects.utils.LoggerUtil;
import fr.vicalvez.avaj.simulator.objects.weather.WeatherTower;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Simulator {

	public static void main(String[] args)
	{
		WeatherTower weatherTower = new WeatherTower();
		int simulationRounds = 0;

		if (args.length != 1)
		{
			System.out.println("Wrong args count");
			return ;
		}

		try {
			simulationRounds = parseAircrafts(args, weatherTower);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		runSimulation(simulationRounds, weatherTower);
	}

	public static void runSimulation(int simulationRounds, WeatherTower tower)
	{
		for (int i = 0; i < simulationRounds; i++)
		{
			tower.changeWeather();
		}

		try {
			LoggerUtil.getInstance().getFileWriter().close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static int parseAircrafts(String[] args, WeatherTower weatherTower) throws Exception {
		File scenario = new File(args[0]);
		int simulationRounds = 0;

		try {
			Scanner scanner = new Scanner(scenario);

			if (scanner.hasNextLine()) simulationRounds = Integer.parseInt(scanner.nextLine());

			if (simulationRounds <= 0)
				throw new Exception("Simulation round is <= 0, nothing to run.");

			while (scanner.hasNextLine())
			{
				Flyable flyable = AircraftLoader.parseFlyable(scanner.nextLine());
				if (flyable == null)
					throw new Exception("Flyable is invalid");
				weatherTower.register(flyable);
				flyable.registerTower(weatherTower);
			}

		} catch (FileNotFoundException e) {
			throw new Exception("File doesn't exist");
		} catch (NumberFormatException e) {
			throw new Exception("Invalid simulation round number");
		}

		return simulationRounds;
	}

}
