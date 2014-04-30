package golf;

/**
 * @author Adam Kenny
 * @author Dang Yang
 * @author Lloyd Pintac
 *
 * Course class that holds information for mini-golf course
 */
public class Course {
    final String courseName;
    final Integer courseHole;
    int[] parHole;
    
    //Construct a course with specified name, hole, and par
    public Course(String name, int holeCourse, int[] par){
        courseName = name;
        courseHole = holeCourse;
        parHole = new int[courseHole];
        //Copy the array par to parHole for independent location
        System.arraycopy(par, 0, parHole, 0, par.length);
    }
    
    //return name of course
    public String getName () {
        return courseName;
    }
    
    //return the max of hole of course
    public int getNumberOfHoles(){
        return courseHole;
    }
    
    //return par base on played hole
    public int parForHole(int hole) throws ArrayIndexOutOfBoundsException{
        if(hole <= parHole.length && hole != 0){
            return parHole[hole-1];
        }
        else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
