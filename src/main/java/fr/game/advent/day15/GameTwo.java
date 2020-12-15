package fr.game.advent.day15;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;

public class GameTwo extends AbstractGame<String, Long> {
	
	private static final int INDEX_SEARCHED_NUMBER = 30_000_000;
	private static final String INPUT_FILENAME = "day15/input-day15-1";

	public GameTwo() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, String::new);
	}

	
	private Map<Long, Long> lastPositionOfValues;
	
	@Override
	public Long play(final List<String> listOfInputs) {
		List<Long> numbers = Arrays.stream(listOfInputs.get(0).split(",")).map(Long::valueOf).collect(Collectors.toList());

		lastPositionOfValues = new HashMap<>();
		for (int i = 0; i < numbers.size() - 1; i++) {
			lastPositionOfValues.put(numbers.get(i), 1L + i);
		}
		
		long lastNumber = numbers.get(numbers.size() - 1);
		long turn = numbers.size() + 1;
		while (turn <= INDEX_SEARCHED_NUMBER) {
			lastNumber = playNewTurn(lastNumber, turn);
			turn++;
		}
		return lastNumber;
	}

	private long playNewTurn(final long lastNumber, final long turn) {
		Long lastPositionLastNumber = lastPositionOfValues.get(lastNumber);
		long newLastNumber =  (lastPositionLastNumber == null) ? 0L : turn - 1 - lastPositionLastNumber;
		lastPositionOfValues.put(lastNumber, turn - 1);
		return newLastNumber;
	}

}