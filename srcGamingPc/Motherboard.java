import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Motherboard
{
    private int maxSlots;
    private int availableSlots;
    private List<Gpu> graphicsCards;
    private List<Ssd> ssds;
    private List<Soundcard> soundcards;
    private int totalSpace;
    private int totalAvailableSpace;

    public Motherboard( int maxSlots )
    {
        this.maxSlots = maxSlots;
        this.availableSlots = maxSlots;
        this.graphicsCards = new ArrayList<>();
        this.ssds = new ArrayList<>();
        this.soundcards = new ArrayList<>();
        this.totalSpace = getTotalSpace();
        this.totalAvailableSpace = getTotalAvailableSpace();

    }
    
    public int getMaxSlots()
    {
        return this.maxSlots;
    }
    
    public void setMaxSlots( int maxSlots )
    {
        this.maxSlots = maxSlots;
    }
    
    public int getAvailableSlots()
    {
        return this.availableSlots;
    }
    
    public void setAvailableSlots ( int availableSlots )
    {
        this.availableSlots = availableSlots;
    }
    
    public List<Gpu> getGraphicsCards()
    {
        return this.graphicsCards;
    }
    
    public void setGraphicsCards( List<Gpu> graphicsCards )
    {
        this.graphicsCards = graphicsCards;
    }
    
    public void addGraphicsCard( Gpu graphicsCard )
    {
        if( this.availableSlots >= graphicsCard.getSlotSpace() )
        {
            this.graphicsCards.add( graphicsCard );
            this.availableSlots -= graphicsCard.getSlotSpace();
        }
        else
        {
            throw new RuntimeException("Not enough slots available to add graphics card");
        }
    }

    public void removeGraphicsCard( Gpu graphicsCard )
    {
        Iterator<Gpu> iterator = graphicsCards.iterator(); // Create an iterator
        while (iterator.hasNext())
        {
            Gpu currentCard = iterator.next();
            if (currentCard.equals(graphicsCard))
            {
                iterator.remove();
                this.availableSlots += graphicsCard.getSlotSpace();// Removes the current element from the list
                break;

            }
        }
    }

    public List<Ssd> getSsds()
    {
        return this.ssds;
    }

    public void setSsds( List<Ssd> ssds )
    {
        this.ssds = ssds;
    }

    public void addSsd( Ssd ssd )
    {
        if( this.availableSlots >= ssd.getSlotSpace())
        {
            this.ssds.add( ssd );
            this.availableSlots -= ssd.getSlotSpace();
        }
        else
        {
            throw new RuntimeException("Not enough slots to install ssd");
        }
    }

    public void removeSsd( Ssd ssd )
    {
        Iterator<Ssd> iterator = ssds.iterator();
        while(iterator.hasNext())
        {
            Ssd currentSsd = iterator.next();
            if(currentSsd.equals( ssd ))
            {
                iterator.remove();
                this.availableSlots += ssd.getSlotSpace();
                totalAvailableSpace -= ssd.getMaxCapicity();
                break;
            }
        }
    }

    public List<Soundcard> getSoundcards()
    {
        return this.soundcards;
    }

    public void setSoundcards( List<Soundcard> soundcards)
    {
        this.soundcards = soundcards;
    }

    public void addSoundcard( Soundcard soundcard )
    {
       if(this.availableSlots >= soundcard.getSlotSpace())
       {
           this.soundcards.add( soundcard );
       }
       else
       {
           throw new RuntimeException("Not enough slots to install soundCard");
       }
    }

    public void removeSoundcard( Soundcard soundcard )
    {
        Iterator<Soundcard> iterator = soundcards.iterator();
        while(iterator.hasNext())
        {
            Soundcard currentSoundCard = iterator.next();

            if(currentSoundCard.equals( soundcard ))
            {
                iterator.remove();
            }
        }
    }

    public int getTotalSpace()
    {
        int totalSpace = 0;
        for( Ssd ssd : this.ssds )
        {
            totalSpace+= ssd.getMaxCapicity();
        }

        return totalSpace;
    }

    public int getTotalAvailableSpace()
    {
        int totalAvailableSpace = 0;

        for( Ssd ssd : this.ssds )
        {
            totalAvailableSpace += ssd.getAvailableCapactity();
        }

        return totalAvailableSpace;
    }

    public int getTotalVram()
    {
        int totalVram = 0;

        for( Gpu gpu : this.graphicsCards )
        {
            totalVram += gpu.getMaxVram();
        }

        return totalVram;
    }

    
    
}
