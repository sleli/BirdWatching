package iad.birdwatching;

public class BirdWatchingPlanner {
    private BirdsArmy birds = new BirdsArmy();
	private GridSize gridSize;
	private PlacingStrategyFactory placingStrategyFactory;

	public BirdWatchingPlanner(GridSize gridSize) {
		this(gridSize, new PlacingStrategyFactory());
	}
	
	public BirdWatchingPlanner(GridSize gridSize, PlacingStrategyFactory placingStrategyFactory) {
		this.placingStrategyFactory = placingStrategyFactory;
		this.gridSize = gridSize;
	}
	
	public void addBird(Bird b) {
		birds.add(b);
	}

	public Grid placeOnGrid(PlacingMode pm) {
        IPlacingStrategy placingStrategy = placingStrategyFactory.create(pm, gridSize);
        placingStrategy.place(birds);

		return isPlacementValid()? new ValidGrid(birds): new InvalidGrid();
	}

	private boolean isPlacementValid() {
		return birds.areAllBirdsPlacedWithinField(gridSize);
	}

}
