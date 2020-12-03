package fr.game.advent.day03;

import java.util.List;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;

public class GameTwo extends AbstractGame<String, Long> {
	
	private static final String INPUT_FILENAME = "day03/input-day03-1";
	
	public GameTwo() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, String::new);
	}

	private class Slope {
		int dx, dy;
		private Slope(int x, int y) {
			this.dx = x;
			this.dy = y;
		}
	}
	
	@Override
	public Long play(List<String> listOfInputs) {
		MapOfTrees mot = new MapOfTrees(listOfInputs);
		
		final Slope[] slopes = {
				new Slope(1, 1),
				new Slope(3, 1),
				new Slope(5, 1),
				new Slope(7, 1),
				new Slope(1, 2)
		};
		
		Long result = 1L;
		for (Slope slope : slopes) {
			result = result * countTreeCollisions(mot, slope);
		}
		return result;
	}

	private Long countTreeCollisions(MapOfTrees mot, Slope slope) {
		return countTreeCollisions(mot, slope.dx, slope.dy);
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
