package fr.game.advent.day03;

import java.util.List;
import java.util.logging.Logger;

import fr.game.utils.LoggerUtils;

public class MapOfTrees {

	private static final char TREE = '#';
	private static final Logger LOGGER = LoggerUtils.getLogger();

	private int height;
	private int width;
	private List<String> inputMapOfTrees;

	public MapOfTrees(List<String> inputMapOfTrees) {
		this.inputMapOfTrees = inputMapOfTrees;
		height = inputMapOfTrees.size();
		width = inputMapOfTrees.get(0).length();
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public boolean isATree(int x, int y) {
		final int correctedX = x % width;
		final int correctedY = y % height;
		final char position = inputMapOfTrees.get(correctedY).charAt(correctedX);
		LOGGER.info(String.format("isATree avec (x, y) = (%s, %s) corrigé en (%s, %s) donne '%s'.", x, y, correctedX, correctedY, position));
		return position == TREE;
	}
}
