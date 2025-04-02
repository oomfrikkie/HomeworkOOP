import java.time.LocalDate;
import java.time.Period;

public class EmployeeKB
{
    private String name;
    private LocalDate dateJoined;


    public EmployeeKB( String name , LocalDate dateJoined)
    {
        this.name = name;
        setDateJoined( dateJoined );
    }


    public String getName()
    {
        return this.name;
    }

    public LocalDate getDateJoined()
    {
        return this.dateJoined;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDateJoined(LocalDate dateJoined)
    {
        if(dateJoined.isBefore(LocalDate.now()))
        {
           throw new IllegalArgumentException("Could not have joined the date after today");
        }
        this.dateJoined = dateJoined;
    }

    public int getYearsOFExperience()
    {
        return Period.between(this.getDateJoined(), LocalDate.now()).getYears();
    }

}
