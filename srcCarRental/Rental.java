import java.time.LocalDate;

public class Rental
{

    private LocalDate startDate;
    private LocalDate endDate;
    private double distanceTravelled;

    public Rental( LocalDate startDate, LocalDate endDate, double distanceTravelled )
    {

    }
    public LocalDate getStartDate()
    {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate)
    {
       if(!startDate.isAfter(LocalDate.now()))
       {
           this.startDate = startDate;
       }
       else
       {
           throw new IllegalArgumentException("Start date cannot be entered if its after today");
       }
    }

    public LocalDate getEndDate()
    {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate)
    {
        if(!endDate.isAfter(LocalDate.now()))
        {
            this.endDate = endDate;
        }
        else
        {
            throw new IllegalArgumentException("End date cannot be after todays date");
        }
    }

    public double getDistanceTravelled()
    {
        return this.distanceTravelled;
    }

    public void setDistanceTravelled(double distanceTravelled)
    {
        this.distanceTravelled = distanceTravelled;
    }




}
