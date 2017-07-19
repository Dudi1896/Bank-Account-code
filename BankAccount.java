class BankAccount {
  private String number;
  private double balance;

  // Constructor
  public BankAccount(String accountNumber,
                     double initialBalance) {
    number = accountNumber;
    balance = initialBalance;
  }

  // Deposits a specified amount into the account
  public void deposit(double amount) {
    balance += amount;
  }

  // Withdraws a specified amount from the account
  public void withdraw(double amount) {
    balance -= amount;
  }

  // Returns the account number
  public String getNumber() {
    return number;
  }

  // Returns the account balance
  public double getBalance() {
    return balance;
  }
}
