package fr.game.advent.day07;

import java.util.HashMap;
import java.util.Map;

public class Bag {

	private String name;
	private Map<String, Integer> possibleContent;

	public Bag(String name) {
		this.name = name;
		possibleContent = new HashMap<>();
	}

	public void addBagContent(String bagName, Integer number) {
		possibleContent.put(bagName, number);
	}

	public String getName() {
		return name;
	}

	public Map<String, Integer> getPossibleContent() {
		return possibleContent;
	}
	
	public boolean isParent(String anotherBagName) {
		return possibleContent.keySet().contains(anotherBagName);
	}
	
	@Override
	public String toString() {
		return "Bag [name=" + name + "]";
	}

	public static Bag mapToBag(String bagAsString) {
		String[] decomposition = bagAsString.split(" bags contain | bag, | bags, | bags.| bag.");
		Bag newBag = new Bag(decomposition[0]);
		for (int i = 1; i < decomposition.length; i++) {
			if (!decomposition[i].startsWith("no")) {
				int indexFirstSpace = decomposition[i].indexOf(" ");
				int number = Integer.valueOf(decomposition[i].substring(0, indexFirstSpace).trim());
				String name = decomposition[i].substring(indexFirstSpace).trim();
				newBag.addBagContent(name, number);
			}
		}
		return newBag;
	}
}
