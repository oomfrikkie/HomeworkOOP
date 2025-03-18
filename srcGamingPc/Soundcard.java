public class Soundcard
{
    private double supportedChannel;
    private int slotSpace;

    public Soundcard( double supportedChannel )
    {
        this.supportedChannel = supportedChannel;
        this.slotSpace = 1;
    }

    public int getSlotSpace()
    {
        return this.slotSpace;
    }

    public void setSlotSpace(int slotSpace)
    {
        this.slotSpace = slotSpace;
    }

    public double getSupportedChannel()
    {
        return this.supportedChannel;
    }

    public void setSupportedChannel(double supportedChannel)
    {
        this.supportedChannel = supportedChannel;
    }




}
