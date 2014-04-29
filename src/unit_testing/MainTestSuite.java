/**
 * Package used to test Mini-Golf Course
 */
package unit_testing;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runner.JUnitCore;

/**
 * @author Adam Kenny
 * @author Dang Yang
 * @author Lloyd Pintac
 * 
 * Test suite for Main class
 *
 */
public class MainTestSuite {

	/**
	 * @param args
	 */
	Main main;
	public static void main(String[] args) {
		JUnitCore.main("MainTest"); // run the test suite
	}

	// create a new round object for testing
	@Before
	public void init () {
		
	}
	
	@Test
	public void testPass_newRound () {
		// Get round for player John Doe in PuttLand course
		final String playerName = "John Doe";
		final String courseName = "PuttLand";
		// get return object
		Round returnedRound = Main.newRound(courseName, playerName);
		
		// verify we are getting round object for John Doe in PuttLand course
		assertEquals("Expected object for John Doe and PuttLand", returnedRound.PlayerName == playerName && returnedRound.CourseName == courseName);
	}
	
	@Test
	public void testPass_getRound () {
		// Get round for player John Doe in PuttLand course
		final String playerName = "Michael James";
		final String courseName = "TeeLand";
		// get return object
		Round returnedRound = Main.getRound(courseName, playerName);
		
		// verify we are getting round object from collection for Michael James in TeeLand course
		assertEquals("Expected object for John Doe and PuttLand", returnedRound.PlayerName == playerName && returnedRound.CourseName == courseName);
	}
	
	@Test
	public void testPass_GetCourse () {
		// Get course for TeeLand course
		final String courseName = "TeeLand";
		//get return object
		Course returnedCourse = Main.newCourse(courseName);
		// verify we are getting round object from collection for TeeLand course
		assertEquals("Expected object for Teeland course", returnedCourse.CourseName == courseName);
	}
	@Test
	public void testPass_scoreSoFar () {
		final int score = 9;
		// get return value from method
		int returnedStrokes = Main.currentScore();
		// make sure currentScore is returning expected values
		assertEquals("Expected = 9", score==returnedStrokes );
	}
	
	@Test
	public void testFail_newRound () {
		// Get round for player John Doe in PuttLand course
		final String playerName = "John Doe";
		final String courseName = "PuttLand";
		// get return object
		Round returnedRound = Main.newRound(courseName, playerName);
		
		// verify we are really getting round object for John Doe in PuttLand course
		assertFalse("Expected object for John Doe and PuttLand", returnedRound.PlayerName == playerName && returnedRound.CourseName == courseName);		
	}

	
	
	@Test
	public void testFail_getRound () {
		// Get round for player John Doe in PuttLand course
		final String playerName = "Michael James";
		final String courseName = "TeeLand";
		// get return object
		Round returnedRound = Main.newRound(courseName, playerName);
		// verify we are getting round object from collection for Michael James in TeeLand course
		assertFalse("Expected object for John Doe and PuttLand", returnedRound.PlayerName == playerName && returnedRound.CourseName == courseName);		
	}
	
	
	@Test
	public void testFail_GetCourse () {
		// Get course for TeeLand course
		final String courseName = "TeeLand";
		//get return object
		Course returnedCourse = Main.newCourse(courseName);
		// verify we are getting round object from collection for TeeLand course
		assertFalse("Expected object for Teeland course", returnedCourse.CourseName == courseName);
	}
	
	@Test
	public void testFail_scoreSoFar () {
		final int score = 9;
		// get return value from method
		int returnedStrokes = Main.currentScore();
		// make sure currentScore is returning expected values
		assertFalse("Expected =18", score==returnedStrokes );
	}
		
	@Test(expected = IllegalArgumentException.class)
		public void testFail_enterStrokes () {
		
		final String playerName = "Michael James";
		final String courseName = "TeeLand";
		final int validScore = 1;
	
		Main.enterStrokes(playerName, courseName,validScore);
	}
}
