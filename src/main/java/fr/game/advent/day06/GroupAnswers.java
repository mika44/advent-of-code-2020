package fr.game.advent.day06;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupAnswers {

	private static final String ALL_MARKS = "abcdefghijklmnopqrstuvwxyz";
	
	private List<String> answers;
	
//	public GroupAnswers() {
//		this(new ArrayList<String>());
//	}
//	
	public GroupAnswers(List<String> answers) {
		this.answers = answers;
	}
	
//	public void addAnswer(String newAnswer) {
//		answers.add(newAnswer);
//	}
	
	public int getNumberOfQuestionsToWhichAnyoneAnsweredYes() {
		return (int) answers.stream()
					.flatMapToInt(String::chars)
					.distinct()
					.count()
					;
	}
	
	public int getNumberOfQuestionsToWhichEveryoneAnsweredYes() {
		final Function<String, Set<Integer>> mapToSet =  s -> s.chars().mapToObj(i -> i).collect(Collectors.toSet());
		return answers.stream()
					.map(mapToSet)
					.reduce(mapToSet.apply(ALL_MARKS), (a, b) ->  {a.retainAll(b); return a;})
					.size()
					;
	}
}
