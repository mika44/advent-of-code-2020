package fr.game.advent.day09;

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
		game.setPreambleSize(5);
		Assert.assertEquals(new Long(127L),
				game.play(Arrays.asList(
						35L,
						20L,
						15L,
						25L,
						47L,
						40L,
						62L,
						55L,
						65L,
						95L,
						102L,
						117L,
						150L,
						182L,
						127L,
						219L,
						299L,
						277L,
						309L,
						576L)));
	}


	@Test
	public void testGame() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(new Long(556543474L), game.play());
	}

}
