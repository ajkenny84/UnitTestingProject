package unit_testing; // contains unit tests for a mini-golf course

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runner.JUnitCore;
import java.lang.IllegalArgumentException;
import golf.Round;

/**
 * @author Adam Kenny
 * @author Dang Yang
 * @author Lloyd Pintac
 * 
 * Test suite for Round class
 */
public class RoundTestSuite {
	Round round; // create an object reference to use later
	
	public static void main(String[] args) {
		JUnitCore.main("RoundTestSuite"); // run the test suite
	}
	
	// create a new round object for testing
	@Before
	public void init () {
		round = new Round();
	}
	
	// ------------------------------------------
	// these first 5 test methods should all pass
	// tried to test multiple different scenarios
	// ------------------------------------------
	
	@Test
	public void testPass_Round() {
		// make sure we have a non-null object to work with
		assertNotNull("Expected a Round object", round);
	}
	@Test
	public void testPass_currentScore () {
		// set up expected values
		final int strokesTaken = 1;
		// get return value from method
		int returnedStrokes = round.currentScore();
		
		// make sure currentScore is returning expected values
		assertEquals("Expected > 0", strokesTaken, returnedStrokes);
	}
	
	@Test
	public void testPass_numberOfHolesPlayed () {
		// assume this is a 9 hole course
		final int badData = 18;
		// get return value to make sure we are not off track
		int returnedEndOfRound = round.numberOfHolesPlayed();
		
		// verify we are only dealing with a 9 hole course, not 18
		assertFalse("Expected 9, result was too high or too low", badData == returnedEndOfRound);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPass_enterScore () {
		// set up invalid data so we can make sure exceptions are working
		int invalidScoreNegative = -1;
		int invalidScoreZero = 0;
		
		// score cannot be <= 0, exceptions are expected to be thrown
		round.enterScore(invalidScoreNegative);
		round.enterScore(invalidScoreZero);
	}
	
	@Test
	public void testPass_scoreDetail () {
		// this round represents actual scores entered
		final int[] playedRound = new int[] {1, 2, 2, 4, 3, 3, 1, 3, 5};
		// this round represents round that would be returned from a database
		int[] retrievedRound = round.scoreDetail();
		
		// make sure the correct score card is returned from the system
		assertArrayEquals("Round contains bad data", playedRound, retrievedRound);
	}
	
	// ------------------------------------------------
	// these final 4 tests should fail in separate ways
	// attempted to create different fail conditions
	// ------------------------------------------------
	
	@Test
	public void testFail_currentScore () {
		// sample score for a hole
		final int actualScore = 3;
		// system thinks we got a hole in one
		int returnedScore = round.currentScore();
		// expected a match, but returned value was wrong
		assertFalse("Expected matching scores", returnedScore != actualScore);
	}
	
	@Test
	public void testFail_numberOfHolesPlayed () {
		// we haven't started yet
		final int noHolesPlayed = 0;
		// system is telling us that we have already played for some reason
		int yesHolesPlayed = round.numberOfHolesPlayed();
		// user hasn't played a hole yet, test should fail
		assertEquals("Expected no holes to be played yet", noHolesPlayed, yesHolesPlayed);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFail_enterScore () {
		// this example doesn't make much sense, just testing the fail condition
		final int validScore = 1;
		// anticipated an exception for whatever reason, never got one
		round.enterScore(validScore);
	}
	
	@Test
	public void testFail_scoreDetail () {
		// create a round with expected values
		final int[] playerRound = new int[] {1, 2, 2, 5, 3, 2, 1, 4, 4};
		// get a different round from the method
		int[] returnedRound = round.scoreDetail();
		// test will fail because returned rounds do not match
		// system must have returned a different player card from the database
		assertArrayEquals("Round contains bad data", playerRound, returnedRound);
	}
}