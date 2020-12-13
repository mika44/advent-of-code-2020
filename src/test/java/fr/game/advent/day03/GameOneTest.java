package fr.game.advent.day03;

import java.util.Arrays;
import java.util.logging.Level;

import org.junit.Assert;
import org.junit.Test;

import fr.game.utils.LoggerUtils;

public class GameOneTest {

	private GameOne gameOne = new GameOne();

	@Test
	public void testExemple1() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(Long.valueOf(7),
				gameOne.play(Arrays.asList(
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
		Assert.assertEquals(Long.valueOf(244), gameOne.play());
	}

}
