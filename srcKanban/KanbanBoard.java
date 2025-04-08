import java.util.ArrayList;
import java.util.List;

public class KanbanBoard
{



    private List<Column> columns;

    public KanbanBoard()
    {
        this.columns = new ArrayList<>();
        generateDefaultColumns();

    }

    public void generateDefaultColumns()
    {
        Column toDo = new Column("To do");
        Column inProgress = new Column("In Progress");
        Column done = new Column("Done");

        this.columns.add(toDo);
        this.columns.add(inProgress);
        this.columns.add(done);
    }

    public List<Column> getColumns()
    {
        return this.columns;
    }

    public void setColumns(List<Column> columns)
    {
        if( columns == null || columns.isEmpty())
        {
            this.generateDefaultColumns();
        }
        else
        {
            this.columns = columns;
        }
    }

    public Column getDoneColumn()
    {
        for( Column column : this.columns )
        {
            if(column.getTitle().equals("Done"))
            {
                return column;
            }
        }

        return null;
    }

    public List<Ticket> getAllTickets()
    {
        List<Ticket> allTickets = new ArrayList<>();

        for (Column column : this.columns )
        {
            allTickets.addAll(column.getTickets());
        }

        return allTickets;
    }

    public int getTotalNumberOfTickets()
    {
        return this.getAllTickets().size();
    }


    public List<Ticket> getEmployeeTickets( EmployeeKB employeeKB )
    {
        List<Ticket> employeeTickets = new ArrayList<>();

        for (Ticket ticket : this.getAllTickets() )
        {
            if (ticket.getAssignedEmployee() == employeeKB)
            {
                employeeTickets.add(ticket);
            }
        }

        return  employeeTickets;
    }

    public int getNumberOfCompletedTasks()
    {
        return this.getDoneColumn().getTickets().size();
    }

    public double getPercentageOfCompletedTasks()
    {
        if(this.getTotalNumberOfTickets() == 0)
        {
            return 0;
        }

        return (double) this.getNumberOfCompletedTasks() / this.getTotalNumberOfTickets() * 100;
    }




}
