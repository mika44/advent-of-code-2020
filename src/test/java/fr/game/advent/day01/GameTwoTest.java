package fr.game.advent.day01;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class GameTwoTest {
	
	private GameTwo gameTwo = new GameTwo();

	@Test
	public void testExemple1() {
		Assert.assertEquals(new Long(241861950), gameTwo.play(Arrays.asList(1721, 979, 366, 299, 675, 1456)));
	}

	@Test
	public void testGame() {
		Assert.assertEquals(new Long(73616634), gameTwo.play());
	}
	
}
