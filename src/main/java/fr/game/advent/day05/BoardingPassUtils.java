package fr.game.advent.day05;

import java.util.stream.Stream;

public class BoardingPassUtils {

	/* 
	 * It's just map boarding pass to binary :
	 * - F and L converted to bit 0
	 * - B and R converted to bit 1
	 * and calculate the value in a decimal number
	 */
	public static int mapBoardingPassStringToSeatNumber(String boardingPassString) {
		return Stream.iterate(0, i -> i + 1).limit(boardingPassString.length()) // generate a stream of integer from 0 to length of boarding pass
			.filter(i -> boardingPassString.charAt(i) == 'B' || boardingPassString.charAt(i) == 'R')  // keep integer i when char at position i is B or R (ie bit 1)
			.mapToInt(i -> boardingPassString.length() - i - 1) // the position i map to a power of 2
			.map(ls -> 1 << ls) // calculate 2^p with a left shift operator  
			.sum(); // just sum to obtain the number of the seat
	}
	
}
