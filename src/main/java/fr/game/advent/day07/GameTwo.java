package fr.game.advent.day07;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;

public class GameTwo extends AbstractGame<String, Integer> {
	
	private static final String INPUT_FILENAME = "day07/input-day07-1";
	
	public GameTwo() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, String::new);
	}
	
	@Override
	public Integer play(List<String> listOfInputs) {
		Map<String, Bag> bagRules = listOfInputs.stream().map(Bag::mapToBag).collect(Collectors.toMap(Bag::getName, Function.identity()));
		return numberOfIndividualBagsRequiredInsideSingleShinyGold(bagRules);
	}

	private Integer numberOfIndividualBagsRequiredInsideSingleShinyGold(final Map<String, Bag> bagRules) {
		return numberOfIndividualBagsRequiredInsideBagIncludingBag(bagRules, "shiny gold") - 1;
	}

	private Integer numberOfIndividualBagsRequiredInsideBagIncludingBag(final Map<String, Bag> bagRules, String aBagName) {
		int number = 1;
		Bag aBag = bagRules.get(aBagName);
		for (String anotherBagName : aBag.getPossibleContent().keySet()) {
			number = number + aBag.getPossibleContent().get(anotherBagName) * numberOfIndividualBagsRequiredInsideBagIncludingBag(bagRules, anotherBagName);
		}
		return number;
	}

}
