package fr.game.advent.day01;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;
import fr.game.utils.LoggerUtils;

public class GameOne extends AbstractGame<Integer, Long> {
	
	private static final String INPUT_FILENAME = "day01/input-day01-1";
	
	private Logger log;

	public GameOne() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, Integer::new);
		LoggerUtils.setLevel(Level.INFO);
		log = LoggerUtils.getLogger();
	}

	
	private class Couple {
		private int a, b;
		
		public Couple(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public Long somme() {
			return 0L + a + b;
		}
		
		public Long produit() {
			return 1L * a * b;
		}

		@Override
		public String toString() {
			return "Couple [a=" + a + ", b=" + b + "]";
		}
		
		
	}
	
	@Override
	public Long play(List<Integer> listOfInputs) {
		Couple coupleDontSommeEst2020 = trouverCoupleDontSommeEst2020(listOfInputs);
		log.info(() -> coupleDontSommeEst2020.toString());
		return coupleDontSommeEst2020.produit();
	}

	private Couple trouverCoupleDontSommeEst2020(List<Integer> listOfInputs) {
		return listOfInputs.parallelStream()
			.flatMap(b -> listOfInputs.parallelStream().map(a -> new Couple(a, b)) )
			.filter(c -> c.somme() == 2020L)
			.findFirst()
			.get();
	}

}
