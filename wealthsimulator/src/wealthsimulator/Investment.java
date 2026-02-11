package wealthsimulator;

public class Investment {

    private String name;
    private double principal;
    private double interestRate; // stored as decimal (0.05 for 5%)
    private int term; // years

    public Investment(String name, double principal, double interestRate, int term) {
        this.name = name;
        this.principal = principal;
        this.interestRate = interestRate;
        this.term = term;
    }

    public String getName() {
        return name;
    }

    public double getPrincipal() {
        return principal;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getTerm() {
        return term;
    }

    // Compound interest using loop
    public double calculateBalance() {
        double amount = principal;

        for (int i = 0; i < term; i++) {
            amount = amount * (1 + interestRate);
        }

        return amount;
    }

    @Override
    public String toString() {
        return name + "," + principal + "," + interestRate + "," + term;
    }

    public String displayInfo() {
        return "Investment: " + name +
               "\nPrincipal: $" + principal +
               "\nInterest Rate: " + (interestRate * 100) + "%" +
               "\nTerm: " + term + " years" +
               "\nFinal Balance: $" + String.format("%.2f", calculateBalance()) +
               "\n--------------------------";
    }
}
