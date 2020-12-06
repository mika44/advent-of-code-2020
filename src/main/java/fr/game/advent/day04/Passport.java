package fr.game.advent.day04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Passport {

	public static final String ITEM_SEPARATOR = " ";

	private static final String KEY_VALUE_SEPARATOR = ":";
	
	private Map<RequiredField, String> content;

	public boolean isValidGameOne() {
		return Arrays.stream(RequiredField.values())
				.filter(RequiredField::isMandatory)
				.allMatch(content.keySet()::contains);
	}

	public boolean isValid() {
		return Arrays.stream(RequiredField.values())
				.filter(RequiredField::isMandatory)
				.allMatch(isPassportValidForThisKey());
	}

	private Predicate<? super RequiredField> isPassportValidForThisKey() {
		final Predicate<RequiredField> isPresent = content.keySet()::contains;
		final Predicate<RequiredField> isValueVerifyingRule = r -> r.getVerifyRuleOnValue().test(content.get(r));
		return isPresent.and(isValueVerifyingRule);
	}
	
	private void mapContentFromString(String contentAsString) {
		content = new HashMap<>();
		String[] decomposition = contentAsString.split(ITEM_SEPARATOR);
		for (String itemAsString : decomposition) {
			mapItemFromString(itemAsString);
		}
	}
	
	private void mapItemFromString(String itemAsString) {
		String[] decompositionItem = itemAsString.split(KEY_VALUE_SEPARATOR);
		RequiredField key = RequiredField.mapFromKeyCode(decompositionItem[0]);
		content.put(key, decompositionItem[1]);
	}

	public static Passport mapFromString(String passportAsString) {
		Passport passport = new Passport();
		passport.mapContentFromString(passportAsString);
		return passport;
	}
}
