package fr.game.advent.day12;

import java.util.HashMap;
import java.util.Map;

public enum Action {
	MOVE_NORTH('N'),
	MOVE_SOUTH('S'),
	MOVE_EAST('E'),
	MOVE_WEST('W'),
	TURN_LEFT('L'),
	TURN_RIGHT('R'),
	MOVE_FORWARD('F');
	
	private char actionLetter;

	private Action(char actionLetter) {
		this.actionLetter = actionLetter;
	}
	
	private static Map<Character, Action> map;
	
	private static void fillMap() {
		map = new HashMap<>();
		for (Action anAction : values()) {
			map.put(anAction.actionLetter, anAction);
		}
	}

	public static Action mapToAction(char letter) {
		if (map == null) {
			fillMap();
		}
		return map.get(letter);
	}

}
