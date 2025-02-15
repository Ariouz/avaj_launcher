package fr.vicalvez.avaj.simulator;

import fr.vicalvez.avaj.simulator.exceptions.InvalidFlyableException;
import fr.vicalvez.avaj.simulator.exceptions.InvalidSimulationRoundException;
import fr.vicalvez.avaj.simulator.exceptions.MissingArgumentException;
import fr.vicalvez.avaj.simulator.exceptions.ScenarioNotFoundException;
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

		try {
			if (args.length != 1)
				throw new MissingArgumentException("Wrong args count");

			simulationRounds = parseAircrafts(args, weatherTower);
		} catch (Exception e) {
			e.printStackTrace();
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
				throw new InvalidSimulationRoundException("Simulation round is <= 0, nothing to run.");

			while (scanner.hasNextLine())
			{
				try {
					Flyable flyable = AircraftLoader.parseFlyable(scanner.nextLine());
					weatherTower.register(flyable);
					flyable.registerTower(weatherTower);
				}catch (Exception e){
					e.printStackTrace();
				}
			}

		} catch (FileNotFoundException e) {
			throw new ScenarioNotFoundException("Scenario file not found");
		} catch (NumberFormatException e) {
			throw new InvalidSimulationRoundException("Invalid simulation round number");
		}

		return simulationRounds;
	}

}
