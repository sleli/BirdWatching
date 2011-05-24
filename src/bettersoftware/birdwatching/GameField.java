package bettersoftware.birdwatching;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bettersoftware.birdwatching.placing.IPlacingStrategy;


public class GameField {
	
	private List<Bird> birds;
	private int length;
	private int width; 
	private int height;
	
	public GameField(int length, int width, int height) {
		this.length = length;
		this.width = width;
		this.height = height;
		birds = new ArrayList<Bird>();
	}
	
	public void addBird(Bird b) {
		birds.add(b);
	}
	
	public Iterator<Bird> getBirds() {
		return birds.iterator();
	}
	
	
	//Place the birds on the fields
	public void placeBirds(IPlacingStrategy strategy)  {
		strategy.place(birds, length, width, height);
	}
	
	//Check if the HuntingField is Valid
	public boolean isHuntingFieldValid()
	{
		boolean isValid = false;
		for(Bird bird : birds) {
			int h = 0;
			if (bird instanceof FlyingBird)
				h = ((FlyingBird)bird).getHeight();
			Location location = bird.getLocation();
			isValid =  h >= 0 && h <= this.height && location.isWithinArea(length, width);
			if (!isValid)
				break;
		}
		return isValid;
	}
	
}
