package fr.game.advent.day11;

import java.util.HashMap;
import java.util.Map;

public enum CaseContent {
	FREE('L'),
	OCCUPIED('#'),
	FLOOR('.');
	
	private char content;

	private CaseContent(char content) {
		this.content = content;
	}
	
	public char getContent() {
		return content;
	}

	private static Map<Character, CaseContent> map;
	
	private static void fillMap() {
		map = new HashMap<>();
		for (CaseContent caseContent : values()) {
			map.put(caseContent.content, caseContent);
		}
	}
	
	public static CaseContent mapToCaseContent(char content) {
		if (map == null) {
			fillMap();
		}
		return map.get(content);
	}

}
