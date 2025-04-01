public class Activity
{

    private String name;
    private int startTimeInSeconds;
    private int lengthInSeconds;

    public Activity(String name, int startTimeInSeconds, int lengthInSeconds)
    {
        this.name = name;
        this.startTimeInSeconds = startTimeInSeconds;
        this.lengthInSeconds = lengthInSeconds;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getStartTimeInSeconds()
    {
        return this.startTimeInSeconds;
    }

    public void setStartTimeInSeconds(int startTimeInSeconds)
    {
        this.startTimeInSeconds = startTimeInSeconds;
    }

    public int getLengthInSeconds()
    {
        return this.lengthInSeconds;
    }

    public void setLengthInSeconds(int lengthInSeconds)
    {
        this.lengthInSeconds = lengthInSeconds;
    }



}


