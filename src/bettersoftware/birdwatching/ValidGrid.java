package bettersoftware.birdwatching;

public class ValidGrid implements Grid {
    private BirdsArmy birds;

    public ValidGrid(BirdsArmy birds) {
        this.birds = birds;
    }

    public boolean shot(Location shotLocation) {
		return birds.anyBirdWasHit(shotLocation);
	}

    public boolean isValid() {
        return true;
    }
}
