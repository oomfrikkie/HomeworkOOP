public class Game
{

    private String title;
    private int storageRequired;
    private int vramRequired;

    public Game(String title, int storageRequired, int vramRequired)
    {
        this.title = title;
        this.storageRequired = storageRequired;
        this.vramRequired = vramRequired;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getStorageRequired()
    {
        return this.storageRequired;
    }

    public void setStorageRequired( int storageRequired )
    {
        this.storageRequired = storageRequired;
    }

    public int getVramRequired()
    {
        return this.vramRequired;
    }

    public void setVramRequired( int vramRequired )
    {
        this.vramRequired = vramRequired;
    }

}
