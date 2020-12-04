package fr.game.advent.day04;

import java.util.ArrayList;
import java.util.List;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;

public class GameOne extends AbstractGame<String, Long> {
	
	private static final String INPUT_FILENAME = "day04/input-day04-1";
	
	public GameOne() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, String::new);
	}

	@Override
	public Long play(List<String> listOfInputs) {
		return mapToPassports(listOfInputs).stream()
				.filter(Passport::isValid)
				.count();
	}

	private List<Passport> mapToPassports(List<String> listOfInputs) {
		List<Passport> passports = new ArrayList<Passport>();
		StringBuilder sb = new StringBuilder();
		for (String aLine : listOfInputs) {
			if (aLine.isEmpty()) {
				passports.add(Passport.mapFromString(sb.toString()));
				sb = new StringBuilder();
			} else {
				sb.append(aLine + " ");
			}
		}
		passports.add(Passport.mapFromString(sb.toString()));
		return passports;
	}
}
