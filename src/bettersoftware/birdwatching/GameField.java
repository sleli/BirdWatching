package bettersoftware.birdwatching;



public class GameField {
	
	public enum PlacingMode {
	    Custom, Random 
	}
	
	BirdList birds;
	boolean gameStarted;
	private FieldSize fieldSize;
	private PlacingStrategyFactory placingStrategyFactory;
	

	public GameField(FieldSize fieldSize) {
		this(fieldSize, new PlacingStrategyFactory());
	}
	
	public GameField(FieldSize fieldSize, PlacingStrategyFactory placingStrategyFactory) {
		this.placingStrategyFactory = placingStrategyFactory;
		this.fieldSize = fieldSize;
		this.birds = new BirdList();
	}
	
	public void addBird(Bird b) {
		birds.add(b);
	}
	
	
	//Start the game
	public boolean startGame(PlacingMode pm) {
		placingStrategyFactory.create(pm, fieldSize).place(birds);
		gameStarted = isGameStarted();
		return gameStarted;
	}

	private boolean isGameStarted() {
		return birds.areAllBirdsPlacedWithinField(fieldSize);
	}
	
	public boolean shot(Location shotLocation) {
		return birds.anyBirdWasHit(shotLocation) && gameStarted;   
	}
	

}
