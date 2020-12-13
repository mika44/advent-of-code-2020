package fr.game.advent.day03;

import java.util.Arrays;
import java.util.logging.Level;

import org.junit.Assert;
import org.junit.Test;

import fr.game.utils.LoggerUtils;

public class GameTwoTest {

	private GameTwo gameTwo = new GameTwo();

	@Test
	public void testExemple1() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(Long.valueOf(336),
				gameTwo.play(Arrays.asList(
						"..##.......",
						"#...#...#..",
						".#....#..#.",
						"..#.#...#.#",
						".#...##..#.",
						"..#.##.....",
						".#.#.#....#",
						".#........#",
						"#.##...#...",
						"#...##....#",
						".#..#...#.#")));
	}

	@Test
	public void testGame() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(Long.valueOf(9406609920L), gameTwo.play());
	}

}
