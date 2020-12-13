package fr.game.advent.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;

public class GameTwo extends AbstractGame<Integer, Long> {

	private static final String INPUT_FILENAME = "day10/input-day10-1";
	
	public GameTwo() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, Integer::valueOf);
	}

	private Map<Integer, Long> cache;
	
	@Override
	public Long play(List<Integer> listOfInputs) {
		List<Integer> listOfJoltages = new ArrayList<>(listOfInputs);
		Collections.sort(listOfJoltages);
		cache = new HashMap<>();
		return numberOfArrangements(listOfJoltages, 0, 0);
	}
	

	private Long numberOfArrangements(final List<Integer> listOfJoltages, final int sourceJoltage, final int indexJoltage) {
		if (indexJoltage >= listOfJoltages.size()) return 1L;
	
		Long numberOfArrangements = cache.get(indexJoltage);
		if (numberOfArrangements == null) {
			numberOfArrangements = 0L;
			int currentIndex = indexJoltage + 2;
			while (currentIndex >= indexJoltage) {
				if (currentIndex < listOfJoltages.size() && listOfJoltages.get(currentIndex) <= sourceJoltage + 3) {
					numberOfArrangements = numberOfArrangements + numberOfArrangements(listOfJoltages, listOfJoltages.get(currentIndex), currentIndex + 1);
				}
				currentIndex--;
			}
			cache.put(indexJoltage, numberOfArrangements);
		}
		return numberOfArrangements;
	}

}
