package fr.game.advent.day14;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.game.advent.day14.two.Operation;
import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;

public class GameTwo extends AbstractGame<String, Long> {
	
	private static final String INPUT_FILENAME = "day14/input-day14-1";

	public GameTwo() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, String::new);
	}

	@Override
	public Long play(List<String> listOfInputs) {
		List<Operation> operations = listOfInputs.stream()
										.map(Operation::mapToOperation)
										.collect(Collectors.toList());
		
		String mask = null;
		Map<Long, Long> memory = new HashMap<>();
		for (Operation operation : operations) {
			mask = operation.apply(mask, memory);
		}
		
		return memory.values().stream().mapToLong(l -> l).sum();
	}

}