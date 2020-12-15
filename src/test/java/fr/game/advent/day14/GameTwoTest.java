package fr.game.advent.day14;

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
		Assert.assertEquals(Long.valueOf(208),
				game.play(Arrays.asList(
						"mask = 000000000000000000000000000000X1001X",
						"mem[42] = 100",
						"mask = 00000000000000000000000000000000X0XX",
						"mem[26] = 1")));
	}


	@Test
	public void testGame() {
		LoggerUtils.setLevel(Level.WARNING);
		Assert.assertEquals(Long.valueOf(3296185383161L), game.play());
	}
}