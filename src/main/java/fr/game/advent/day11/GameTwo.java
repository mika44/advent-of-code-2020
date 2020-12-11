package fr.game.advent.day11;

import java.util.List;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;

public class GameTwo extends AbstractGame<String, Long> {

	private static final String INPUT_FILENAME = "day11/input-day11-1";
	
	public GameTwo() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, String::new);
	}

	private boolean showRounds = false;
	
	public void setShowRounds(boolean showRounds) {
		this.showRounds = showRounds;
	}

	@Override
	public Long play(List<String> listOfInputs) {
		SeatLayout sl = SeatLayout.mapToSeatLayout(listOfInputs);
		int round = 1;
		while (!sl.playRoundWithVisibleSeats()) {
			if (showRounds) {
				System.out.println("----------------");
				System.out.println(" Round " + round);
				sl.print();
			}
			round++;
		}
		return sl.numberOfOccupiedSeat();
	}
}
