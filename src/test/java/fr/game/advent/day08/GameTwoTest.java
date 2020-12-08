package fr.game.advent.day08;

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
		Assert.assertEquals(new Integer(8),
				game.play(Arrays.asList(
						"nop +0",
						"acc +1",
						"jmp +4",
						"acc +3",
						"jmp -3",
						"acc -99",
						"acc +1",
						"jmp -4",
						"acc +6")));
	}


	@Test
	public void testGame() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(new Integer(501), game.play());
	}

}
