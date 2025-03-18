import java.util.ArrayList;
import java.util.List;

public class GamingPc
{
    private Motherboard motherboard;
    private List<Game> games;

    public GamingPc( Motherboard motherboard )
    {
        this.motherboard = motherboard;
        this.games = new ArrayList<>();
    }

    public Motherboard getMotherboard()
    {
        return this.motherboard;
    }

    public void setMotherboard( Motherboard motherboard )
    {
        this.motherboard = motherboard;
    }

    public List<Game> getGames()
    {
        return this.games;
    }

    public void setGames( List<Game> games )
    {
        this.games = games;
    }

    public void installGame( Game game)
    {
        if( game.getStorageRequired() < motherboard.getTotalAvailableSpace() )
        {
            this.games.add( game );
            motherboard.decreaseTotalAvailableSpace( game.getStorageRequired() );
        }
        else
        {
            throw new RuntimeException("Not enough Storage");
        }
    }


    public boolean hasEnoughSpace()
    {
        if(motherboard.getTotalAvailableSpace() > motherboard.getTotalSpace() * 0.01)
        {
            return true;
        }
        else
        {
            return false;
        }
    }




}
