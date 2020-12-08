package fr.game.advent.day08;

import java.util.List;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;

public class GameOne extends AbstractGame<String, Integer> {
	
	private static final String INPUT_FILENAME = "day08/input-day08-1";
	
	public GameOne() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, String::new);
	}
	
	@Override
	public Integer play(List<String> listOfInputs) {
		Program program = Program.mapToProgram(listOfInputs);
		return program.executeUntilFirstAlreadyExecutedOrEndOfProgram();
	}

}
