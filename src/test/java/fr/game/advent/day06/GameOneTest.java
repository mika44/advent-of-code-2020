package fr.game.advent.day06;

import java.util.Arrays;
import java.util.logging.Level;

import org.junit.Assert;
import org.junit.Test;

import fr.game.utils.LoggerUtils;

public class GameOneTest {

	private GameOne gameOne = new GameOne();

	@Test
	public void testExemple1() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(Integer.valueOf(6),
				gameOne.play(Arrays.asList(
						"abcx",
						"abcy",
						"abcz")));
	}

	@Test
	public void testExempleComplet() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(Integer.valueOf(11),
				gameOne.play(Arrays.asList(
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
		Assert.assertEquals(Integer.valueOf(6686), gameOne.play());
	}

}
