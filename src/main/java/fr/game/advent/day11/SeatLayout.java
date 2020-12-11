package fr.game.advent.day11;

import java.util.Arrays;
import java.util.List;

public class SeatLayout {
	
	private CaseContent[][] grid;
	
	private SeatLayout() {
	}
	
	public boolean playRound() {
		CaseContent[][] gridAfterRound = new CaseContent[grid.length][grid[0].length];
		boolean noChange = true;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				noChange = noChange & playRoundOnCase(gridAfterRound, i, j);
			}
		}
		grid = gridAfterRound;
		return noChange;
	}
	
	private boolean playRoundOnCase(CaseContent[][] gridAfterRound, int i, int j) {
		long numberOfAdjacentOccupiedSeats = countAdjacentOccupiedSeats(i, j);
		switch (grid[i][j]) {
			case FREE:
				if (numberOfAdjacentOccupiedSeats == 0L) {
					gridAfterRound[i][j] = CaseContent.OCCUPIED;
				} else {
					gridAfterRound[i][j] = grid[i][j];
				}
				break;
			case OCCUPIED:
				if (numberOfAdjacentOccupiedSeats >= 4L) {
					gridAfterRound[i][j] = CaseContent.FREE;
				} else {
					gridAfterRound[i][j] = grid[i][j];
				}
				break;
			default:
				gridAfterRound[i][j] = grid[i][j];
				break;
		}
		return (grid[i][j] == gridAfterRound[i][j]);
	}

	public boolean playRoundWithVisibleSeats() {
		CaseContent[][] gridAfterRound = new CaseContent[grid.length][grid[0].length];
		boolean noChange = true;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				noChange = noChange & playRoundOnCaseWithVisibleSeats(gridAfterRound, i, j);
			}
		}
		grid = gridAfterRound;
		return noChange;
	}
	
	private boolean playRoundOnCaseWithVisibleSeats(CaseContent[][] gridAfterRound, int i, int j) {
		long numberOfVisibleAdjacentOccupiedSeats = countVisibleAdjacentOccupiedSeats(i, j);
		switch (grid[i][j]) {
			case FREE:
				if (numberOfVisibleAdjacentOccupiedSeats == 0L) {
					gridAfterRound[i][j] = CaseContent.OCCUPIED;
				} else {
					gridAfterRound[i][j] = grid[i][j];
				}
				break;
			case OCCUPIED:
				if (numberOfVisibleAdjacentOccupiedSeats >= 5L) {
					gridAfterRound[i][j] = CaseContent.FREE;
				} else {
					gridAfterRound[i][j] = grid[i][j];
				}
				break;
			default:
				gridAfterRound[i][j] = grid[i][j];
				break;
		}
		return (grid[i][j] == gridAfterRound[i][j]);
	}

	class Point {
		int x,y;
		Point(int x, int y) {
			this.x = x; 
			this.y = y;
		}
		boolean isInGrid() {
			return x >= 0 && x < grid[0].length && y >= 0 && y < grid.length;
		}
	}
	
	private final Point[] adjacents = {
			new Point(-1, -1),
			new Point(-1,  0),
			new Point(-1, +1),
			new Point( 0, +1),
			new Point(+1, +1),
			new Point(+1,  0),
			new Point(+1, -1),
			new Point( 0, -1)
	};
	
	private long countVisibleAdjacentOccupiedSeats(int i, int j) {
		return Arrays.stream(adjacents)
			.map(p -> findFirstVisible(i, j, p))
			.filter(Point::isInGrid)
			.map(p -> grid[p.y][p.x])
			.filter(CaseContent.OCCUPIED::equals)
			.count()
			;
	}

	private Point findFirstVisible(int i, int j, Point direction) {
		Point currentCase = new Point(j + direction.x,  i + direction.y);
		while (currentCase.isInGrid() && CaseContent.FLOOR.equals(grid[currentCase.y][currentCase.x])) {
			currentCase = new Point(currentCase.x + direction.x,  currentCase.y + direction.y);
		}
		return currentCase;
	}

	private long countAdjacentOccupiedSeats(int i, int j) {
		return Arrays.stream(adjacents)
			.map(p -> new Point(p.x + j, p.y + i))
			.filter(Point::isInGrid)
			.map(p -> grid[p.y][p.x])
			.filter(CaseContent.OCCUPIED::equals)
			.count()
			;
	}

	public void print() {
		for (int i = 0; i < grid.length; i++) {
			System.out.println();
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j].getContent());
			}
		}
		System.out.println();
	}
	
	public long numberOfOccupiedSeat() {
		return Arrays.stream(grid).flatMap(l -> Arrays.stream(l)).filter(CaseContent.OCCUPIED::equals).count();
	}

	
	public static SeatLayout mapToSeatLayout(List<String> input) {
		SeatLayout sl = new SeatLayout();
		sl.grid = new CaseContent[input.size()][input.get(0).length()];
		for (int i = 0; i < input.size(); i++) {
			for (int j = 0; j < input.get(i).length(); j++) {
				sl.grid[i][j] = CaseContent.mapToCaseContent(input.get(i).charAt(j));
			}
		}
		return sl;
	}

}
