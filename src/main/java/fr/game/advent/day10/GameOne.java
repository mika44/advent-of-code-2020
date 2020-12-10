package fr.game.advent.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;

public class GameOne extends AbstractGame<Integer, Integer> {

	private static final int INDEX_1_JOLT  = 0;
	//private static final int INDEX_2_JOLTS = 1;
	private static final int INDEX_3_JOLTS = 2;
	
	private static final String INPUT_FILENAME = "day10/input-day10-1";
	
	public GameOne() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, Integer::new);
	}

	@Override
	public Integer play(List<Integer> listOfInputs) {
		int[] numbersOfJoltDifferences = new int[3];
		List<Integer> listOfJoltages = new ArrayList<>(listOfInputs);
		listOfJoltages.add(0);
		Collections.sort(listOfJoltages);
		for (int i = 0; i < listOfJoltages.size(); i++) {
			int difference = i < listOfJoltages.size() - 1 ? listOfJoltages.get(i+1) - listOfJoltages.get(i) : 3;
			numbersOfJoltDifferences[difference - 1]++;
		}
		return numbersOfJoltDifferences[INDEX_1_JOLT]  * numbersOfJoltDifferences[INDEX_3_JOLTS];
	}
}
