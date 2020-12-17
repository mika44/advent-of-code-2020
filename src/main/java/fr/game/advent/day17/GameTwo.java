package fr.game.advent.day17;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import fr.game.utils.AbstractGame;
import fr.game.utils.FileUtils;
import fr.game.utils.LoggerUtils;

public class GameTwo extends AbstractGame<String, Long> {
	
	private static final int NUMBER_OF_CYCLES = 6;

	private static final String INPUT_FILENAME = "day17/input-day17-1";
	
	private static final Logger LOGGER = LoggerUtils.getLogger();

	public GameTwo() {
		super(FileUtils::getListFromFile, INPUT_FILENAME, String::new);
	}


	@Override
	public Long play(final List<String> listOfInputs) {
		Set<HyperCubePoint> activePoints = extractInitialActivePoints(listOfInputs);
		
		int cycle = 0;
		LOGGER.info("before any cycle -> " + activePoints.size() + " actives");
		while (cycle < NUMBER_OF_CYCLES) {
			cycle++;
			activePoints = applyCycle(activePoints);
			LOGGER.info("after cycle " + cycle + " -> " + activePoints.size() + " actives");
		}
		
		return (long) activePoints.size();
	}

	private Set<HyperCubePoint> applyCycle(final Set<HyperCubePoint> activePoints) {
		int minX = activePoints.stream().mapToInt(HyperCubePoint::getX).min().getAsInt() - 1;
		int maxX = activePoints.stream().mapToInt(HyperCubePoint::getX).max().getAsInt() + 1;
		int minY = activePoints.stream().mapToInt(HyperCubePoint::getY).min().getAsInt() - 1;
		int maxY = activePoints.stream().mapToInt(HyperCubePoint::getY).max().getAsInt() + 1;
		int minZ = activePoints.stream().mapToInt(HyperCubePoint::getZ).min().getAsInt() - 1;
		int maxZ = activePoints.stream().mapToInt(HyperCubePoint::getZ).max().getAsInt() + 1;
		int minW = activePoints.stream().mapToInt(HyperCubePoint::getW).min().getAsInt() - 1;
		int maxW = activePoints.stream().mapToInt(HyperCubePoint::getW).max().getAsInt() + 1;
		
		Set<HyperCubePoint> newActivePoints = new HashSet<>(); 
		for (int x = minX; x <= maxX; x++) {
			for (int y = minY; y <= maxY; y++) {
				for (int z = minZ; z <= maxZ; z++) {
					for (int w = minW; w <= maxW; w++) {
						HyperCubePoint point = new HyperCubePoint(x, y, z, w);
						if (isActiveAfterCycle(point, activePoints)) newActivePoints.add(point);
					}
				}
			}
		}
		return newActivePoints;
	}

	private boolean isActiveAfterCycle(final HyperCubePoint point, final Set<HyperCubePoint> activePoints) {
		if (activePoints.contains(point)) {
			return remainsActive(countAdjacentActivePoints(point, activePoints));
		} 
		return becomeActive(countAdjacentActivePoints(point, activePoints));
	}


	private long countAdjacentActivePoints(final HyperCubePoint point, final Set<HyperCubePoint> activePoints)  {
		return point.getAdjacentPoints().stream().filter(activePoints::contains).count();
	}


	private boolean becomeActive(final long countAdjacentActives) {
		return countAdjacentActives == 3L;
	}


	private boolean remainsActive(final long countAdjacentActives) {
		return countAdjacentActives == 2L || countAdjacentActives == 3L;
	}


	private Set<HyperCubePoint> extractInitialActivePoints(final List<String> listOfInputs) {
		Set<HyperCubePoint> activePoints = new HashSet<>();
		for (int y = 0; y < listOfInputs.size(); y++) {
			for (int x = 0; x < listOfInputs.get(y).length(); x++) {
				if (listOfInputs.get(y).charAt(x) == '#') activePoints.add(new HyperCubePoint(x, y, 0, 0));
			}
		}
		return activePoints;
	}


}