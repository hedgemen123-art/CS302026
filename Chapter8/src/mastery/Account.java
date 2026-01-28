package mastery;

/*
Program: Account.java           Last Date of this Revision: January 28, 2026

Purpose: Defines a general bank account with deposit and withdrawal
capabilities.

Author: Bilal Hajar
School: CHHS
Course: Computer Programming 30
*/

/*
Class Purpose:
Represents a basic bank account.
*/
public class Account
{
    /* Constructors */

    /*
    Purpose: Constructs an Account with an initial balance.
    */
    public Account(double startingBalance)
    {
        balance = startingBalance;
    }

    /* Instance Methods */

    /*
    Purpose: Deposits money into the account.
    */
    public void deposit(double amount)
    {
        balance = balance + amount;
    }

    /*
    Purpose: Withdraws money from the account.
    */
    public void withdraw(double amount)
    {
        balance = balance - amount;
    }

    /*
    Purpose: Returns the account balance.
    */
    public double getBalance()
    {
        return balance;
    }

    /* Instance Fields */

    protected double balance;
}
