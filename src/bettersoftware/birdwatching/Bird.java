package bettersoftware.birdwatching;

public abstract class Bird {
	Location location;
	int height;
		
	public void setLocation(Location location) {
		this.location = location;
		
	}
	
	public Location getLocation() {
		return location;
	}
	
	public abstract void sing();

	public boolean wasHit(Location shotLocation) {
		if (shotLocation.equals(getLocation()))
		{
			sing();
			return true;
		}
		return false;
	}
}
