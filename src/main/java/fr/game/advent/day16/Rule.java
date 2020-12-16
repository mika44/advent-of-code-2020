package fr.game.advent.day16;

public class Rule {

	private String name;
	private int minFirstRange;
	private int maxFirstRange;
	private int minSecondRange;
	private int maxSecondRange;

	private Rule(String name, int minFirstRange, int maxFirstRange, int minSecondRange, int maxSecondRange) {
		this.name = name;
		this.minFirstRange = minFirstRange;
		this.maxFirstRange = maxFirstRange;
		this.minSecondRange = minSecondRange;
		this.maxSecondRange = maxSecondRange;
	}
	
	public boolean isRuleRespected(int value) {
		return (value >= minFirstRange && value <= maxFirstRange) 
				|| 
			   (value >= minSecondRange && value <= maxSecondRange);
	}

	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Rule [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rule other = (Rule) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public static Rule mapToRule(String input) {
		String[] decomposition = input.split(": ");
		String name = decomposition[0];
		String[] decompositionRanges = decomposition[1].split(" or |-");
		int minFirstRange = Integer.valueOf(decompositionRanges[0]);
		int maxFirstRange = Integer.valueOf(decompositionRanges[1]);
		int minSecondtRange = Integer.valueOf(decompositionRanges[2]);
		int maxSecondRange = Integer.valueOf(decompositionRanges[3]);
		return new Rule(name, minFirstRange, maxFirstRange, minSecondtRange, maxSecondRange);
	}
}
