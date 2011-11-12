package bettersoftware.birdwatching;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BirdsArmy implements Iterable<Bird> {
    private List<Bird> birds = new ArrayList<Bird>();

	public boolean areAllBirdsPlacedWithinField(GridSize gridSize) {
		boolean isValid = true;
		for(Bird bird : this) {
			isValid = isValid && gridSize.isWithinGrid(bird.getLocation());
		}

		return birds.size() > 0 && isValid;

	}

	public boolean anyBirdWasHit(Location shotLocation) {
		boolean hit=false;
		for(Bird bird : this) {
			hit = hit || bird.wasHit(shotLocation);
		}

		return hit;
	}

    public Iterator<Bird> iterator() {
        return birds.iterator();
    }

    public void add(Bird bird) {
        birds.add(bird);
    }
}
