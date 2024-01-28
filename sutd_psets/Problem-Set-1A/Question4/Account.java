// ATTENTION 
// just edit this file
// TestAccount.java contains the test cases provided in the problem set 
// Put in any import statements that you need 
import java.time.LocalDate;

public class Account {
    // instance variables
    private int id;
    private double balance;
    private static double annualInterestRate;
    private LocalDate dateCreated;

    // Constructor
    public Account(){
        this.id = 0;
        this.balance = 0;
        this.annualInterestRate=0;
        this.dateCreated = LocalDate.now();

    }
    // Full Constructor
    public Account(int id, double balance){
        this.id = id;
        this.balance = balance;
        this.annualInterestRate=0;
        this.dateCreated = LocalDate.now();

    }

    // Getter Methods
    public int getId(int id){
        return id;
    }

    public double getBalance(){
        return balance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    // Mutator Method
    public void setId{
        this.id = id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }
}

// **HINT**
// The problem set says "assume all accounts have the same interest rate". 
// What does that tell you about the variable(s) and/or method(s) relating to the interest rate? 