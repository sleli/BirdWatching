package bettersoftware.birdwatching;

import java.util.ArrayList;

public class BirdList extends ArrayList<Bird> {
	private static final long serialVersionUID = -3323859086260693300L;
	
	public boolean areAllBirdsPlacedWithinField(FieldSize fieldSize) {
		boolean isValid = true;
		for(Bird bird : this) {
			isValid = isValid && fieldSize.isWithinField(bird.getLocation());
		}
		return size() > 0 && isValid;

	}

	public boolean anyBirdWasHit(Location shotLocation) {
		boolean hit=false;
		for(Bird bird : this) {
			hit = hit || bird.wasHit(shotLocation);
		}
		return hit;
	}
}
