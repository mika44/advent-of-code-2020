package fr.game.advent.day08;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
	NOP("nop"),
	ACC("acc"),
	JMP("jmp");
	
	private String operationString;

	private Operation(String operationString) {
		this.operationString = operationString;
	}
	
	public String getOperationString() {
		return operationString;
	}

	private static Map<String, Operation> mapStringToOperation;
	
	private static void fillMapStringToOperation() {
		mapStringToOperation = new HashMap<>();
		for (Operation anOperation : Operation.values()) {
			mapStringToOperation.put(anOperation.operationString, anOperation);
		}
	}
	
	public static Operation mapToOperation(String operationString) {
		if (mapStringToOperation == null) {
			fillMapStringToOperation();
		}
		return mapStringToOperation.get(operationString);
	}
}
