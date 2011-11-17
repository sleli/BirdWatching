package iad.birdwatching.test;

import org.junit.* ; 

import iad.birdwatching.*;

import static org.junit.Assert.* ; 

public class BirdWatchingTest  {
	
	
	private BirdWatchingPlanner gridPlanner;
	
	@Before
	public void Setup() {
        gridPlanner = new BirdWatchingPlanner(new GridSize(10,5,3));
	}

	@Test
    public void randomPlacingShouldStartGame()
    {                  
        gridPlanner.addBird(new Chicken());
		gridPlanner.addBird(new Duck());
		assertTrue(gridPlanner.placeOnGrid(PlacingMode.Random).isValid());
    }
	
	@Test
    public void customPlacingShouldStartGameWithValidBirdsPlacing()
    {                  
        Bird chicken = new Chicken();
        chicken.setLocation(new Location(0,0));
        
        Bird duck = new Duck();
        duck.setLocation(new Location(10, 5, 3));
        
        gridPlanner.addBird(chicken);
		gridPlanner.addBird(duck);
		assertTrue(gridPlanner.placeOnGrid(PlacingMode.Custom).isValid());
    }
	
	@Test
    public void customPlacingShouldNotStartGameWithInvalidBirdsPlacing()
    {                  
        Bird chicken = new Chicken();
        chicken.setLocation(new Location(11,0));
        
        Bird duck = new Duck();
        duck.setLocation(new Location(10, 5, 4));
        
        gridPlanner.addBird(chicken);
		gridPlanner.addBird(duck);
		assertFalse(gridPlanner.placeOnGrid(PlacingMode.Custom).isValid());
    }
	
	@Test
    public void rightShotShouldHitABird()
    {                  
        Bird duck = new Duck();
        duck.setLocation(new Location(10, 5, 3));
        
		gridPlanner.addBird(duck);
		Grid grid = gridPlanner.placeOnGrid(PlacingMode.Custom);
		assertTrue(grid.shot(new Location(10, 5, 3)));
    }
	
	@Test
    public void wrongShotShouldMissABird()
    {                  
        Bird duck = new Duck();
        duck.setLocation(new Location(10, 5, 3));
        
		gridPlanner.addBird(duck);
        Grid grid = gridPlanner.placeOnGrid(PlacingMode.Custom);
		assertFalse(grid.shot(new Location(9, 5, 3)));
    }
	
}
