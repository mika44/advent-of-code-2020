package fr.game.advent.day14.two;

import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.LongStream;

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

	
	private LongStream applyMaskToAdress(final String mask, final int indexMask, final long bit) {
		LOGGER.fine("indexMask = " + indexMask + " - bit " + bit);
		if (bit == 1) {
			switch (mask.charAt(indexMask)) {
				case '0': return LongStream.of(address & 1L);
				case '1': return LongStream.of(1L);
				case 'X': return LongStream.of(0L, 1L);
			}
		} 
		switch (mask.charAt(indexMask)) {
			case '0': return applyMaskToAdress(mask, indexMask + 1, bit >> 1).map(ad -> ad + (address & bit));
			case '1': return applyMaskToAdress(mask, indexMask + 1, bit >> 1).map(ad -> ad + bit);
			case 'X': return applyMaskToAdress(mask, indexMask + 1, bit >> 1).flatMap(ad -> LongStream.of(ad, ad + bit));
		}
		return null;
	}

	private LongStream applyMaskToAdress(final String mask) {
		return applyMaskToAdress(mask, 0, 1L << (mask.length() - 1));
	}

	@Override
	public String apply(String mask, Map<Long, Long> memory) {
		applyMaskToAdress(mask)
			.peek(ad -> LOGGER.info("update mem[" + ad + "] = " + memory.get(ad) + " -> " + value))
			.forEach(ad -> memory.put(ad, value));
		return mask;
	}
}
