package fr.game.advent.day08;

import java.util.List;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;

public class GameTwo extends AbstractGame<String, Integer> {
	
	private static final String INPUT_FILENAME = "day08/input-day08-1";
	
	public GameTwo() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, String::new);
	}
	
	@Override
	public Integer play(List<String> linesOfCode) {
		for (int indexInstruction = 0; indexInstruction < linesOfCode.size(); indexInstruction++) {
			if (isInstructionWithOperation(linesOfCode, indexInstruction, Operation.NOP)) {
				Program program = changeInstructionAndExecuteProgram(linesOfCode, indexInstruction, Operation.NOP, Operation.JMP);
				if (program.isTerminatingWithoutInfiniteLoop()) return program.getAccumulator();
			} 
			else if (isInstructionWithOperation(linesOfCode, indexInstruction, Operation.JMP)) {
				Program program = changeInstructionAndExecuteProgram(linesOfCode, indexInstruction, Operation.JMP, Operation.NOP);
				if (program.isTerminatingWithoutInfiniteLoop()) return program.getAccumulator();
			}
		}
		return 0;
	}

	private boolean isInstructionWithOperation(List<String> listOfInputs, int indexInstruction, Operation operation) {
		return listOfInputs.get(indexInstruction).startsWith(operation.getOperationString());
	}

	private Program changeInstructionAndExecuteProgram(List<String> linesOfCode, int indexInstructionToChange, Operation oldInstruction, Operation newInstruction) {
		String originalInput = new String(linesOfCode.get(indexInstructionToChange));
		linesOfCode.set(indexInstructionToChange, linesOfCode.get(indexInstructionToChange).replace(oldInstruction.getOperationString(), newInstruction.getOperationString()));
		Program program = createAndExecuteProgram(linesOfCode);
		linesOfCode.set(indexInstructionToChange, originalInput);
		return program;
	}
	
	private Program createAndExecuteProgram(List<String> linesOfCode) {
		Program program = Program.mapToProgram(linesOfCode);
		program.executeUntilFirstAlreadyExecutedOrEndOfProgram();
		return program;
	}
	
}
