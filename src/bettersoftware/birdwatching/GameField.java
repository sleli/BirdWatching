package bettersoftware.birdwatching;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameField {
	
	public enum PlacingMode {
	    Custom, Random 
	}
	
	List<Bird> birds;
	int width;
	int height; 
	int depth;
	boolean gameStarted;
	private FieldSize fieldSize;
	

	public GameField(int width, int height, int depth, FieldSize fieldSize) {
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.fieldSize = fieldSize;
		birds = new ArrayList<Bird>();
	}
	
	public void addBird(Bird b) {
		birds.add(b);
	}
	
	
	//Start the game
	public boolean startGame(PlacingMode pm) {
		try {
			placeBirds(pm);
			gameStarted = (birds.size() > 0 && isGameFieldValid());
		} catch (Exception e) {
			gameStarted = false;
		}
		return gameStarted;
	}
	
	//Shot to a bird
	public boolean shot(int x, int y, int h) {
		boolean hit = false;
		if (gameStarted)
		{
			for(Bird bird : birds) {
				int height = bird.getHeight();
				Location location = bird.getLocation();
				hit =  location.x == x && location.y == y && height == h;
				if (hit)
				{
					bird.sing();
					break;
				}
			}
		}
         return hit;   
	}
	
	//Place the birds on the fields
	private void placeBirds(PlacingMode type) throws Exception {
			
		//Random Distribution
		if (type == PlacingMode.Random) {
			for(Bird bird : birds) {
				Location location = new Location(new Random().nextInt(this.width), new Random().nextInt(this.height));
				bird.setLocation(location);
				if (!(bird instanceof Chicken))
					bird.setHeight(new Random().nextInt(this.depth));
			}
		} 
		//Custom Distribution
		else if (type == PlacingMode.Custom) {
			
		}
	}
	
	//Check if the GameField is Valid
	private boolean isGameFieldValid()
	{
		boolean isValid = true;
		for(Bird bird : birds) {
			int h = bird.getHeight();
			Location location = bird.getLocation();
			int x = location.x;
			int y = location.y;
			isValid =  fieldSize.isWithinField(h, x, y);
			if (!isValid)
				break;
		}
		return isValid;
		
	}
	

}
