package fr.game.advent.day02;

public class RuleData {

	private int firstIndicator;
	private int secondIndicator;
	private char letter;

	private RuleData(int firstIndicator, int secondIndicator, char letter) {
		this.firstIndicator = firstIndicator;
		this.secondIndicator = secondIndicator;
		this.letter = letter;
	}

	private RuleData(String firstIndicator, String secondIndicator, String letter) {
		this(Integer.valueOf(firstIndicator), Integer.valueOf(secondIndicator), letter.charAt(0));
	}

	public int getFirstIndicator() {
		return firstIndicator;
	}

	public int getSecondIndicator() {
		return secondIndicator;
	}

	public char getLetter() {
		return letter;
	}

	public static RuleData mapFromString(String ruleAsString) {
		String[] decomposition = ruleAsString.split("-| ");
		return new RuleData(decomposition[0], decomposition[1], decomposition[2]);
	}
}
