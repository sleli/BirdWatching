package bettersoftware.birdwatching;

public class Location {
	private int x = 0;
	private int y = 0;
	
	public Location (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean isWithinArea(int length, int width) {
		return (x >= 0 && x <= length && y >= 0 && y <= width);
	}
	
	public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass())
            return false;
        if (obj == this)
            return true;
        Location location = (Location) obj;
        return location.x == x && location.y == y;
    }
	
}
