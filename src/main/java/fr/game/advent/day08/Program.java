package fr.game.advent.day08;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
	
	private List<Instruction> instructions;
	private List<Boolean> alreadyExecuted;
	
	private int accumulator;
	private int executionPointer;
	
	private Program() {
		instructions = new ArrayList<>(); 
	}
	
	public boolean isTerminatingWithoutInfiniteLoop() {
		return executionPointer >= instructions.size();
	}
	
	public int getAccumulator() {
		return accumulator;
	}

	public Integer executeUntilFirstAlreadyExecutedOrEndOfProgram() {
		reinitializeAlreadyExecuted();
		accumulator = 0;
		executionPointer = 0;
		while (!isTerminatingWithoutInfiniteLoop() && !alreadyExecuted.get(executionPointer)) {
			executeOperation();
		}
		return accumulator;
	}
	
	private void executeOperation() {
		alreadyExecuted.set(executionPointer, true);
		Instruction currentInstruction = instructions.get(executionPointer);
		switch (currentInstruction.getOperation()) {
			case NOP:
				executionPointer++;
				break;
			case ACC:
				accumulator = accumulator + currentInstruction.getArgument();
				executionPointer++;
				break;
			case JMP:
				executionPointer = executionPointer + currentInstruction.getArgument();
				break;
			default: break;
		}  
	}

	private void reinitializeAlreadyExecuted() {
		alreadyExecuted = instructions.stream()
							.map(i -> false)
							.collect(Collectors.toList());
	}

	public static Program mapToProgram(List<String> input) {
		Program program =new Program();
		program.instructions = input.stream()
									.map(Instruction::mapToInstruction)
									.collect(Collectors.toList());
		return program;
	}
}
