package bettersoftware.birdwatching;

import java.util.List;
import java.util.Random;

public class RandomPlacingStrategy implements IPlacingStrategy {

	private FieldSize fieldSize;

	public RandomPlacingStrategy(FieldSize fieldSize) {
		this.fieldSize = fieldSize;
	}

	@Override
	public void place(List<Bird> birds) {
		for(Bird bird : birds) {
			Location location = new Location(new Random().nextInt(fieldSize.width()), 
												new Random().nextInt(fieldSize.height()),
												new Random().nextInt(fieldSize.depth()));
			bird.setLocation(location);
		}
	}

}
