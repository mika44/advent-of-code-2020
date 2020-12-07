package fr.game.advent.day07;

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
		Assert.assertEquals(new Integer(4),
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
	public void testGame() {
		LoggerUtils.setLevel(Level.INFO);
		Assert.assertEquals(new Integer(265), game.play());
	}

}
