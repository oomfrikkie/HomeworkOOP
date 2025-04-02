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
    3
    public void generateDefaultColumns()
    {
        Column toDo = new Column("Done");
        Column inProgress = new Column("In Progress");
        Column done = new Column("Done");

        this.columns.add(toDo);
        this.columns.add(inProgress);
        this.columns.add(done);
    }
}
