package fr.game.advent.day14.two;

import java.util.Map;

public interface Operation {

	public static Operation mapToOperation(String input) {
		if (input.startsWith("mask")) {
			return Mask.mapToMask(input);
		} else {
			return Mem.mapToMem(input);
		}
	}

	public String apply(String mask, Map<Long, Long> memory);
}
