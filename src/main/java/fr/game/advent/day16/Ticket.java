package fr.game.advent.day16;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ticket {

	private List<Integer> values;

	private Ticket(List<Integer> values) {
		super();
		this.values = values;
	}

	public List<Integer> getValues() {
		return values;
	}

	public static Ticket mapToTicket(String input) {
		List<Integer> values = Arrays.stream(input.split(",")).map(Integer::valueOf).collect(Collectors.toList());
		return new Ticket(values);
	}
}
