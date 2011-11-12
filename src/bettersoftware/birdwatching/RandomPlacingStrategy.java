package bettersoftware.birdwatching;

import java.util.List;
import java.util.Random;

public class RandomPlacingStrategy implements IPlacingStrategy {

	private GridSize gridSize;

	public RandomPlacingStrategy(GridSize gridSize) {
		this.gridSize = gridSize;
	}

	public void place(Iterable<Bird> birds) {
		for(Bird bird : birds) {
			Location location = new Location(new Random().nextInt(gridSize.width()),
											 new Random().nextInt(gridSize.height()),
											 new Random().nextInt(gridSize.depth()));
			bird.setLocation(location);
		}
	}

}
