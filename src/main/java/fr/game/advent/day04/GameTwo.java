package fr.game.advent.day04;

import java.util.List;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;

public class GameTwo extends AbstractGame<String, Long> {
	
	private static final String INPUT_FILENAME = "day04/input-day04-1";
	
	public GameTwo() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, String::new);
	}

	@Override
	public Long play(List<String> listOfInputs) {
		return PassportUtils.mapToPassportStream(listOfInputs)
				.filter(Passport::isValid)
				.count();
	}

}
