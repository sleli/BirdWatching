package iad.birdwatching;

public class PlacingStrategyFactory {

	public IPlacingStrategy create(PlacingMode type, GridSize gridSize) {
		if (type == PlacingMode.Random) {
			return new RandomPlacingStrategy(gridSize);
		} 
		return new NullPlacingStrategy();
	}

}
