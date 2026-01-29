package mastery;

/*
personal account class
*/

public class PersonalAcct extends Account
{
    // minimum balance constant
    private static final double MIN_BALANCE = 100.0;
    // penalty constant
    private static final double PENALTY = 2.0;

    // constructor
    public PersonalAcct(double bal, String fName, String lName)
    {
        super(bal, fName, lName);
    }

    // override withdrawal
    public void withdrawal(double amt)
    {
        // do normal withdrawal
        super.withdrawal(amt);

        // check minimum balance
        if (getBalance() < MIN_BALANCE)
        {
            super.withdrawal(PENALTY);
        }
    }
}
