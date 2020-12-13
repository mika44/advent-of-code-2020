package fr.game.advent.day01;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;
import fr.game.utils.LoggerUtils;

public class GameTwo extends AbstractGame<Integer, Long> {

	private static final String INPUT_FILENAME = "day01/input-day01-1";

	private Logger log;

	public GameTwo() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, Integer::valueOf);
		LoggerUtils.setLevel(Level.INFO);
		log = LoggerUtils.getLogger();
	}

	
	private class Triplet {
		public int a, b, c;		

		public Triplet(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		public Long somme() {
			return 0L + a + b + c;
		}
		
		public Long produit() {
			return 1L * a * b * c;
		}

		@Override
		public String toString() {
			return "Triplet [a=" + a + ", b=" + b + ", c=" + c + "]";
		}		
	}
	
	@Override
	public Long play(List<Integer> listOfInputs) {
		Triplet coupleDontSommeEst2020 = trouverTripletDontSommeEst2020(listOfInputs);
		log.info(() -> coupleDontSommeEst2020.toString());
		return coupleDontSommeEst2020.produit();
	}

	private Triplet trouverTripletDontSommeEst2020(List<Integer> listOfInputs) {
		return listOfInputs.parallelStream()
			.flatMap(c -> listOfInputs.parallelStream().map(b -> new Triplet(0, b, c) ))
			.flatMap(t -> listOfInputs.parallelStream().map(a -> new Triplet(a, t.b, t.c) ))
			.filter(t -> t.somme() == 2020L)
			.findFirst()
			.get();
	}
}
