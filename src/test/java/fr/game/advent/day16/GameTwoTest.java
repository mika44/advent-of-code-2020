package fr.game.advent.day16;

import java.util.Arrays;
import java.util.logging.Level;

import org.junit.Assert;
import org.junit.Test;

import fr.game.utils.LoggerUtils;

public class GameTwoTest {

	private GameTwo game = new GameTwo();

	@Test
	public void testExemple1() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(Long.valueOf(11 * 13L),
				game.play(Arrays.asList(
						"class: 0-1 or 4-19",
						"departure row: 0-5 or 8-19",
						"departure seat: 0-13 or 16-19",
						"",
						"your ticket:",
						"11,12,13",
						"",
						"nearby tickets:",
						"3,9,18",
						"15,1,5",
						"5,14,9")));
	}


	@Test
	public void testGame() {
		LoggerUtils.setLevel(Level.WARNING);
		Assert.assertEquals(Long.valueOf(2766491048287L), game.play());
	}
}


