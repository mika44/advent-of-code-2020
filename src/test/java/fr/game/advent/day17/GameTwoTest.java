package fr.game.advent.day17;

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
		Assert.assertEquals(Long.valueOf(848),
				game.play(Arrays.asList(
						".#.",
						"..#",
						"###")));
	}


	@Test
	public void testGame() {
		LoggerUtils.setLevel(Level.WARNING);
		Assert.assertEquals(Long.valueOf(1908L), game.play());
	}
}
