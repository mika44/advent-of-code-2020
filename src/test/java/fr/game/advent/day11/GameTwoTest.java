package fr.game.advent.day11;

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
		Assert.assertEquals(new Long(26L),
				game.play(Arrays.asList(
						"L.LL.LL.LL",
						"LLLLLLL.LL",
						"L.L.L..L..",
						"LLLL.LL.LL",
						"L.LL.LL.LL",
						"L.LLLLL.LL",
						"..L.L.....",
						"LLLLLLLLLL",
						"L.LLLLLL.L",
						"L.LLLLL.LL")));
	}


	@Test
	public void testGame() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(new Long(2054), game.play());
	}

}
