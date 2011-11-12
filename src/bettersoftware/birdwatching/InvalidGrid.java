package bettersoftware.birdwatching;

public class InvalidGrid implements Grid {

    public boolean isValid() {
        return false;
    }

    public boolean shot(Location shotLocation) {
		return isValid();
	}
}
