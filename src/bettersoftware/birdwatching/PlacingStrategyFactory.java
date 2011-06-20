package bettersoftware.birdwatching;

import bettersoftware.birdwatching.GameField.PlacingMode;

public class PlacingStrategyFactory {

	public IPlacingStrategy create(PlacingMode type, FieldSize fieldSize) {
		if (type == PlacingMode.Random) {
			return new RandomPlacingStrategy(fieldSize);
		} 
		return new NullPlacingStrategy();
	}

}
