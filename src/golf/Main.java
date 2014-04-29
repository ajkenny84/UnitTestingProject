package golf; // contains the classes for a mini-golf course

/**
 * @author Adam Kenny
 * @author Dang Yang
 * @author Lloyd Pintac
 *
 * Round class that holds a player's information for a round of mini-golf
 */


public class Main {
	static Round newRound ( String courseName, String playerName ) {
		Round round = new Round(courseName, playerName);
		return round;
		
	}
	public static Course newCourse(String courseName) {
		Course course = new Course(courseName);
		return course;
		
	}
	public static int currentScore() {
		
		return 0;
	}
	
	static Round getRound (String player, String courseName ) {
		Round returnRound = null;
		List<Round> rounds = new ArrayList<Round>();
		Round round1 = new Round("John Doe", "PuttLand");
		rounds.add(round1);
		
		Round round2 = new Round("Michael James", "TeeLand");
		rounds.add(round2);
		
		for (Round o : rounds)
		{
			if (o.CourseName == courseName && o.PlayerName == player)
			{
				returnRound = o;
				break;
			}
		}
		
		return returnRound;
		
	}
	
	static Course getCourse ( String courseName ) {
		Course returnCourse = null;
		List<Course> courses = new ArrayList<Course>();
		Course course1 = new Course("TeeLand");
		courses.add(course1);
		
		Course course2 = new Course("PuttLand");
		courses.add(course2);
		
		for (Course c : courses)
		{
			if (c.CourseName == courseName)
			{
				returnCourse = c;
				break;
			}
		}
		
		return returnCourse;
		
	}
	static int scoreSoFar( String courseName, String playerName ) {
		return 9;
		
	}
	static void enterStrokes ( String courseName, String playerName, int strokes ) throws IllegalArgumentException {
		if (strokes <= 0)
			throw new IllegalArgumentException();
	}
	

	
}
