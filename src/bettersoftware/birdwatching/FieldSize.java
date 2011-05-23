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

	public boolean isWithinField(int h, int x, int y) {
		return h >= 0 && h <= depth && (x >= 0 && x <= width && y >= 0 && y <= height);
	}
}
