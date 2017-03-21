package bettersoftware.birdwatching.test;

import org.junit.* ; 

import bettersoftware.birdwatching.*;
import bettersoftware.birdwatching.placing.*;

import static org.junit.Assert.* ; 

public class BirdWatchingTest  {
	
	@Test
    public void randomPlacingShouldStartGame()
    {                  
        GameField field = new GameField(10,5,3);
        field.addBird(new Chicken());
		field.addBird(new Duck());
		
		BirdWatchingGame game = new BirdWatchingGame(field);
		assertTrue(game.startGame(new RandomPlacingStrategy()));
    }
	
	@Test
    public void customPlacingShouldStartGameWithValidBirdsPlacing() throws Exception
    {                  
        GameField field = new GameField(10,5,3);
        
        Chicken chicken = new Chicken();
        chicken.setLocation(new Location(0,0));
        
        Duck duck = new Duck();
        duck.setLocation(new Location(10,5));
        duck.setHeight(3);
        
        field.addBird(chicken);
		field.addBird(duck);
		
		BirdWatchingGame game = new BirdWatchingGame(field);
		assertTrue(game.startGame(new CustomPlacingStrategy()));
    }
	
	@Test
    public void customPlacingShouldNotStartGameWithInvalidBirdsPlacing() throws Exception
    {                  
        GameField field = new GameField(10,5,3);
        
        Chicken chicken = new Chicken();
        chicken.setLocation(new Location(11,0));
        
        Duck duck = new Duck();
        duck.setLocation(new Location(10,5));
        duck.setHeight(4);
        
        field.addBird(chicken);
		field.addBird(duck);
		
		BirdWatchingGame game = new BirdWatchingGame(field);
		assertFalse(game.startGame(new CustomPlacingStrategy()));
    }
	
	@Test
    public void rightShotShouldFailIfGameIsNotStarted() throws Exception
    {                  
        GameField field = new GameField(10,5,3);
        
        Duck duck = new Duck();
        duck.setLocation(new Location(10,5));
        duck.setHeight(3);
        
		field.addBird(duck);
		
		BirdWatchingGame game = new BirdWatchingGame(field);
		assertFalse(game.shot(10, 5, 3));
    }
	
	
	@Test
    public void rightShotShouldHitABird() throws Exception
    {                  
        GameField field = new GameField(10,5,3);
        
        Duck duck = new Duck();
        duck.setLocation(new Location(10,5));
        duck.setHeight(3);
        
		field.addBird(duck);
		
		BirdWatchingGame game = new BirdWatchingGame(field);
		game.startGame(new CustomPlacingStrategy());
		assertTrue(game.shot(10, 5, 3));
    }
	
	@Test
    public void wrongShotShouldMissABird() throws Exception
    {                  
        GameField field = new GameField(10,5,3);
        
        Duck duck = new Duck();
        duck.setLocation(new Location(10,5));
        duck.setHeight(3);
        
		field.addBird(duck);
	
		BirdWatchingGame game = new BirdWatchingGame(field);
		game.startGame(new CustomPlacingStrategy());
		assertFalse(game.shot(9, 5, 3));
    }
	
}
