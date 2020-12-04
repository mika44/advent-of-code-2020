package fr.game.advent.day04;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public enum RequiredField {
	Birth_Year		("byr", true, v -> v.matches("\\d{4}") && Integer.valueOf(v) >= 1920 && Integer.valueOf(v) <= 2002 ), 
	Issue_Year		("iyr", true, v -> v.matches("\\d{4}") && Integer.valueOf(v) >= 2010 && Integer.valueOf(v) <= 2020 ),  
	Expiration_Year	("eyr", true, v -> v.matches("\\d{4}") && Integer.valueOf(v) >= 2020 && Integer.valueOf(v) <= 2030 ),  
	Height			("hgt", true, v -> (v.matches("\\d{3}cm") && Integer.valueOf(v.substring(0, 3)) >= 150 && Integer.valueOf(v.substring(0, 3)) <= 193) || (v.matches("\\d{2}in") && Integer.valueOf(v.substring(0, 2)) >= 59 && Integer.valueOf(v.substring(0, 2)) <= 76) ), 
	Hair_Color		("hcl", true, v -> v.matches("#[0-9a-f]{6}") ), 
	Eye_Color		("ecl", true, v -> v.matches("amb|blu|brn|gry|grn|hzl|oth") ), 
	Passport_ID		("pid", true, v -> v.matches("[0-9]{9}") ), 
	Country_ID		("cid", false);
	
	private String keyCode;
	private boolean isMandatory;
	private Predicate<String> verifyRuleOnValue;
	
	private RequiredField(String keyCode, boolean isMandatory, Predicate<String> verifyRuleOnValue) {
		this.keyCode = keyCode;
		this.isMandatory = isMandatory;
		this.verifyRuleOnValue = verifyRuleOnValue;
	}

	private RequiredField(String keyCode, boolean isMandatory) {
		this.keyCode = keyCode;
		this.isMandatory = isMandatory;
		this.verifyRuleOnValue = v -> true;
	}

	public String getKeyCode() {
		return keyCode;
	}

	public boolean isMandatory() {
		return isMandatory;
	}

	public Predicate<String> getVerifyRuleOnValue() {
		return verifyRuleOnValue;
	}

	private static Map<String, RequiredField> mapRequiredFieldsByKeyCode;
	
	private static void fillMapRequiredFieldsByKeyCode() {
		mapRequiredFieldsByKeyCode = new HashMap<>();
		for (RequiredField aRequiredField : RequiredField.values()) {
			mapRequiredFieldsByKeyCode.put(aRequiredField.keyCode, aRequiredField);
		}
	}
	
	public static RequiredField mapFromKeyCode(String keyCode) {
		if (mapRequiredFieldsByKeyCode == null) {
			fillMapRequiredFieldsByKeyCode();
		}
		return mapRequiredFieldsByKeyCode.get(keyCode);
	}
}
