package fr.game.advent.day09;

import java.util.List;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;

public class GameOne extends AbstractGame<Long, Long> {

	private static final String INPUT_FILENAME = "day09/input-day09-1";
	private static final int DEFAULT_PREAMBLE_SIZE = 25;
	
	private int preambleSize;

	public GameOne() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, Long::valueOf);
		setPreambleSize(DEFAULT_PREAMBLE_SIZE);
	}

	public void setPreambleSize(int preambleSize) {
		this.preambleSize = preambleSize;
	}

	@Override
	public Long play(List<Long> listOfInputs) {
		for (int index = preambleSize; index < listOfInputs.size(); index++) {
			if (!findPairInPreambleThatSumsNumber(listOfInputs, index)) return listOfInputs.get(index);
		}
		return -1L;
	}
	
	private boolean findPairInPreambleThatSumsNumber(final List<Long> listOfInputs, int indexNumber) {
		int startIndexPreamble = indexNumber - preambleSize;
		for (int i = startIndexPreamble; i < indexNumber; i++) {
			for (int j = i + 1; j < indexNumber; j++) {
				if (listOfInputs.get(i) + listOfInputs.get(j) == listOfInputs.get(indexNumber)) return true;
			}
		}
		return false;
	}


}
