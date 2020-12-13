package fr.game.advent.day12;

import java.util.Map;

public enum Direction {
	
	EAST	(new Point( 0, +1)),
	NORTH	(new Point(+1,  0)),
	WEST	(new Point( 0, -1)),
	SOUTH	(new Point(-1,  0));

	private Point delta;

	private Direction(Point delta) {
		this.delta = delta;
	}
	
	public Point getDelta(int units) {
		return new Point(delta.getX() * units, delta.getY() * units);
	}
	
	private static final Map<Direction, Direction> TO_LEFT =
			Map.of(NORTH, WEST,
				   WEST, SOUTH,
				   SOUTH, EAST,
				   EAST, NORTH);
	
	public Direction turnToLeft() {
		return TO_LEFT.get(this);
	}
	
	private static final Map<Direction, Direction> TO_RIGHT =
			Map.of(NORTH, EAST,
				   EAST, SOUTH,
				   SOUTH, WEST,
				   WEST, NORTH);
	
	public Direction turnToRight() {
		return TO_RIGHT.get(this);
	}
}
