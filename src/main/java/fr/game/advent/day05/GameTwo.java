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
		return findTheOnlyFreeSeat(occupiedSeats);

/* Other solution */
//		Set<Integer> availableSeats = generateSetOfAvailableSeats(occupiedSeats);
//		availableSeats.removeAll(occupiedSeats);
//		return availableSeats.iterator().next();
	}

	private Integer findTheOnlyFreeSeat(Set<Integer> occupiedSeats) {
		Integer minSeat = occupiedSeats.stream().mapToInt(i -> i).min().getAsInt();
		Integer maxSeat = occupiedSeats.stream().mapToInt(i -> i).max().getAsInt();
		return Stream.iterate(0, i -> i + 1).limit(maxSeat).filter(i -> i >= minSeat) // generate all the number of seats from minSeatNumber to maxSeatNumber
			.filter(seatNumber -> !occupiedSeats.contains(seatNumber)) // keep only number seat not occupied
			.findFirst()
			.get();
	}

	private Set<Integer> generateSetOfOccupiedSeats(List<String> listOfBoardingPasses) {
		return listOfBoardingPasses.stream().map(BoardingPassUtils::mapBoardingPassStringToSeatNumber).collect(Collectors.toSet());
	}


//	private Set<Integer> generateSetOfAvailableSeats(Set<Integer> occupiedSeats) {
//		Integer minSeat = occupiedSeats.stream().mapToInt(i -> i).min().getAsInt();
//		Integer maxSeat = occupiedSeats.stream().mapToInt(i -> i).max().getAsInt();
//		return Stream.iterate(0, i -> i + 1).limit(maxSeat).filter(i -> i >= minSeat).collect(Collectors.toSet());
//	}

}
 