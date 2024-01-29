// **ATTENTION**
// YOU DO NOT NEED TO EDIT THIS FILE

public class TestAccount{
  public static void main (String[] args) {
    /*Account account = new Account(1122, 20000);
    System.out.println(account.getId());
    System.out.println(account.getBalance());
    System.out.println(account.getAnnualInterestRate());
    System.out.println(account.getDateCreated());

    //testing the setters
    account.setId(1006644);
    account.setBalance(175000);
    account.setAnnualInterestRate(4.6);
    System.out.println(account.getBalance());

    System.out.println(account.getMonthlyInterestRate());
    System.out.println(account.getMonthlyInterest());

    account.withdraw(10);
    System.out.println(account.getBalance());
    account.deposit(100);
    System.out.println(account.getBalance());

    */

      Account account = new Account(1122, 20000);

      Account.setAnnualInterestRate(4.5);

      account.getId();

      System.out.println("My id is " + account.getId());

      account.withdraw(2500);

      account.deposit(3000);

      System.out.println("Balance is " + account.getBalance());

      System.out.println("Monthly interest is " +

              account.getMonthlyInterest());


    }
  }
