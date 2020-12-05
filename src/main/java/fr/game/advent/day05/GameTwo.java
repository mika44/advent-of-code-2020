package fr.game.advent.day05;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;

public class GameTwo extends AbstractGame<String, Integer> {
	
	private static final String INPUT_FILENAME = "day05/input-day05-1";
	
	public GameTwo() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, String::new);
	}

	@Override
	public Integer play(List<String> listOfBoardingPasses) {
		Set<Integer> occupiedSeats = generateSetOfOccupiedSeats(listOfBoardingPasses);
		Set<Integer> availableSeats = generateSetOfAvailableSeats(listOfBoardingPasses);
		availableSeats.removeAll(occupiedSeats);
		return availableSeats.iterator().next();
	}

	private Set<Integer> generateSetOfOccupiedSeats(List<String> listOfBoardingPasses) {
		return streamOfSeatNumbers(listOfBoardingPasses).collect(Collectors.toSet());
	}

	private Stream<Integer> streamOfSeatNumbers(List<String> listOfBoardingPasses) {
		return listOfBoardingPasses.stream().map(this::mapBoardingPassStringToSeatNumber);
	}

	private Set<Integer> generateSetOfAvailableSeats(List<String> listOfBoardingPasses) {
		Integer minSeat = streamOfSeatNumbers(listOfBoardingPasses).mapToInt(i -> i).min().getAsInt();
		Integer maxSeat = streamOfSeatNumbers(listOfBoardingPasses).mapToInt(i -> i).max().getAsInt();
		Set<Integer> potentialSeats = Stream.iterate(0, i -> i + 1).limit(maxSeat).filter(i -> i >= minSeat).collect(Collectors.toSet());
		return potentialSeats;
	}

	/* 
	 * It's just map boarding pass to binary :
	 * - F and L converted to bit 0
	 * - B and R converted to bit 1
	 */
	private int mapBoardingPassStringToSeatNumber(String boardingPassString) {
		return Stream.iterate(0, i -> i + 1).limit(boardingPassString.length())
			.filter(i -> boardingPassString.charAt(i) == 'B' || boardingPassString.charAt(i) == 'R')
			.mapToInt(i -> 1 << (boardingPassString.length() - i - 1))
			.sum();
	}
	
}
 