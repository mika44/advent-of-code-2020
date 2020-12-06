package fr.game.advent.day06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAnswersUtils {

	private static final String GROUP_ANSWERS_SEPARATOR = "!";
	private static final String ANSWERS_SEPARATOR = " ";

	private static String joinInUniqueString(List<String> listOfInputs) {
		return listOfInputs.stream()
				.map(s -> s.isEmpty() ? GROUP_ANSWERS_SEPARATOR : s + ANSWERS_SEPARATOR)
				.collect(Collectors.joining());
	}
	
	private static Stream<String> aggregateInputsInGroupAnswerStrings(List<String> listOfInputs) {
		return Arrays.stream(joinInUniqueString(listOfInputs).split(GROUP_ANSWERS_SEPARATOR));
	}
	
	private static List<String> getAnswersFromAggregateAnswers(String aggregateAnswers) {
		return Arrays.stream(aggregateAnswers.split(ANSWERS_SEPARATOR))
					.collect(Collectors.toList());
	}
	
	public static Stream<GroupAnswers> mapToGroupAnswersStream(List<String> listOfInputs) {
		return aggregateInputsInGroupAnswerStrings(listOfInputs)
				.map(GroupAnswersUtils::getAnswersFromAggregateAnswers)
				.map(GroupAnswers::new);
	}

/* Other solution */
//	public static Stream<GroupAnswer> mapToGroupAnswersStream(List<String> listOfInputs) {
//		List<GroupAnswer> groupAnswers = new ArrayList<GroupAnswer>();
//		GroupAnswer currentGroupAnswer = new GroupAnswer();
//		for (String aLine : listOfInputs) {
//			if (aLine.isEmpty()) {
//				groupAnswers.add(currentGroupAnswer);
//				currentGroupAnswer = new GroupAnswer();
//			} else {
//				currentGroupAnswer.addAnswer(aLine);
//			}
//		}
//		groupAnswers.add(currentGroupAnswer);
//		return groupAnswers.stream();
//	}
}
