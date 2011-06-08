package bettersoftware.birdwatching;

import java.util.Iterator;

import bettersoftware.birdwatching.placing.IPlacingStrategy;

public class BirdWatchingGame {
	
	private GameField field;
	private boolean gameStarted;
	
	public BirdWatchingGame(GameField field)
	{
		this.field = field;
	}
	
	//Start the game
	public boolean startGame(IPlacingStrategy strategy) {
		field.placeBirds(strategy);
		gameStarted = field.isGameFieldValid();
		return gameStarted;
	}
	
	//Shot to a bird
	public boolean shot(int x, int y, int h) {
		boolean hit = false;
		if (gameStarted)
		{
			for (Iterator<Bird> i = field.getBirds(); i.hasNext();) {
			    Bird bird = i.next();
				int height = 0;
				if (bird instanceof FlyingBird)
					height = ((FlyingBird)bird).getHeight();
				Location location = bird.getLocation();
				hit =  location.equals(new Location(x,y)) && height == h;
				if (hit)
				{
					bird.sing();
					break;
				}
			}
		}
         return hit;   
	}

}
