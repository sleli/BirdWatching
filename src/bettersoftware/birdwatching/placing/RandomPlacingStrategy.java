package bettersoftware.birdwatching.placing;

import java.util.List;
import java.util.Random;

import bettersoftware.birdwatching.Bird;
import bettersoftware.birdwatching.FlyingBird;
import bettersoftware.birdwatching.Location;

public class RandomPlacingStrategy implements IPlacingStrategy {

	public void place(List<Bird> birds, int length, int width, int height) {
		for (Bird bird : birds) {
			Location gp = new Location(new Random().nextInt(length), new Random().nextInt(width));
			int h = new Random().nextInt(height);
			bird.setLocation(gp);
			if (bird instanceof FlyingBird)
				((FlyingBird) bird).setHeight(h);
		}

	}
}
