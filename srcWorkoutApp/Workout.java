import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Workout
{
    private String title;
    private int difficultyLevel;
    private List<Activity> activities;

    public Workout( String title, int difficultyLevel )
    {
        this.title = title;
        this.difficultyLevel = difficultyLevel;
        this.activities = new ArrayList<>();
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getDifficultyLevel()
    {
        return this.difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel)
    {
        this.difficultyLevel = difficultyLevel;
    }

    public List<Activity> getActivities()
    {
        return this.activities;
    }

    public void setActivities(List<Activity> activities)
    {
        if(activities == null)
        {
            this.activities = new ArrayList<>();
        }
        this.activities = activities;
    }

    public int getTotalBreakTime()
    {

        if(this.activities.isEmpty())
        {
            return 0;
        }

        int lastEndTime = 0;
        int totalBreakTime = 0;

        for(Activity a : this.activities)
        {
            if(a.getStartTimeInSeconds() > lastEndTime)
            {
                totalBreakTime += a.getStartTimeInSeconds() - lastEndTime;
            }

            lastEndTime = a.getStartTimeInSeconds() + a.getLengthInSeconds();
        }

        return totalBreakTime;
    }

    public int getTotalWorkoutTime()
    {

        if(this.activities.isEmpty())
        {
            return 0;
        }
        int totalWorkoutTime = 0;

        for (Activity a : this.activities)
        {
            totalWorkoutTime += a.getLengthInSeconds();
        }

        return totalWorkoutTime + this.getTotalBreakTime();
    }

    public int getTotalWorkoutTimeInMinutes()
    {
        return this.getTotalWorkoutTime() / 60;
    }

    public void addActivity(Activity activity)
    {
        if(activity == null)
        {
            throw new IllegalArgumentException("Cannot add an empty activity");
        }

        if(activity.getStartTimeInSeconds() > this.getTotalWorkoutTime())
        {
            this.activities.add( activity );
        }
        else
        {
            throw new IllegalArgumentException("Activity cannot be added during another acitivty");
        }
    }

    public void removeActivity( Activity activity )
    {
        Iterator<Activity> iterator = this.activities.iterator();

        while( iterator.hasNext() )
        {
            Activity currentActivity = iterator.next();
            if( currentActivity == activity )
            {
                iterator.remove();
            }
        }
    }

    public String getDescription()
    {
        StringBuilder description = new StringBuilder();

        description.append(this.getTitle()).append("\n");

        int activityNumber = 1;
        for (Activity a : this.activities )
        {
            description.append(activityNumber).append(") ").append( a.getName()).append(" (").append( a.getLengthInSeconds()).append(" seconds)\n");
            activityNumber++;
        }

        return description.toString();
    }



}
