package mastery;

/*
Program: PersonalAcct.java           Last Date of this Revision: January 28, 2026

Purpose: Defines a personal account that charges a fee if the balance
falls below the minimum requirement.

Author: Bilal Hajar
School: CHHS
Course: Computer Programming 30
*/

/*
Class Purpose:
Represents a personal bank account with a minimum balance rule.
*/
public class PersonalAcct extends Account
{
    /* Constructors */

    /*
    Purpose: Constructs a PersonalAcct with an initial balance.
    */
    public PersonalAcct(double startingBalance)
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

    private static final double MINIMUM_BALANCE = 100.0;
    private static final double PENALTY_FEE = 2.0;
}
