package fr.game.advent.day03;

import java.util.List;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;

public class GameOne extends AbstractGame<String, Long> {
	
	private static final String INPUT_FILENAME = "day03/input-day03-1";
	
	public GameOne() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, String::new);
	}

	@Override
	public Long play(List<String> listOfInputs) {
		MapOfTrees mot = new MapOfTrees(listOfInputs);
		return countTreeCollisions(mot, 3, 1);
	}

	private Long countTreeCollisions(MapOfTrees mot, final int dx, final int dy) {
		Long countTrees = 0L;
		int x = 0;
		int y = 0;
		while (y + dy < mot.getHeight()) {
			x = x + dx;
			y = y + dy;
			if (mot.isATree(x, y)) countTrees++;
		}
		return countTrees;
	}

}
