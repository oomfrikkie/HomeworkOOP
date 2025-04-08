import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Column
{
    private String title;
    private List<Ticket> tickets;

    public Column( String title )
    {
        this.title = title;
        this.tickets = new ArrayList<>();
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle( String title)
    {
         this.title = title;
    }

    public List<Ticket> getTickets()
    {
        return this.tickets;
    }

    public void setTickets( List<Ticket> tickets )
    {
        if(tickets != null )
        {
            this.tickets = tickets;
        }

        this.tickets = new ArrayList<>();
    }

    public void addTicket( Ticket ticket)
    {
        if(ticket != null)
        {
            this.tickets.add(ticket);
        }

        throw new IllegalArgumentException("Cannot add an empty ticket");
    }

    public void removeTicket( Ticket ticket )
    {

        if(ticket == null)
        {
            throw new IllegalArgumentException("Ticket to be removed cannot be empty");
        }
        Iterator<Ticket> iterator = this.tickets.iterator();

        while(iterator.hasNext())
        {
            if(iterator.next() == ticket)
            {
                iterator.remove();;
            }
        }
    }






}
