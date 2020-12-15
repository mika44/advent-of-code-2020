package fr.game.advent.day15;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;

public class GameOne extends AbstractGame<String, Long> {
	
	private static final int INDEX_SEARCHED_NUMBER = 2020;
	private static final String INPUT_FILENAME = "day15/input-day15-1";

	public GameOne() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, String::new);
	}

	
	
	@Override
	public Long play(List<String> listOfInputs) {
		List<Long> numbers = Arrays.stream(listOfInputs.get(0).split(",")).map(Long::valueOf).collect(Collectors.toList());
		while (numbers.size() < INDEX_SEARCHED_NUMBER) {
			playNewTurn(numbers);
		}
		return numbers.get(INDEX_SEARCHED_NUMBER - 1);
	}



	private void playNewTurn(List<Long> numbers) {
		long lastNumber = numbers.get(numbers.size() - 1);
		int currentIndex = numbers.size() - 2;
		while (currentIndex > 0 && numbers.get(currentIndex) != lastNumber) {
			currentIndex--;
		}
		if (numbers.get(currentIndex) != lastNumber) {
			numbers.add(0L);
		} else {
			numbers.add(Long.valueOf(numbers.size() - 1 - currentIndex));
		}
	}

}