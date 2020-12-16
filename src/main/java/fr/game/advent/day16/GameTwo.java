package fr.game.advent.day16;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;
import fr.game.utils.LoggerUtils;

public class GameTwo extends AbstractGame<String, Long> {
	
	private static final String INPUT_FILENAME = "day16/input-day16-1";
	
	private static final Logger LOGGER = LoggerUtils.getLogger();

	public GameTwo() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, String::new);
	}


	@Override
	public Long play(List<String> listOfInputs) {
		final int indexBlankLineBetweenRulesAndTickets = Stream.iterate(0,  index -> index + 1)
											.filter(index -> listOfInputs.get(index).isBlank())
											.findFirst()
											.get();
		
		final List<Rule> rules = listOfInputs.stream()
								.limit(indexBlankLineBetweenRulesAndTickets)
								.peek(LOGGER::info)
								.map(Rule::mapToRule)
								.collect(Collectors.toList());
		
		final Ticket myTicket = Ticket.mapToTicket( listOfInputs.get(indexBlankLineBetweenRulesAndTickets + 2) );
		
		final List<Ticket> otherTickets = listOfInputs.stream()
								.skip(indexBlankLineBetweenRulesAndTickets + 5)
								.peek(LOGGER::info)
								.map(Ticket::mapToTicket)
								.collect(Collectors.toList());
		
		List<Ticket> validTickets = findValidTickets(rules, myTicket, otherTickets);
		
		Map<Rule, Integer> rulesOrder = getRulesOrder(rules, validTickets);
				
		return getProductOfDepartureValues(rulesOrder, myTicket);
	}


	private Map<Rule, Integer> getRulesOrder(List<Rule> rules, List<Ticket> validTickets) {
		// at the beginning, all rules are potentially at any position in the ticket
		Map<Rule, Set<Integer>> potentialRulesOrder = initializePotentialRulesOrder(rules);
		// with valid tickets, keep only positions that are still valid for each rule
		cleanPotentialRulesOrderWithValidTickets(validTickets, potentialRulesOrder);
		// clean last uncertain rules order 
		cleanPotentialRulesOrdersToFindGoodRulesOrder(potentialRulesOrder);
		// just map to the good type to return
		return mapPotentialRulesOrderToRulesOrder(potentialRulesOrder);
	}


	private Map<Rule, Integer> mapPotentialRulesOrderToRulesOrder(Map<Rule, Set<Integer>> potentialRulesOrder) {
		Map<Rule, Integer> rulesOrder = new HashMap<Rule, Integer>();
		for (Rule rule : potentialRulesOrder.keySet()) {
			rulesOrder.put(rule, potentialRulesOrder.get(rule).iterator().next());
			LOGGER.info("rule " + rule + " is at order " + rulesOrder.get(rule));
		}
		return rulesOrder;
	}



	private void cleanPotentialRulesOrdersToFindGoodRulesOrder(Map<Rule, Set<Integer>> potentialRulesOrder) {
		boolean allRulesOrderFound = false;
		while (!allRulesOrderFound) {
			for (Rule rule : potentialRulesOrder.keySet()) {
				if (isOrderFoundForRule(potentialRulesOrder, rule)) {
					int ruleOrder = potentialRulesOrder.get(rule).iterator().next();
					for (Rule otherRule : potentialRulesOrder.keySet()) {
						if (otherRule != rule) {
							potentialRulesOrder.get(otherRule).remove(ruleOrder);
						}
					}
				}
			}
			allRulesOrderFound = potentialRulesOrder.keySet().stream().allMatch(r -> isOrderFoundForRule(potentialRulesOrder, r));
		}
	}


	private boolean isOrderFoundForRule(Map<Rule, Set<Integer>> potentialRulesOrder, Rule rule) {
		return potentialRulesOrder.get(rule).size() == 1;
	}


	private void cleanPotentialRulesOrderWithValidTickets(List<Ticket> validTickets, Map<Rule, Set<Integer>> potentialRulesOrder) {
		for (int indexValue = 0; indexValue < potentialRulesOrder.keySet().size(); indexValue++) {
			for (Rule rule : potentialRulesOrder.keySet()) {
				for (Ticket ticket : validTickets) {
					if (!rule.isRuleRespected( ticket.getValues().get(indexValue) )) {
						potentialRulesOrder.get(rule).remove(indexValue);
					}
				}
			}
		}
	}


	private Map<Rule, Set<Integer>> initializePotentialRulesOrder(List<Rule> rules) {
		Map<Rule, Set<Integer>> potentialRulesOrder = new HashMap<>();
		rules.stream().forEach(r -> potentialRulesOrder.put(r, Stream.iterate(0, i -> i + 1).limit(rules.size()).collect(Collectors.toSet())));
		return potentialRulesOrder;
	}


	private long getProductOfDepartureValues(final Map<Rule, Integer> rulesOrder, final Ticket myTicket) {
		return rulesOrder.keySet().stream()
					.filter(r -> r.getName().startsWith("departure"))
					.map(rulesOrder::get)
					.mapToLong(myTicket.getValues()::get)
					.reduce(1, (a, b) -> a * b);
	}


	private List<Ticket> findValidTickets(final List<Rule> rules, final Ticket myTicket, final List<Ticket> otherTickets) {
		List<Ticket> validTickets = otherTickets.stream()
										.filter(t -> !isTicketInvalid(t, rules))
										.collect(Collectors.toList());
		validTickets.add(myTicket);
		return validTickets;
	}
	
	private boolean isTicketInvalid(Ticket ticket, List<Rule> rules) {
		return ticket.getValues().stream()
					.anyMatch(v -> rules.stream().allMatch(r -> !r.isRuleRespected(v)));
	}

}