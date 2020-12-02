package fr.game.advent.day02;

import java.util.List;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;

public class GameTwo extends AbstractGame<String, Long> {
	
	private static final String INPUT_FILENAME = "day02/input-day02-1";
	
	public GameTwo() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, String::new);
	}

	@Override
	public Long play(List<String> listOfInputs) {
		return listOfInputs.parallelStream()
			.map(RuleDataAndPassword::mapToRuleDataAndPasswordFromString)
			.filter(new RuleGameTwo()::isPasswordRespectingTheRule)
			.count();
	}


}
