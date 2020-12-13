package fr.game.advent.day12;

public class InstructionWithWayPoint {

	private Action action;
	private int value;

	InstructionWithWayPoint(Action action, int value) {
		this.action = action;
		this.value = value;
	}

	public void executeOnShip(ShipAndWayPoint shipAndWayPoint) {
		switch (action) {
			case MOVE_EAST:		shipAndWayPoint.moveWayPoint(Direction.EAST, value); break;
			case MOVE_NORTH:	shipAndWayPoint.moveWayPoint(Direction.NORTH, value); break;
			case MOVE_WEST:		shipAndWayPoint.moveWayPoint(Direction.WEST, value); break;
			case MOVE_SOUTH:	shipAndWayPoint.moveWayPoint(Direction.SOUTH, value); break;
			case MOVE_FORWARD:	shipAndWayPoint.moveForwardByWayPoint(value);break;
			case TURN_LEFT:		shipAndWayPoint.rotateLeftWayPointAroundShip(value); break;
			case TURN_RIGHT:	shipAndWayPoint.rotateRightWayPointAroundShip(value); break;
		}
	}

	public static InstructionWithWayPoint mapToInstruction(String input) {
		Action action = Action.mapToAction(input.charAt(0));
		int value = Integer.valueOf(input.substring(1));
		return new InstructionWithWayPoint(action, value);
	}
}
