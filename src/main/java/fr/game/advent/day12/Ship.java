package fr.game.advent.day12;

public class Ship {

	private static final int ONE_DIRECTION_TURN_IN_DEGREE = 90;
	
	private Direction direction;
	private Point position;

	public Ship() {
		this.direction = Direction.EAST;
		this.position = Point.ORIGIN;
	}

	public Direction getDirection() {
		return direction;
	}

	public Point getPosition() {
		return position;
	}

	public void turnLeft(int degrees) {
		for (int turnNumber = getTurnNumberFromDegree(degrees); turnNumber > 0; turnNumber--) {
			direction = direction.turnToLeft();
		}
	}
	
	public void turnRight(int degrees) {
		for (int turnNumber = getTurnNumberFromDegree(degrees); turnNumber > 0; turnNumber--) {
			direction = direction.turnToRight();
		}
	}
	
	private int getTurnNumberFromDegree(int degrees) {
		return degrees / ONE_DIRECTION_TURN_IN_DEGREE;
	}
	
	public void move(Direction direction, int units) {
		Point deltaPosition= direction.getDelta(units); 
		move(deltaPosition.getX(), deltaPosition.getY());
	}

	private void move(int deltaX, int deltaY) {
		position = new Point(position.getX() + deltaX, position.getY() + deltaY);
	}

	@Override
	public String toString() {
		return "Ship [direction=" + direction + ", position=" + position + "]";
	}
}
