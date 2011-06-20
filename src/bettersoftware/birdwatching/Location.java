package bettersoftware.birdwatching;

public class Location {
	int x = 0;
	int y = 0;
	int h;
	
	public Location (int x, int y) {
		 this(x,y,0);
	}

	public Location(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.h = z;
	}
	
	@Override
	public boolean equals(Object obj) {
		Location otherLocation = (Location)obj; 
		return (otherLocation.x == this.x) && (otherLocation.y == this.y) && (otherLocation.h == this.h);
	}

}
