package fr.game.advent.day16;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;
import fr.game.utils.LoggerUtils;

public class GameOne extends AbstractGame<String, Long> {
	
	private static final String INPUT_FILENAME = "day16/input-day16-1";
	
	private static final Logger LOGGER = LoggerUtils.getLogger();

	public GameOne() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, String::new);
	}


	@Override
	public Long play(List<String> listOfInputs) {
		int indexBlankLineBetweenRulesAndTickets = Stream.iterate(0,  index -> index + 1)
											.filter(index -> listOfInputs.get(index).isBlank())
											.findFirst()
											.get();
		
		List<Rule> rules = listOfInputs.stream()
								.limit(indexBlankLineBetweenRulesAndTickets)
								.peek(LOGGER::info)
								.map(Rule::mapToRule)
								.collect(Collectors.toList());
		
		//Ticket myTicket = Ticket.mapToTicket( listOfInputs.get(indexBlankLineBetweenRulesAndTickets + 2) );
		
		List<Ticket> otherTickets = listOfInputs.stream()
								.skip(indexBlankLineBetweenRulesAndTickets + 5)
								.peek(LOGGER::info)
								.map(Ticket::mapToTicket)
								.collect(Collectors.toList());
		
		return (long) otherTickets.stream()
			.flatMapToInt(t -> t.getValues().stream().mapToInt(v -> v))
			.filter(v -> noRuleRespected(rules, v))
			.sum();
	}


	private boolean noRuleRespected(List<Rule> rules, int value) {
		return rules.stream().allMatch(r -> !r.isRuleRespected(value));
	}

}