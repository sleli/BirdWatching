package bettersoftware.birdwatching;

public abstract class Bird {
	Location location;
	int height;
	
	public void setHeight(int height) throws Exception{
		this.height = height;	
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setLocation(Location location) {
		this.location = location;
		
	}
	
	public Location getLocation() {
		return location;
	}
	
	public abstract void sing();
}
