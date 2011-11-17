package iad.birdwatching;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BirdsArmy implements Iterable<Bird> {
    private List<Bird> birds = new ArrayList<Bird>();

	public boolean areAllBirdsPlacedWithinField(final GridSize gridSize) {
        return birds.size() > 0 && Iterables.all(birds,new Predicate<Bird>() {
            public boolean apply(Bird bird) {
                return gridSize.isWithinGrid(bird.getLocation());
            }
        });

	}

	public boolean anyBirdWasHit(final Location shotLocation) {
        return Iterables.any(birds,new Predicate<Bird>() {
            public boolean apply(Bird bird) {
                return bird.wasHit(shotLocation);
            }
        });
	}

    public Iterator<Bird> iterator() {
        return birds.iterator();
    }

    public void add(Bird bird) {
        birds.add(bird);
    }
}
