package fr.game.advent.day15;

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
		Assert.assertEquals(Long.valueOf(175594),
				game.play(Arrays.asList(
						"0,3,6")));
	}


	@Test
	public void testExemple2() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(Long.valueOf(2578),
				game.play(Arrays.asList(
						"1,3,2")));
	}


	@Test
	public void testExemple3() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(Long.valueOf(3544142),
				game.play(Arrays.asList(
						"2,1,3")));
	}


	@Test
	public void testExemple4() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(Long.valueOf(261214),
				game.play(Arrays.asList(
						"1,2,3")));
	}


	@Test
	public void testExemple5() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(Long.valueOf(6895259),
				game.play(Arrays.asList(
						"2,3,1")));
	}


	@Test
	public void testExemple6() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(Long.valueOf(18),
				game.play(Arrays.asList(
						"3,2,1")));
	}


	@Test
	public void testExemple7() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(Long.valueOf(362),
				game.play(Arrays.asList(
						"3,1,2")));
	}


	@Test
	public void testGame() {
		LoggerUtils.setLevel(Level.WARNING);
		Assert.assertEquals(Long.valueOf(8984), game.play());
	}
}
