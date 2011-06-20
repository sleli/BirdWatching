package bettersoftware.birdwatching;


public class Chicken extends Bird {

	public void sing() {
		System.out.println("Cluck");
	}
	
	@Override
	public void setLocation(Location location) {
		location.h = 0;
		super.setLocation(location);
	}

}
