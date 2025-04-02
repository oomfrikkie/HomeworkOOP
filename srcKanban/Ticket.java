public class Ticket
{

    private String description;
    private int requriedExperience;
    private int priority;
    private int timeInHours;
    private EmployeeKB assignedEmployee;


    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getRequriedExperience()
    {
        return this.requriedExperience;
    }

    public void setRequriedExperience(int requriedExperience)
    {
        this.requriedExperience = requriedExperience;
    }

    public int getPriority()
    {
        return this.priority;
    }

    public void setPriority(int priority)
    {
        if(priority >= 1 && priority <= 5)
        {
            this.priority = priority;
        }
    }

    public int getTimeInHours()
    {
        return this.timeInHours;
    }

    public void setTimeInHours(int timeInHours)
    {
        this.timeInHours = timeInHours;
    }

    public EmployeeKB getAssignedEmployee()
    {
        return this.assignedEmployee;
    }

    public void setAssignedEmployee(EmployeeKB assignedEmployee)
    {
        if(assignedEmployee.getYearsOFExperience() < this.getRequriedExperience())
        {
            throw new IllegalArgumentException("Assigned Employee has too little years of experience ");
        }

        this.assignedEmployee = assignedEmployee;
    }


}
