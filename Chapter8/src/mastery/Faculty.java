package mastery;

/*
Program: Faculty.java           Last Date of this Revision: January 28, 2026

Purpose: Represents a faculty member with a department and salary, including pay calculation.

Author: Bilal Hajar
School: CHHS
Course: Computer Programming 30
*/

public class Faculty extends UEmployee
{
    /* Constructors */

    public Faculty(String employeeName, double employeeSalary, String departmentName)
    {
        super(employeeName, employeeSalary);
        department = departmentName;
    }

    /* Instance Methods */

    public String getDepartment()
    {
        return department;
    }

    public double calculatePay(double weeksWorked)
    {
        // Faculty are salaried: pay based on weeks worked
        return (weeksWorked / TOTAL_WEEKS) * salary;
    }

    /* Instance Fields */

    private String department;
}
