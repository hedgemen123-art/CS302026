package mastery;

/*
Program: Staff.java           Last Date of this Revision: January 28, 2026

Purpose: Represents a staff member with a job title and hourly salary, including pay calculation.

Author: Bilal Hajar
School: CHHS
Course: Computer Programming 30
*/

public class Staff extends UEmployee
{
    /* Constructors */

    /*
    Purpose: Constructs a StaffAcct with name, hourly rate, and job title.
    */
    public Staff(String employeeName, double hourlyRate, String jobTitle)
    {
        super(employeeName, hourlyRate); // Correct: call UEmployee(String, double)
        this.jobTitle = jobTitle;
    }

    /* Instance Methods */

    public String getJobTitle()
    {
        return jobTitle;
    }

    /*
    Purpose: Calculates pay based on hours worked.
    */
    public double calculatePay(double hoursWorked)
    {
        return salary * hoursWorked; // salary field stores hourly rate for staff
    }

    /* Instance Fields */

    private String jobTitle;
}
