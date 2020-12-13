package fr.game.advent.day12;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;
import fr.game.utils.LoggerUtils;

public class GameOne extends AbstractGame<String, Integer> {
	
	private static final String INPUT_FILENAME = "day12/input-day12-1";

	private static final Logger LOGGER = LoggerUtils.getLogger();

	public GameOne() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, String::new);
	}
	

	@Override
	public Integer play(List<String> listOfInputs) {
		List<Instruction> instructions = listOfInputs.stream().map(Instruction::mapToInstruction).collect(Collectors.toList());
		Ship ship = new Ship();
		instructions.stream()
			.peek(i -> LOGGER.info(ship.toString()))
			.forEach(i -> i.executeOnShip(ship));
		LOGGER.info(ship.toString());
		return ship.getPosition().getManhattanDistance();
	}

}