// **ATTENTION**
// Edit just this file to submit your answer
// You need not edit the TestCheckingAccount.java file 
// Leave the Account.class file alone  
// If your class has problems accessing the Account.class, 
// go to Actions -> Reset Assignment. Make sure you have your code stored on your computer. 
/* In Week-1, the Account class was defined to model a bank account.
An account has the properties: account id, balance, annual interest rate, and date created, and
methods to deposit and withdraw funds.

OK - Create a subclass for checking account CheckingAccount.
A checking account has an overdraft limit of 5000. Provide constructors for CheckingAccount similar
to Account. Override withdraw() to print out “over limit” if
the amount withdrawing exceeds the overdraft limit. */

public class CheckingAccount extends Account{

    CheckingAccount(int id, double balance){
        super(id, balance);
    }

    public void withdraw(double amount) {
        if ((this.getBalance() - amount) < -5000){
            System.out.println("Over limit");
        } else {
            double currBalance = this.getBalance();
            this.setBalance(currBalance - amount);
        }
    }
}
