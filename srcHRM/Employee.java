import java.time.LocalDate;
import java.time.Period;

public class Employee
{
    private String name;
    private int employeeNumber;
    private LocalDate dateOfBirth;
    private LocalDate dateOfHire;

    private boolean hasGoodPerformance;
    private boolean hasTaxCredit;
    private boolean hasInsurance;


    public Employee( String name, int employeeNumber, LocalDate dateOfBirth, LocalDate dateOfHire )
    {
        this.name = name;
        setEmployeeNumber( employeeNumber );
        setDateOfBirth( dateOfBirth );
        setDateOfHire( dateOfHire );
    }

    public String getName()
    {
        return this.name;
    }

    public int getEmployeeNumber()
    {
        return this.employeeNumber;
    }

    public LocalDate getDateOfBirth()
    {
        return this.dateOfBirth;
    }

    public LocalDate getDateOfHire()
    {
        return this.dateOfHire;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public void setEmployeeNumber( int employeeNumber )
    {
        if( employeeNumber > 0 )
        {
            this.employeeNumber = employeeNumber;
        }
    }

    public void setDateOfBirth(LocalDate dateOfBirth)
    {
        if( dateOfBirth.isBefore(LocalDate.now()))
        {
            this.dateOfBirth = dateOfBirth;
        }
        else
        {
            throw new IllegalArgumentException("Date of birth cannot be same date or after the current date");
        }
    }

    public void setDateOfHire(LocalDate dateOfHire)
    {
        if( dateOfHire.isBefore(LocalDate.now()) || dateOfHire.equals(LocalDate.now()))
        {
            this.dateOfHire = dateOfHire;
        }
        else
        {
            throw new IllegalArgumentException("Cannot have been hired after the current");
        }
    }

    public int getAge()
    {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public int getYearsOfService()
    {
        return Period.between(dateOfHire, LocalDate.now()).getYears();
    }

    public int getVacationDays()
    {
        int baseVacationDays = 0;
        if(Integer.toString(this.employeeNumber).charAt(0) == '1')
        {
            baseVacationDays = 24;
        }
        else
        {
            baseVacationDays = 20;
        }

        if(this.getAge() > 55)
        {
            baseVacationDays += 5;
        }

        if(this.getYearsOfService() > 10 )
        {
            baseVacationDays += 3;
        }

        return baseVacationDays;
    }

    public double getGrossSalary()
    {
        double baseSalary = 1500;
        int yearsWorked = getYearsOfService();

        for(int i = 0; i < yearsWorked ; i++)
        {
            if(this.hasGoodPerformance)
            {
                baseSalary *= 1.023;
            }
        }

        return baseSalary;
    }

    public double getAnnualGrossSalary()
    {
        return this.getGrossSalary() * 12;
    }

    public double getNetSalary()
    {

        double netSalary = this.getGrossSalary();

        if(this.hasTaxCredit)
        {
            netSalary -= ( netSalary * 0.1);
        }
        else
        {
            netSalary -= ( netSalary * 0.15);
        }

        if(hasInsurance)
        {
            netSalary -= (netSalary * 0.01);
        }

        return netSalary;
    }

    public double getAnnualNetSalary()
    {
        return this.getNetSalary() * 12;
    }

    public double get13thMonthBonus()
    {
        return this.getAnnualGrossSalary() * 0.08;
    }
}
