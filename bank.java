import java.util.*;
public class Bank {
  public static void main(String[] args) {

    final int MAX_ACCOUNTS = 10;

    // Create an array to store the bank accounts
    BankAccount[] accounts = new BankAccount[MAX_ACCOUNTS];

    // numAccounts is the number of accounts currently in
    // existence. current is the array index of the currently
    // selected account (or -1 if no account is currently
    // selected).
    int numAccounts = 0;
    int current = -1;

    // Read and execute commands
    while (true) {

      // Display list of commands
      System.out.println(
        "-------------------------------------------------\n" +
        "|Commands: o - Open account    c - Close account|\n" +
        "|          d - Deposit         w - Withdraw     |\n" +
        "|          s - Select account  q - Quit         |\n" +
        "-------------------------------------------------");

      // Display the current account number and balance
      System.out.print("Current account: ");
      if (current != -1) {
        System.out.print(accounts[current].getNumber() +
                         "  Balance: $");

        // Round the balance to the nearest cent
        long balanceInCents =
          Math.round(accounts[current].getBalance() * 100);

        // Display the balance as dollars and cents, adding
        // a leading zero if the cents is a one-digit number
        System.out.print(balanceInCents / 100 + ".");
        long cents = balanceInCents % 100;
        if (cents < 10)
          System.out.print("0");
        System.out.println(cents);
      } else
        System.out.println("None selected");
      System.out.println();

      // Prompt the user to enter a command
      Scanner stdin = new Scanner(System.in);
      System.out.print("Enter command: ");
      String command = stdin.nextLine().trim();

      // Use an if else statement to determine which
      // command was entered
      if (command.equalsIgnoreCase("o")) {
        // *** Open command ***
        // If the accounts array is full, tell user no more allowed
                if (numAccounts == MAX_ACCOUNTS){
                System.out.println("Maximum account limit has been reached,no\n" +
                                   "more accounts can be made at this time.\n");
                }

        // Prompt the user for the account number and balance
                else if (numAccounts < MAX_ACCOUNTS){
                System.out.print("\nPlease enter your new account number : ");
                String accountNum = stdin.nextLine();
                System.out.print("\nPlease enter your initial balance : $ ");
                double accountBal = stdin.nextDouble();

        // Create a new BankAccount object and store it in the
        // accounts array.  Increment the number of accounts.

                BankAccount newAccount = new BankAccount(accountNum, accountBal);
                accounts[numAccounts] = newAccount;
                current = numAccounts;
                numAccounts++;
                }


      }
      else if (command.equalsIgnoreCase("c")) {

        // *** Close command ***
                if (current != -1){
                accounts[current] = accounts[--numAccounts];
                current =-1;
                }
                else {
                System.out.print("Please select an account\n");
                }

      } else if (command.equalsIgnoreCase("d")) {

        //*** Deposit command ***

                if (current != -1){
                System.out.print("\nEnter amount to deposit:  ");
                double depAmount = stdin.nextDouble();
                accounts[current].deposit(depAmount);
                }
                else {
                System.out.print("Please select an account\n");
                }


      } else if (command.equalsIgnoreCase("w")) {

        // *** Withdraw command ***

                if (current != -1){
                System.out.print("\nEnter amount to withdraw:  ");
                double widAmount = stdin.nextDouble();
                accounts[current].withdraw(widAmount);
                }
                else {
                System.out.print("Please select an account\n");
                }

      } else if (command.equalsIgnoreCase("s")) {

        // *** Select command ***
        System.out.print("\nEnter account number: ");
        String selectAccount = stdin.nextLine();

                if (current != -1) {
                        for (int i = 0; i <= accounts.length-1; i++){

                                if ( selectAccount.equals(accounts[i].getNumber() )){
                                current = i;
                                i = accounts.length + 10;
                                }
                        }
                }
                else {
                System.out.print("Account number was not found\n");
                }

      } else if (command.equalsIgnoreCase("q")) {

                if (current == -1) {
                break;
                }
                else {
                break;
                }

      } else {

        // *** Illegal command ***
                System.out.print("Command was not recognized; please try again.\n");

             }

    }
  }
}
