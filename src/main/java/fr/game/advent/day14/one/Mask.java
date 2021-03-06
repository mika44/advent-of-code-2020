package fr.game.advent.day14.one;

import java.util.Map;

public class Mask implements Operation {
	private String mask;

	private Mask(String mask) {
		this.mask = mask;
	}

	public static Mask mapToMask(String input) {
		return new Mask(input.substring("mask = ".length()));
	}

	@Override
	public String apply(String mask, Map<Integer, Long> memory) {
		return this.mask;
	}
}
