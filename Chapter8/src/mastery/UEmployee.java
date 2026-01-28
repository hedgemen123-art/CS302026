package mastery;

/*
Program: UEmployee.java           Last Date of this Revision: January 28, 2026

Purpose: Defines a university employee with a name and salary,
and provides methods to return employee info and calculate pay.

Author: Bilal Hajar
School: CHHS
Course: Computer Programming 30
*/

/*
Class Purpose:
Represents a general university employee.
*/
public class UEmployee
{
    /* Constructors */

    /*
    Purpose: Constructs a UEmployee object with a name and salary.
    */
    public UEmployee(String employeeName, double employeeSalary)
    {
        name = employeeName;
        salary = employeeSalary;
    }

    /* Instance Methods */

    /*
    Purpose: Returns the employee's name.
    */
    public String getName()
    {
        return name;
    }

    /*
    Purpose: Returns the employee's salary.
    */
    public double getSalary()
    {
        return salary;
    }

    /*
    Purpose: Calculates pay based on weeks worked (override in subclasses if needed).
    */
    public double calculatePay(double timeWorked)
    {
        return (timeWorked / TOTAL_WEEKS) * salary;
    }

    /* Instance Fields */

    protected String name;
    protected double salary;

    /* Static Fields */

    protected static final double TOTAL_WEEKS = 52.0;
}
