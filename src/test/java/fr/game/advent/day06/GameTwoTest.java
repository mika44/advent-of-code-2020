package fr.game.advent.day06;

import java.util.Arrays;
import java.util.logging.Level;

import org.junit.Assert;
import org.junit.Test;

import fr.game.utils.LoggerUtils;

public class GameTwoTest {

	private GameTwo game = new GameTwo();

	@Test
	public void testExempleComplet() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(new Integer(6),
				game.play(Arrays.asList(
						"abc",
						"",
						"a",
						"b",
						"c",
						"",
						"ab",
						"ac",
						"",
						"a",
						"a",
						"a",
						"a",
						"",
						"b")));
	}

	@Test
	public void testGame() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(new Integer(3476), game.play());
	}

}
