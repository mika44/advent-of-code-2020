package fr.game.advent.day16;

import java.util.Arrays;
import java.util.logging.Level;

import org.junit.Assert;
import org.junit.Test;

import fr.game.utils.LoggerUtils;

public class GameOneTest {

	private GameOne game = new GameOne();

	@Test
	public void testExemple1() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(Long.valueOf(71),
				game.play(Arrays.asList(
						"class: 1-3 or 5-7",
						"row: 6-11 or 33-44",
						"seat: 13-40 or 45-50",
						"",
						"your ticket:",
						"7,1,14",
						"",						
						"nearby tickets:",
						"7,3,47",
						"40,4,50",
						"55,2,20",
						"38,6,12")));
	}


	@Test
	public void testGame() {
		LoggerUtils.setLevel(Level.WARNING);
		Assert.assertEquals(Long.valueOf(27898), game.play());
	}
}
