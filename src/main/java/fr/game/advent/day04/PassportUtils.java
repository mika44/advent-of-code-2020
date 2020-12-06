package fr.game.advent.day04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PassportUtils {
	
	private static final String PASSPORT_SEPARATOR = "!";

	private static String joinInUniqueString(List<String> listOfInputs) {
		return listOfInputs.stream()
				.map(s -> s.isEmpty() ? PASSPORT_SEPARATOR : s + Passport.ITEM_SEPARATOR)
				.collect(Collectors.joining());
	}
	
	private static Stream<String> aggregateInputsInPassportStrings(List<String> listOfInputs) {
		return Arrays.stream(joinInUniqueString(listOfInputs).split(PASSPORT_SEPARATOR));
	}
	
	public static Stream<Passport> mapToPassportStream(List<String> listOfInputs) {
		return aggregateInputsInPassportStrings(listOfInputs)
				.map(Passport::mapFromString);
	}

/* Other solution */
// 	public static Stream<Passport> mapToPassportStream(List<String> listOfInputs) {
//		List<Passport> passports = new ArrayList<Passport>();
//		StringBuilder sb = new StringBuilder();
//		for (String aLine : listOfInputs) {
//			if (aLine.isEmpty()) {
//				passports.add(Passport.mapFromString(sb.toString()));
//				sb = new StringBuilder();
//			} else {
//				sb.append(aLine + " ");
//			}
//		}
//		passports.add(Passport.mapFromString(sb.toString()));
//		return passports.stream();
//	}
}
