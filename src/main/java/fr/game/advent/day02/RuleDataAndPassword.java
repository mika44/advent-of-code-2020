package fr.game.advent.day02;

import java.util.logging.Logger;

import fr.game.utils.LoggerUtils;

public class RuleDataAndPassword {

	private static final Logger LOGGER = LoggerUtils.getLogger();
	private RuleData ruleData;
	private String password;

	private RuleDataAndPassword(RuleData ruleData, String password) {
		this.ruleData = ruleData;
		this.password = password;
	}

	private RuleDataAndPassword(String ruleDataAsString, String password) {
		this(RuleData.mapFromString(ruleDataAsString), password);
	}
	
	
	public RuleData getRuleData() {
		return ruleData;
	}

	public String getPassword() {
		return password;
	}

	public static RuleDataAndPassword mapToRuleDataAndPasswordFromString(String ruleDataAndPasswordAsString) {
		LOGGER.info("ruleAndPasswordAsString = '" + ruleDataAndPasswordAsString + "'");
		String[] decomposition = ruleDataAndPasswordAsString.split(": ");
		return new RuleDataAndPassword(decomposition[0], decomposition[1]);
	}
}
