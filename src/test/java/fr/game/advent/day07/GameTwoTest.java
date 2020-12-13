package fr.game.advent.day07;

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
		Assert.assertEquals(Integer.valueOf(32),
				game.play(Arrays.asList(
						"light red bags contain 1 bright white bag, 2 muted yellow bags.",
						"dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
						"bright white bags contain 1 shiny gold bag.",
						"muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
						"shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
						"dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
						"vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
						"faded blue bags contain no other bags.",
						"dotted black bags contain no other bags.")));
	}


	@Test
	public void testExemple2() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(Integer.valueOf(126),
				game.play(Arrays.asList(
						"shiny gold bags contain 2 dark red bags.",
						"dark red bags contain 2 dark orange bags.",
						"dark orange bags contain 2 dark yellow bags.",
						"dark yellow bags contain 2 dark green bags.",
						"dark green bags contain 2 dark blue bags.",
						"dark blue bags contain 2 dark violet bags.",
						"dark violet bags contain no other bags.")));
	}


	@Test
	public void testGame() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(Integer.valueOf(14177), game.play());
	}

}
