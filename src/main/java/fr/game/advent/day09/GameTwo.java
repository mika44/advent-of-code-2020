package fr.game.advent.day09;

import java.util.List;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;

public class GameTwo extends AbstractGame<Long, Long> {

	private static final String INPUT_FILENAME = "day09/input-day09-1";
	private static final int DEFAULT_PREAMBLE_SIZE = 25;
	
	private int preambleSize;

	public GameTwo() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, Long::valueOf);
		setPreambleSize(DEFAULT_PREAMBLE_SIZE);
	}

	public void setPreambleSize(int preambleSize) {
		this.preambleSize = preambleSize;
	}

	@Override
	public Long play(List<Long> listOfInputs) {
		Long invalidNumber = findInvalidNumber(listOfInputs);
		Pair sequence = findSequenceThatSumsInvalidNumber(listOfInputs, invalidNumber);
		Long min = listOfInputs.stream().limit(sequence.end).skip(sequence.start).mapToLong(l -> l).min().getAsLong();
		Long max = listOfInputs.stream().limit(sequence.end).skip(sequence.start).mapToLong(l -> l).max().getAsLong();
		return min + max;
	}
	
	class Pair {
		int start, end;
		Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	private Pair findSequenceThatSumsInvalidNumber(List<Long> listOfInputs, Long invalidNumber) {
		for (int i = 0; i < listOfInputs.size(); i++) {
			long sum = listOfInputs.get(i);
			for (int j = i + 1; j < listOfInputs.size(); j++) {
				sum = sum + listOfInputs.get(j);
				if (sum == invalidNumber) return new Pair(i, j);
				if (sum > invalidNumber) break;
			}
		}
		return null;
	}
	
	private Long findInvalidNumber(List<Long> listOfInputs) {
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
