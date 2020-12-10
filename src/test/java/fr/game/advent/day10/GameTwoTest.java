package fr.game.advent.day10;

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
		Assert.assertEquals(new Long(8L),
				game.play(Arrays.asList(
						16,
						10,
						15,
						5,
						1,
						11,
						7,
						19,
						6,
						12,
						4)));
	}


	@Test
	public void testExemple2() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(new Long(19208L),
				game.play(Arrays.asList(
						28,
						33,
						18,
						42,
						31,
						14,
						46,
						20,
						48,
						47,
						24,
						23,
						49,
						45,
						19,
						38,
						39,
						11,
						1,
						32,
						25,
						35,
						8,
						17,
						7,
						9,
						4,
						2,
						34,
						10,
						3)));
	}


	@Test
	public void testGame() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(new Long(338510590509056L), game.play());
	}

}
