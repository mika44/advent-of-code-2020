package fr.game.advent.day17;

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
		Assert.assertEquals(Long.valueOf(112),
				game.play(Arrays.asList(
						".#.",
						"..#",
						"###")));
	}


	@Test
	public void testGame() {
		LoggerUtils.setLevel(Level.WARNING);
		Assert.assertEquals(Long.valueOf(218L), game.play());
	}
}
