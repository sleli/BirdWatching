package bettersoftware.birdwatching;

public class FieldSize {

	private final int width;
	private final int height;
	private final int depth;

	public FieldSize(int width, int height, int depth) {
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

	public boolean isWithinField(Location location) {
		return location.h >= 0 && location.h <= depth && (location.x >= 0 && location.x <= width && location.y >= 0 && location.y <= height);
	}
}
