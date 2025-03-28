import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ssd
{
    private int maxCapicity;
    private int availableCapactity;
    private int slotSpace;
    private List<Game> installedGames;

    public Ssd( int maxCapicity )
    {
        this.maxCapicity = maxCapicity;
        this.availableCapactity = maxCapicity;
        setSlotSpace();
        this.installedGames = new ArrayList<>();

    }

    public int getMaxCapicity()
    {
        return this.maxCapicity;
    }

    public void setMaxCapicity( int maxCapicity )
    {
        this.maxCapicity = maxCapicity;
    }

    public int getSlotSpace()
    {
        return this.slotSpace;
    }

    public void setSlotSpace()
    {
        if(this.maxCapicity > 2.048)
        {
            this.slotSpace = 2;
        }
        else
        {
            this.slotSpace = 1;
        }
    }

    public int getAvailableCapactity()
    {
        return this.availableCapactity;
    }

    public void setAvailableCapactity( int availableCapactity )
    {
        this.availableCapactity = availableCapactity;
    }

    public List<Game> getInstalledGames()
    {
        return this.installedGames;
    }

    public void addInstalledGame( Game game )
    {
        if( game.getStorageRequired() < this.availableCapactity )
        {
            installedGames.add( game );
            this.availableCapactity -= game.getStorageRequired();
        }
        else
        {
            throw new RuntimeException("Not enough avilable storage");
        }
    }

    public void removeInstalledGame( Game game )
    {
        Iterator<Game> iterator = this.installedGames.iterator();

        while( iterator.hasNext() )
        {
           Game currentGame = iterator.next();

            if( currentGame.equals( game ) )
            {
                iterator.remove();
                this.availableCapactity += currentGame.getStorageRequired();
            }
        }
    }




}
