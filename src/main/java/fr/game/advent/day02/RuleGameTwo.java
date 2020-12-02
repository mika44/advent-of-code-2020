package fr.game.advent.day02;

public class RuleGameTwo implements Rule {

	@Override
	public boolean isPasswordRespectingTheRule(RuleDataAndPassword ruleDataAndPassword) {
		char letter = ruleDataAndPassword.getRuleData().getLetter();
		return isLetterAtFirstPositionInPassword(ruleDataAndPassword, letter)
				^  
			   isLetterAtSecondPositionInPassword(ruleDataAndPassword, letter);
	}

	private boolean isLetterAtSecondPositionInPassword(RuleDataAndPassword ruleDataAndPassword, char letter) {
		return isLetterAtPositionInPassword(ruleDataAndPassword.getPassword(), ruleDataAndPassword.getRuleData().getSecondIndicator() - 1, letter);
	}

	private boolean isLetterAtFirstPositionInPassword(RuleDataAndPassword ruleDataAndPassword, char letter) {
		return isLetterAtPositionInPassword(ruleDataAndPassword.getPassword(), ruleDataAndPassword.getRuleData().getFirstIndicator() - 1, letter);
	}
	
	private boolean isLetterAtPositionInPassword(String password, int position, char letter) {
		return password.charAt(position) == letter;
	}
}
