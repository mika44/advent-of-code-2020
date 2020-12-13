package fr.game.advent.day12;

public class Instruction {

	private Action action;
	private int value;

	Instruction(Action action, int value) {
		this.action = action;
		this.value = value;
	}

	public void executeOnShip(Ship ship) {
		switch (action) {
			case MOVE_EAST:		ship.move(Direction.EAST, value); break;
			case MOVE_NORTH:	ship.move(Direction.NORTH, value); break;
			case MOVE_WEST:		ship.move(Direction.WEST, value); break;
			case MOVE_SOUTH:	ship.move(Direction.SOUTH, value); break;
			case MOVE_FORWARD:	ship.move(ship.getDirection(), value); break;
			case TURN_LEFT:		ship.turnLeft(value); break;
			case TURN_RIGHT:	ship.turnRight(value); break;
		}
	}

	public static Instruction mapToInstruction(String input) {
		Action action = Action.mapToAction(input.charAt(0));
		int value = Integer.valueOf(input.substring(1));
		return new Instruction(action, value);
	}
}
