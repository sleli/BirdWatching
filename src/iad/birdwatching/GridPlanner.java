package iad.birdwatching;

public class GridPlanner {
    private BirdsArmy birds = new BirdsArmy();
	private GridSize gridSize;
	private PlacingStrategyFactory placingStrategyFactory;

	public GridPlanner(GridSize gridSize) {
		this(gridSize, new PlacingStrategyFactory());
	}
	
	public GridPlanner(GridSize gridSize, PlacingStrategyFactory placingStrategyFactory) {
		this.placingStrategyFactory = placingStrategyFactory;
		this.gridSize = gridSize;
	}
	
	public void addBird(Bird b) {
		birds.add(b);
	}

	public Grid startGame(PlacingMode pm) {
		placingStrategyFactory.create(pm, gridSize).place(birds);
		return isGameStarted()? new ValidGrid(birds): new InvalidGrid();
	}

	private boolean isGameStarted() {
		return birds.areAllBirdsPlacedWithinField(gridSize);
	}

}
