package golf; // contains the classes for a mini-golf course

/**
 * @author Adam Kenny
 * @author Dang Yang
 * @author Lloyd Pintac
 *
 * Round class that holds a player's information for a round of mini-golf
 */
public class Round {
	// create fields for the Round class
	String playerName;
	String courseName;
	int startTime; // using 24 hour clock, ex: HHMM such as 1530
	
	// property getters
	public String getPlayerName () {
		return playerName;
	}
	
	public String getCourseName () {
		return courseName;
	}
	
	public int getStartTime () {
		return startTime;
	}
	
	/**
	 * No-arg constructor
	 */
	public Round () {
		playerName = "John Doe";
		courseName = "PuttLand";
		startTime = 1800;
	}
	
	// --------------------------------------
	// some sample methods from Round class
	// just return dummy values for testing
	// actual methods will contain real logic
	// --------------------------------------
	
	// returns number of strokes below, at, or above par
	public int currentScore() {
		return 1;
	}
	
	// returns number of completed holes played in round
	public int numberOfHolesPlayed () {
		return 9;
	}
	
	// accepts the number of strokes used for current hole
	public void enterScore (int strokes) throws IllegalArgumentException {
		if (strokes <= 0)
			throw new IllegalArgumentException();
	}
	
	// returns an array of strokes for every hole
	public int[] scoreDetail () {
		return new int[] {1, 2, 2, 4, 3, 3, 1, 3, 5};
	}
}