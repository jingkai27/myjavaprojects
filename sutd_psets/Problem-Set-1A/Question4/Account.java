// This is the correct answer.

import java.time.LocalDate;

public class Account {
    // instance variables
    private int id;
    private double balance;
    private static double annualInterestRate;
    private LocalDate dateCreated;

    // Constructor
    public Account() {
        this.id = 0;
        this.balance = 0;
        annualInterestRate = 0;
        this.dateCreated = LocalDate.now();

    }

    // Full Constructor
    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        annualInterestRate = 0;
        this.dateCreated = LocalDate.now();
    }

    // GETTER METHODS
    public int getId(){
        return this.id;
    }

    public double getBalance(){
        return this.balance;
    }

    public static double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public LocalDate getDateCreated(){
        return this.dateCreated;
    }

    // Setter methods
    public void setId(int newValue){
        id = newValue;
    }

    public void setBalance(double newValue){
        this.balance = newValue;
    }

    public static void setAnnualInterestRate(double newValue){
        annualInterestRate = newValue;
    }

    //Method to get Monthly Interest Rate and Monthly Interest
    public static double getMonthlyInterestRate(){
        return getAnnualInterestRate() / 12.0;
        // i forgot to put static - this is a static class
    }

    public double getMonthlyInterest(){
        double money = this.getBalance();
        double monthlyInterestRate = this.getMonthlyInterestRate();
        double monthlyInterest = money * monthlyInterestRate / 100;
        return monthlyInterest;
    }

    public void withdraw(double moneyOut){
        double balance = this.getBalance();
        balance -= moneyOut;
        this.setBalance(balance);
        // need to check that your variables are set properly
    }

    public void deposit(double moneyIn) {
        double balance = this.getBalance() + moneyIn;
        this.setBalance(balance);
        // need to check that variables are set properly
    }
}
// **HINT**
// The problem set says "assume all accounts have the same interest rate".
// What does that tell you about the variable(s) and/or method(s) relating to the interest rate?