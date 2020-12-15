package fr.game.advent.day14.one;

import java.util.Map;
import java.util.logging.Logger;

import fr.game.utils.LoggerUtils;

public class Mem implements Operation {
	
	private static final Logger LOGGER = LoggerUtils.getLogger();
	
	private int address;
	private long value;

	private Mem(int address, long value) {
		this.address = address;
		this.value = value;
	}

	public static Mem mapToMem(String input) {
		String[] decomposition = input.substring(4).split("] = ");
		int address = Integer.valueOf(decomposition[0]);
		int value = Integer.valueOf(decomposition[1]);
		return new Mem(address, value);
	}

	private long applyMaskToValue(final String mask, final long value) {
		long result = 0;
		long bit = 1L << mask.length();
		for (int i = 0; i < mask.length(); i++) {
			bit = bit >> 1;
			switch (mask.charAt(i)) {
				case '0': break;
				case '1': result = result + bit; break;
				case 'X': result = result + (value & bit); break;
			}
		}
		return result;
	}

	@Override
	public String apply(String mask, Map<Integer, Long> memory) {
		memory.put(address, applyMaskToValue(mask, value));
		LOGGER.info("update mem[" + address + "] = " + value + " -> " + memory.get(address));
		return mask;
	}
}
