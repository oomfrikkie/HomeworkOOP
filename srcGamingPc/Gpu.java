public class Gpu
{
    private int maxGhz;
    private int maxVram;



    private int slotSpace;

    public Gpu( int maxGhz, int maxVram)
    {
        this.maxGhz = maxGhz;
        this.maxVram = maxVram;
        this.slotSpace = 3;
    }

    public int getMaxGhz()
    {
        return this.maxGhz;
    }

    public void setMaxGhz( int maxGhz )
    {
        this.maxGhz = maxGhz;
    }

    public int getMaxVram()
    {
        return this.maxVram;
    }

    public void setMaxVram( int maxVram )
    {
        this.maxVram = maxVram;
    }

    public int getSlotSpace()
    {
        return this.slotSpace;
    }

    public void setSlotSpace(int slotSpace)
    {
        this.slotSpace = slotSpace;
    }

}
