package mastery;

/*
Program: BusinessAcct.java           Last Date of this Revision: January 28, 2026

Purpose: Defines a business account that charges a fee if the balance
falls below the minimum requirement.

Author: Bilal Hajar
School: CHHS
Course: Computer Programming 30
*/

/*
Class Purpose:
Represents a business bank account with a higher minimum balance rule.
*/
public class BusinessAcct extends Account
{
    /* Constructors */

    /*
    Purpose: Constructs a BusinessAcct with an initial balance.
    */
    public BusinessAcct(double startingBalance)
    {
        super(startingBalance);
    }

    /* Instance Methods */

    /*
    Purpose: Withdraws money and applies a fee if balance falls below minimum.
    */
    public void withdraw(double amount)
    {
        super.withdraw(amount);

        if (balance < MINIMUM_BALANCE)
        {
            balance = balance - PENALTY_FEE;
        }
    }

    /* Static Fields */

    private static final double MINIMUM_BALANCE = 500.0;
    private static final double PENALTY_FEE = 10.0;
}
