package fr.game.advent.day13;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;

public class GameTwo extends AbstractGame<String, Long> {
	
	private static final String INPUT_FILENAME = "day13/input-day13-1";

	public GameTwo() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, String::new);
	}
	
	
	class PairIndexId {
		Long index, id;
		PairIndexId(long a, long b) {
			this.index = a;
			this.id = b;
		}
		public Long getIndex() {
			return index;
		}
		public Long getId() {
			return id;
		}
		@Override
		public String toString() {
			return "Pair [index=" + index + ", id=" + id + "]";
		}
	}
	
	@Override
	public Long play(List<String> listOfInputs) {	
		final List<PairIndexId> pairs = extractListPairIndexIdFromInput(listOfInputs);
		PairIndexId reduction = pairs.stream().reduce(new PairIndexId(0, 1), this::reduce);
		return reduction.id - reduction.index;
	}


	/* 
	 * Map string input to a list of pair of index and ids. 
	 * The first id is at index 0, the second at index 1, etc.
	 * The 'x' are ignored but index is increased.
	 * For example, the string "3,x,x,11" will produce 2 pairs (0, 3) and (3, 11).
	 * The pairs are sorted by descending value of id.
	 */
	private List<PairIndexId> extractListPairIndexIdFromInput(List<String> listOfInputs) {
		final List<String> items = Arrays.stream(listOfInputs.get(1).split(",")).collect(Collectors.toList());
		return Stream.iterate(0, i -> i + 1).limit(items.size())
							.filter(i -> !"x".equals(items.get(i)))
							.map( i-> new PairIndexId(i, Long.valueOf(items.get(i))) )
							.sorted(Comparator.comparing(PairIndexId::getId).reversed())
							.collect(Collectors.toList());
	}
	
	/*
	 * To solve the problem efficiently, we use a reduction on pairs.
	 * 
	 * Considering 2 pairs (i, a) and (j, b).
	 * Suppose you can solve the problem of earlyTimeStamp for these 2 pairs and that the solution is the value 'ets'.
	 * Then it means that the value 'ets' is the minimal good value such as (a - i) modulo ets = 0 and (b - j) modulo ets = O.
	 * 
	 * But there are infinite other good values : 
	 * let's call 'lcm' the Least Common Multiple of a and b
	 * then ets(k) = ets + k x lcm with k > 0 is also a value which verifies (a - i) modulo ets(k) = 0 and (b - j) modulo ets(k) = O.
	 * 
	 * All this means that if we can find a pair (p, x) that also produces solutions ets(k) for k >= 0, 
	 * then (p, x) is equivalent to the 2 pairs (i, a) and (j, b) in the problem of earlyTimeStamp.
	 * 
	 * This pair is easy to find with all these elements : it's just (lcm - ets, lcm) !
	 * 
	 * So we can easily reduce 2 pairs to a unique one with a little computation.
	 */
	private PairIndexId reduce(PairIndexId pa, PairIndexId pb) {
		// find the solution ets for the 2 pairs
		long earlyTimeStamp = Stream.iterate(pa.id - pa.index, ets -> ets + pa.id)
								.filter(ets -> (ets + pb.index) % pb.id == 0)
								.findFirst()
								.get();
		// calculate lcm for the 2 pairs
		long lcm = leastCommonMultiple(pa.id, pb.id);
		// return the reduced pair
		return new PairIndexId(lcm - earlyTimeStamp, lcm);
	}
	
	
	private long leastCommonMultiple(long a, long b) {
		return (a * b) / greatestCommonDivisor(a, b);
	}
	

	private long greatestCommonDivisor(long a, long b) {
		if (b == 0) {
			return a;
		} else {
			return greatestCommonDivisor(b, a % b);
		}
	}
}