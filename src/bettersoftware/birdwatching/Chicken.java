package bettersoftware.birdwatching;

public class Chicken extends Bird {

	public void sing() {
		System.out.println("Cluck");
	}
	
	@Override
	public void setHeight(int height) throws Exception {
		throw new Exception("I can't fly");
	}

}
