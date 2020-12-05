package fr.game.advent.day05;

import java.util.logging.Level;

import org.junit.Assert;
import org.junit.Test;

import fr.game.utils.LoggerUtils;

public class GameTwoTest {

	private GameTwo gameTwo = new GameTwo();

	@Test
	public void testGame() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(new Integer(-1), gameTwo.play());
	}

}
