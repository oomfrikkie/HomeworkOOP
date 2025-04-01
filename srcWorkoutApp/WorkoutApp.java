import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WorkoutApp
{
    private List<Workout> workoutList;

    public WorkoutApp()
    {
        this.workoutList = new ArrayList<>();
    }
    public List<Workout> getWorkoutList()
    {
        return this.workoutList;
    }

    public void setWorkoutList(List<Workout> workoutList)
    {
        if(workoutList != null)
        {
            this.workoutList = workoutList;
        }

        this.workoutList = new ArrayList<>();
    }

    public List<Workout> getWorkoutsLongerThan10Minutes()
    {
        List<Workout> workoutsLongerThan10Minutes = new ArrayList<>();

        for ( Workout w : this.workoutList)
        {
            if( w.getTotalWorkoutTimeInMinutes() > 10)
            {
                workoutsLongerThan10Minutes.add( w );
            }
        }

        return workoutsLongerThan10Minutes;
    }

    public void removeWorkoutsLongerThan10Minutes()
    {
        Iterator<Workout> iterator = this.workoutList.iterator();

        while( iterator.hasNext() )
        {
            Workout currentWorkout = iterator.next();

            //if(this.getWorkoutsLongerThan10Minutes().contains( currentWorkout ))
            if( currentWorkout.getTotalWorkoutTimeInMinutes() > 10 )
            {
                iterator.remove();
            }
        }
    }



}
