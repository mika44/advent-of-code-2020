package fr.game.advent.day05;

import java.util.List;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;

public class GameOne extends AbstractGame<String, Integer> {
	
	private static final String INPUT_FILENAME = "day05/input-day05-1";
	
	public GameOne() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, String::new);
	}

	@Override
	public Integer play(List<String> listOfInputs) {
		return listOfInputs.stream()
			.mapToInt(BoardingPassUtils::mapBoardingPassStringToSeatNumber)
			.max()
			.getAsInt();
	}


}
