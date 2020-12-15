package fr.game.advent.day14;

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
		Assert.assertEquals(Long.valueOf(165),
				game.play(Arrays.asList(
						"mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X",
						"mem[8] = 11",
						"mem[7] = 101",
						"mem[8] = 0")));
	}


	@Test
	public void testGame() {
		LoggerUtils.setLevel(Level.WARNING);
		Assert.assertEquals(Long.valueOf(14862056079561L), game.play());
	}
}
