package fr.game.advent.day17;

import java.util.HashSet;
import java.util.Set;

public class CubePoint {

	private int x;
	private int y;
	private int z;

	public CubePoint(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		result = prime * result + z;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CubePoint other = (CubePoint) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		if (z != other.z)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	public Set<CubePoint> getAdjacentPoints() {
		Set<CubePoint> adjacentsPoints = new HashSet<>();
		for (int dx = -1; dx <= +1; dx++) {
			for (int dy = -1; dy <= +1; dy++) {
				for (int dz = -1; dz <= +1; dz++) {
					if (dx != 0 || dy != 0 || dz != 0) adjacentsPoints.add(new CubePoint(x + dx, y + dy, z + dz));
				}
			}
		}
		return adjacentsPoints;
	}
}
