import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GamingPc
{
    private Motherboard motherboard;


    public GamingPc( Motherboard motherboard )
    {
        this.motherboard = motherboard;

    }

    public Motherboard getMotherboard()
    {
        return this.motherboard;
    }

    public void setMotherboard( Motherboard motherboard )
    {
        this.motherboard = motherboard;
    }

    public void installGame( Game game )
    {
        if( this.motherboard.getTotalVram() < game.getVramRequired())
        {
            throw new RuntimeException("Not enough VRAM to install " + game.getTitle());
        }

            for (Ssd ssd : this.motherboard.getSsds())
            {
                if (ssd.getAvailableCapactity() >= game.getStorageRequired())
                {
                    ssd.addInstalledGame(game);
                    return;
                }
            }


      throw new RuntimeException("Not enough space for " + game.getTitle());
    }

    public void uninstallGame( Game game)
    {
        for( Ssd ssd : this.motherboard.getSsds() )
        {
            if(ssd.getInstalledGames().contains( game ))
            {
                ssd.removeInstalledGame( game );
                return;
            }
        }

        throw new RuntimeException("Game not found");
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
