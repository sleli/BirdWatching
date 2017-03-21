package bettersoftware.birdwatching.test;

import org.junit.* ; 

import bettersoftware.birdwatching.*;

import static org.junit.Assert.* ; 

public class BirdWatchingTest  {
	
	
	private GameField field;
	
	@Before
	public void Setup() {
        field = new GameField(new FieldSize(10,5,3));
	}

	@Test
    public void randomPlacingShouldStartGame()
    {                  
        field.addBird(new Chicken());
		field.addBird(new Duck());
		assertTrue(field.startGame(GameField.PlacingMode.Random));
    }
	
	@Test
    public void customPlacingShouldStartGameWithValidBirdsPlacing() throws Exception
    {                  
        Bird chicken = new Chicken();
        chicken.setLocation(new Location(0,0));
        
        Bird duck = new Duck();
        duck.setLocation(new Location(10,5,3));
        
        field.addBird(chicken);
		field.addBird(duck);
		assertTrue(field.startGame(GameField.PlacingMode.Custom));
    }
	
	@Test
    public void customPlacingShouldNotStartGameWithInvalidBirdsPlacing() throws Exception
    {                  
        Bird chicken = new Chicken();
        chicken.setLocation(new Location(11,0));
        
        Bird duck = new Duck();
        duck.setLocation(new Location(10,5,4));
        
        field.addBird(chicken);
		field.addBird(duck);
		assertFalse(field.startGame(GameField.PlacingMode.Custom));
    }
	
	@Test
    public void rightShotShouldFailIfGameIsNotStarted() throws Exception
    {                  
        Bird duck = new Duck();
        duck.setLocation(new Location(10,5,3));
        
		field.addBird(duck);
		assertFalse(field.shot(new Location(10, 5, 3)));
    }
	
	
	@Test
    public void rightShotShouldHitABird() throws Exception
    {                  
        Bird duck = new Duck();
        duck.setLocation(new Location(10,5,3));
        
		field.addBird(duck);
		field.startGame(GameField.PlacingMode.Custom);
		assertTrue(field.shot(new Location(10, 5, 3)));
    }
	
	@Test
    public void wrongShotShouldMissABird() throws Exception
    {                  
        Bird duck = new Duck();
        duck.setLocation(new Location(10,5,3));
        
		field.addBird(duck);
		field.startGame(GameField.PlacingMode.Custom);
		assertFalse(field.shot(new Location(9, 5, 3)));
    }
	
}
