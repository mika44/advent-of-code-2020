package fr.game.advent.day12;

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
		Assert.assertEquals(Integer.valueOf(286),
				game.play(Arrays.asList(
						"F10",
						"N3",
						"F7",
						"R90",
						"F11")));
	}


	@Test
	public void testGame() {
		LoggerUtils.setLevel(Level.WARNING);
		Assert.assertEquals(Integer.valueOf(23960), game.play());
	}

}
