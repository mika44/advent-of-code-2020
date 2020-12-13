package fr.game.advent.day12;

public class ShipAndWayPoint {

	private static final int ONE_DIRECTION_TURN_IN_DEGREE = 90;
	
	private Point position;
	private Point wayPoint;

	public ShipAndWayPoint() {
		this.position = Point.ORIGIN;
		this.wayPoint = new Point(1, 10);
	}

	public Point getPosition() {
		return position;
	}

	public void moveForwardByWayPoint(int unit) {
		position = new Point(position.getX() + wayPoint.getX() * unit, position.getY() + + wayPoint.getY() * unit);
	}

	public void moveWayPoint(Direction direction, int units) {
		Point deltaPosition= direction.getDelta(units); 
		moveWayPoint(deltaPosition.getX(), deltaPosition.getY());
	}

	private void moveWayPoint(int deltaX, int deltaY) {
		wayPoint = new Point(wayPoint.getX() + deltaX, wayPoint.getY() + deltaY);
	}
	
	public void rotateLeftWayPointAroundShip(int degrees) {
		for (int turnNumber = getTurnNumberFromDegree(degrees); turnNumber > 0; turnNumber--) {
			rotateOneTimeLeftWayPointAroundShip();
		}
	}
	
	private void rotateOneTimeLeftWayPointAroundShip() {
		wayPoint = new Point(wayPoint.getY(), -wayPoint.getX());
	}
	
	public void rotateRightWayPointAroundShip(int degrees) {
		for (int turnNumber = getTurnNumberFromDegree(degrees); turnNumber > 0; turnNumber--) {
			rotateOneTimeRightWayPointAroundShip();
		}
	}
	
	private void rotateOneTimeRightWayPointAroundShip() {
		wayPoint = new Point(-wayPoint.getY(), wayPoint.getX());
	}

	private int getTurnNumberFromDegree(int degrees) {
		return degrees / ONE_DIRECTION_TURN_IN_DEGREE;
	}
	
	@Override
	public String toString() {
		return "ShipAndWayPoint [position=" + position + ", wayPoint=" + wayPoint + "]";
	}

}
