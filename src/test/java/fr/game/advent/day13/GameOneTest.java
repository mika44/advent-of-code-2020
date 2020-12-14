package fr.game.advent.day13;

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
		Assert.assertEquals(Integer.valueOf(295),
				game.play(Arrays.asList(
						"939",
						"7,13,x,x,59,x,31,19")));
	}


	@Test
	public void testGame() {
		Assert.assertEquals(Integer.valueOf(2092), game.play());
	}

}
