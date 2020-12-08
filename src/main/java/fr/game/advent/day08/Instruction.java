package fr.game.advent.day08;

public class Instruction {

	private Operation operation;
	private int argument;

	Instruction(Operation operation, int argument) {
		super();
		this.operation = operation;
		this.argument = argument;
	}

	public Operation getOperation() {
		return operation;
	}

	public int getArgument() {
		return argument;
	}

	@Override
	public String toString() {
		return "Instruction [operation=" + operation + ", argument=" + argument + "]";
	}

	public static Instruction mapToInstruction(String instructionString) {
		String[] decomposition = instructionString.split(" ");
		Operation operation = Operation.mapToOperation(decomposition[0]);
		int argument = Integer.valueOf(decomposition[1]);
		return new Instruction(operation, argument);
	}

}
