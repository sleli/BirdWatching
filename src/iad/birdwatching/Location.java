package iad.birdwatching;

public class Location {
	private int x = 0;
	private int y = 0;
	private int z = 0;
	
	public Location (int x, int y) {
		 this(x,y,0);
	}

	public Location(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

    public int x() { return x; }
    public int y() { return y; }
    public int z() { return z; }

    public Location flatten() {
        return new Location(x,y,0);
    }
	
	@Override
	public boolean equals(Object obj) {
		Location otherLocation = (Location)obj; 
		return (otherLocation.x() == this.x()) && (otherLocation.y() == this.y()) && (otherLocation.z() == this.z());
	}
}
