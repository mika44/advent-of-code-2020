package fr.game.advent.day07;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;

public class GameOne extends AbstractGame<String, Integer> {
	
	private static final String INPUT_FILENAME = "day07/input-day07-1";
	
	public GameOne() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, String::new);
	}

	
	@Override
	public Integer play(List<String> listOfInputs) {
		Map<String, Bag> bagRules = listOfInputs.stream().map(Bag::mapToBag).collect(Collectors.toMap(Bag::getName, Function.identity()));
		return getBagsThanContainAtLeastOneShinyGoldBag(bagRules).size();
	}

	private Set<String> getBagsThanContainAtLeastOneShinyGoldBag(final Map<String, Bag> bagRules) {
		return getBagsThanContainAtLeastOneBag("shiny gold", bagRules);
	}

	private Set<String> getBagsThanContainAtLeastOneBag(String aBag, final Map<String, Bag> bagRules) {
		Set<String> directContainers = bagRules.values().stream()
										.filter(b -> b.isParent(aBag))
										.map(Bag::getName)
										.collect(Collectors.toSet());
		
		Set<String> indirectContainers = directContainers.stream()
											.flatMap(aBagName -> getBagsThanContainAtLeastOneBag(aBagName, bagRules).stream())
											.collect(Collectors.toSet());
		
		directContainers.addAll(indirectContainers);
		return directContainers;
	}

}
