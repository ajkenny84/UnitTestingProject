package golf;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;

/**
 * @author Adam Kenny
 * @author Dang Yang
 * @author Lloyd Pintac
 * 
 * Test suite for Course class
 *
 */
public class CourseTest {
    Course course1;
    Course course2;
    
    public static void main(String[] args) {
       JUnitCore.main("CourseTest"); // run the test suite
    }
    
    @Before
    public void setUp() {
        course1 = new Course("TeeLand", 9, new int[]{3, 4, 7, 5, 4, 8, 5, 6, 3});
        course2 = new Course("GolfLand", 10, new int[]{3, 4, 7, 5, 4, 8, 5, 6, 3, 9});
    }
        
    /**
     * Test of getName method, of class Course.
     */
    @Test
    public void testPass_GetName() {
        String expName = "TeeLand";
        String name = course1.getName();
        assertEquals(expName, name);
    }

    /**
     * Test of getNumberOfHoles method, of class Course.
     */
    @Test
    public void testPass_GetNumberOfHoles() {
        int expHole = 9;
        int hole = course1.getNumberOfHoles();
        assertEquals(expHole, hole);
    }

    /**
     * Test of parForHole method, of class Course.
     */
    @Test
    public void testPass_ParForHole() {
        int hole = 5;
        int expPar = 4;
        int par = course1.parForHole(hole);
        assertEquals(expPar, par);
    }
    
    //Test for exception of hole not included(element) of array
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testPass_ParForHoleException1() {
        int hole = 18;
        course2.parForHole(hole);
    }
    
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testPass_ParForHoleException2() {
        int hole = 0;
        course2.parForHole(hole);
    }
    
    //-------------------------------
    //Test class Course for failures
    //-------------------------------
    @Test
    public void testFail_GetName() {
        String expName = "Golf Land";
        String name = course2.getName();
        assertEquals(expName, name);
    }
    
    @Test
    public void testFail_GetNumberOfHoles() {
        int fullCourseHole = 18;
        int hole = course2.getNumberOfHoles();
        assertFalse("Expected ccourse hole should be 9", hole != fullCourseHole);
    }
    
    //Test for hole for par
    @Test
    public void testFail_ParForHole() {
        int hole = 3;
        int expPar = 5;
        int par = course2.parForHole(hole);
        assertFalse("Expected par should be 7 or hole should be 4 or 7", par != expPar);
    }
}
