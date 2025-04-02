import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutTest
{
    private Workout testWorkout;
    private List<Activity> testActivites;
    private Activity a1;
    private Activity a2;
    private Activity a3;

    @BeforeEach
    void setUp()
    {
        this.a1 = new Activity("Activity 1", 0, 10);
        this.a2 = new Activity("Activity 2", 15, 10);
        this.a3 = new Activity("Activity 3", 35, 10);


        this.testActivites = new ArrayList<>(List.of(a1,a2, a3));

        this.testWorkout = new Workout("Workout Test", 3);
        this.testWorkout.setActivities( this.testActivites );
    }

    @Test
    void getTotalBreakTime_with3Workouts_shouldReturn15()
    {

        int totalBreakTime = this.testWorkout.getTotalBreakTime();

        assertEquals(15, totalBreakTime);
    }

    @Test
    void addActivity_activityStartTimeNotBetween_shouldAdd()//not sure what to name this
    {
      int result = this.testWorkout.getActivities().size() + 1;

      this.testWorkout.addActivity( new Activity( "Test Activity" , 55, 10));

      assertEquals(result, this.testWorkout.getActivities().size()); // can also do assertNotThrows?
    }

    @Test
    void addActivity_activityStartTimeIsBetween_returnException()//not sure what to name this
    {
        assertThrows(IllegalArgumentException.class, () ->  this.testWorkout.addActivity( new Activity( "Test Activity" , 45, 10) ));
    }

    @Test
    void addActivity_activityIsNull_returnException()
    {
        assertThrows(IllegalArgumentException.class, () ->  this.testWorkout.addActivity( null ));
    }


}