package mastery;

/*
Program: AccountClient.java           Last Date of this Revision: January 28, 2026

Purpose: Tests the Account, PersonalAcct, and BusinessAcct classes.

Author: Bilal Hajar
School: CHHS
Course: Computer Programming 30
*/

public class AccountClient
{
    public static void main(String[] args)
    {
        // Testing Personal Account
        PersonalAcct personal = new PersonalAcct(150.0);
        personal.withdraw(60.0);

        System.out.println("Personal Account Balance: $" + personal.getBalance());

        // Testing Business Account
        BusinessAcct business = new BusinessAcct(600.0);
        business.withdraw(200.0);

        System.out.println("Business Account Balance: $" + business.getBalance());
    }
}
