package fr.game.advent.day13;

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
		Assert.assertEquals(Long.valueOf(1068781),
				game.play(Arrays.asList(
						"no use",
						"7,13,x,x,59,x,31,19")));
	}


	@Test
	public void testExemple2() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(Long.valueOf(3417),
				game.play(Arrays.asList(
						"no use",
						"17,x,13,19")));
	}


	@Test
	public void testExemple3() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(Long.valueOf(754018),
				game.play(Arrays.asList(
						"no use",
						"67,7,59,61")));
	}


	@Test
	public void testExemple4() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(Long.valueOf(779210),
				game.play(Arrays.asList(
						"no use",
						"67,x,7,59,61")));
	}


	@Test
	public void testExemple5() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(Long.valueOf(1261476),
				game.play(Arrays.asList(
						"no use",
						"67,7,x,59,61")));
	}


	@Test
	public void testExemple6() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(Long.valueOf(1202161486),
				game.play(Arrays.asList(
						"no use",
						"1789,37,47,1889")));
	}


	@Test
	public void testGame() {
		Assert.assertEquals(Long.valueOf(702970661767766L), game.play());
	}

}
