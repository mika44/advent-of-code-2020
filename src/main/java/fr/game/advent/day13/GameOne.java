package fr.game.advent.day13;

import java.util.Arrays;
import java.util.List;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;

public class GameOne extends AbstractGame<String, Integer> {
	
	private static final String INPUT_FILENAME = "day13/input-day13-1";

	public GameOne() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, String::new);
	}
	

	@Override
	public Integer play(List<String> listOfInputs) {
		int earliestTimeStamp = Integer.valueOf(listOfInputs.get(0));
		int[] ids = Arrays.stream(listOfInputs.get(1).split(",")).filter(s -> !"x".equals(s)).mapToInt(Integer::valueOf).toArray();
		
		int minOfIds = -1;
		int minWait = -1;
		for (int id : ids) {
			int firstMultipleOverEarliestTimeStamp = ((earliestTimeStamp / id) + 1) * id;
			int wait = firstMultipleOverEarliestTimeStamp - earliestTimeStamp;
			if (minWait == -1 || wait < minWait) {
				minWait = wait;
				minOfIds = id;
			}
		}
		return minWait * minOfIds;
	}

}