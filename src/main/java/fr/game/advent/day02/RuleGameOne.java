package fr.game.advent.day02;

public class RuleGameOne implements Rule {

	private long countNumberOfOccurencesOfLetterInString(char letter, String stringToTest) {
		return stringToTest.chars()
				.filter(c -> c == letter)
				.count();
	}
		
	@Override
	public boolean isPasswordRespectingTheRule(RuleDataAndPassword ruleDataAndPassword) {
		long numberOfOccurencesOfLetterInString = countNumberOfOccurencesOfLetterInString(ruleDataAndPassword.getRuleData().getLetter(), ruleDataAndPassword.getPassword());
		return numberOfOccurencesOfLetterInString >= ruleDataAndPassword.getRuleData().getFirstIndicator()
				&&  numberOfOccurencesOfLetterInString <= ruleDataAndPassword.getRuleData().getSecondIndicator();
	}
}
