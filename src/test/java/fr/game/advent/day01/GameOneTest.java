package fr.game.advent.day01;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class GameOneTest {

	private GameOne gameOne = new GameOne();

	@Test
	public void testExemple1() {
		Assert.assertEquals(new Long(514579), gameOne.play(Arrays.asList(1721, 979, 366, 299, 675, 1456)));
	}

	@Test
	public void testGame() {
		Assert.assertEquals(new Long(121396), gameOne.play());
	}

}
