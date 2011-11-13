package iad.birdwatching;

public class GridSize {

	private final int width;
	private final int height;
	private final int depth;

	public GridSize(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	public int height() {
		return height;
	}

	public int width() {
		return width;
	}

	public int depth() {
		return depth;
	}

	public boolean isWithinGrid(Location location) {
		return location.z() >= 0 && location.z() <= depth && (location.x() >= 0 && location.x() <= width && location.y() >= 0 && location.y() <= height);
	}
}
