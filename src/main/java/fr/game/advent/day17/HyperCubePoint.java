package fr.game.advent.day17;

import java.util.HashSet;
import java.util.Set;

public class HyperCubePoint {

	private int x;
	private int y;
	private int z;
	private int w;

	public HyperCubePoint(int x, int y, int z, int w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
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

	public int getW() {
		return w;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + w;
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
		HyperCubePoint other = (HyperCubePoint) obj;
		if (w != other.w)
			return false;
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
		return "HyperCubePoint [x=" + x + ", y=" + y + ", z=" + z + ", w=" + w + "]";
	}

	public Set<HyperCubePoint> getAdjacentPoints() {
		Set<HyperCubePoint> adjacentsPoints = new HashSet<>();
		for (int dx = -1; dx <= +1; dx++) {
			for (int dy = -1; dy <= +1; dy++) {
				for (int dz = -1; dz <= +1; dz++) {
					for (int dw = -1; dw <= +1; dw++) {
						if (dx != 0 || dy != 0 || dz != 0 || dw != 0) adjacentsPoints.add(new HyperCubePoint(x + dx, y + dy, z + dz, w + dw));
					}
				}
			}
		}
		return adjacentsPoints;
	}
}
