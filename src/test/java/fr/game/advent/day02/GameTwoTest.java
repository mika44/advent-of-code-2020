package fr.game.advent.day02;

import java.util.Arrays;
import java.util.logging.Level;

import org.junit.Assert;
import org.junit.Test;

import fr.game.utils.LoggerUtils;

public class GameTwoTest {

	private GameTwo gameTwo = new GameTwo();

	@Test
	public void testExemple1() {
		Assert.assertEquals(new Long(1),
				gameTwo.play(Arrays.asList("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc")));
	}

	@Test
	public void testGame() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(new Long(699), gameTwo.play());
	}

}
