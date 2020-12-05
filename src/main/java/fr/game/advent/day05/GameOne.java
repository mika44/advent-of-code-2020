package fr.game.advent.day05;

import java.util.List;
import java.util.stream.Stream;

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
			.mapToInt(this::mapBoardingPassStringToSeatNumber)
			.max()
			.getAsInt();
	}

	/* 
	 * It's just map boarding pass to binary :
	 * - F and L converted to bit 0
	 * - B and R converted to bit 1
	 */
	private int mapBoardingPassStringToSeatNumber(String boardingPassString) {
		return Stream.iterate(0, i -> i + 1).limit(boardingPassString.length())
			.filter(i -> boardingPassString.charAt(i) == 'B' || boardingPassString.charAt(i) == 'R')
			.mapToInt(i -> 1 << (boardingPassString.length() - i - 1))
			.sum();
	}
	
}
