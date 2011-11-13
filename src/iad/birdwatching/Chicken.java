package iad.birdwatching;


public class Chicken extends Bird {

	public void sing() {
		System.out.println("Cluck");
	}
	
	@Override
	public void setLocation(Location location) {
		super.setLocation(location.flatten());
	}

}
