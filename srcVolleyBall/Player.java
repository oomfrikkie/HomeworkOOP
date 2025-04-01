public class Player
{
    private String name;
    private int jerseyNumber;

    public Player( String name, int jerseyNumber )
    {
        this.name = name;
        this.jerseyNumber = jerseyNumber;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getJerseyNumber()
    {
        return this.jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber)
    {
        if( jerseyNumber > 0 )
        {
            this.jerseyNumber = jerseyNumber;
        }

        throw new IllegalArgumentException("Jersy number cannot be below 0");
    }



}
