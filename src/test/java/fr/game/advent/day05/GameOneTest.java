package fr.game.advent.day05;

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
		Assert.assertEquals(Integer.valueOf(357),
				gameOne.play(Arrays.asList(
						"FBFBBFFRLR")));
	}

	@Test
	public void testMax() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(Integer.valueOf(820),
				gameOne.play(Arrays.asList(
						"BFFFBBFRRR",
						"FFFBBBFRRR",
						"BBFFBBFRLL")));
	}

	@Test
	public void testGame() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(Integer.valueOf(919), gameOne.play());
	}

}
