package mastery;

/*
business account class
*/

public class BusinessAcct extends Account
{
    // minimum balance constant
    private static final double MIN_BALANCE = 500.0;
    // penalty constant
    private static final double PENALTY = 10.0;

    // constructor
    public BusinessAcct(double bal, String fName, String lName)
    {
        super(bal, fName, lName);
    }

    // override withdrawal
    public void withdrawal(double amt)
    {
        // do normal withdrawal
        super.withdrawal(amt);

        // check minimum balance==
        if (getBalance() < MIN_BALANCE)
        {
            super.withdrawal(PENALTY);
        }
    }
}
