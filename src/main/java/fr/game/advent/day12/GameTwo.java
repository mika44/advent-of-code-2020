package fr.game.advent.day12;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;
import fr.game.utils.LoggerUtils;

public class GameTwo extends AbstractGame<String, Integer> {
	
	private static final String INPUT_FILENAME = "day12/input-day12-1";

	private static final Logger LOGGER = LoggerUtils.getLogger();

	public GameTwo() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, String::new);
	}
	

	@Override
	public Integer play(List<String> listOfInputs) {
		List<InstructionWithWayPoint> instructions = listOfInputs.stream().map(InstructionWithWayPoint::mapToInstruction).collect(Collectors.toList());
		ShipAndWayPoint shipAndWayPoint = new ShipAndWayPoint();
		instructions.stream()
			.peek(i -> LOGGER.info(shipAndWayPoint.toString()))
			.forEach(i -> i.executeOnShip(shipAndWayPoint));
		LOGGER.info(shipAndWayPoint.toString());
		return shipAndWayPoint.getPosition().getManhattanDistance();
	}

}