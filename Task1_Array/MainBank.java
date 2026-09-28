import java.util.Scanner;

public class MainBank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n=== ATM / Bank Menu ===");
            System.out.println("1. Add Customer");
            System.out.println("2. Set Customer Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. List Customers");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            
            if (!scanner.hasNextInt()) break;
            int option = scanner.nextInt();

            if (option == 0) break;

            switch (option) {
                case 1:
                    System.out.print("Enter first name: ");
                    String fname = scanner.next();
                    System.out.print("Enter last name: ");
                    String lname = scanner.next();
                    bank.addCustomer(fname, lname);
                    System.out.println("Customer added.");
                    break;
                case 2:
                    System.out.print("Enter customer index (0 to " + (bank.getNumOfCustomers() - 1) + "): ");
                    int idx = scanner.nextInt();
                    Customer c = bank.getCustomer(idx);
                    if (c != null) {
                        System.out.print("Enter initial balance: ");
                        double bal = scanner.nextDouble();
                        c.setAccount(new Account(bal));
                        System.out.println("Account created for " + c.getFirstName());
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter customer index: ");
                    int idxDep = scanner.nextInt();
                    Customer cDep = bank.getCustomer(idxDep);
                    if (cDep != null && cDep.getAccount() != null) {
                        System.out.print("Enter deposit amount: ");
                        double amt = scanner.nextDouble();
                        cDep.getAccount().deposit(amt);
                        System.out.println("Deposit successful. New balance: " + cDep.getAccount().getBalance());
                    } else {
                        System.out.println("Customer or account not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter customer index: ");
                    int idxWith = scanner.nextInt();
                    Customer cWith = bank.getCustomer(idxWith);
                    if (cWith != null && cWith.getAccount() != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double amt = scanner.nextDouble();
                        if (cWith.getAccount().withdraw(amt)) {
                            System.out.println("Withdrawal successful. New balance: " + cWith.getAccount().getBalance());
                        } else {
                            System.out.println("Insufficient funds or invalid amount.");
                        }
                    } else {
                        System.out.println("Customer or account not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter customer index: ");
                    int idxBal = scanner.nextInt();
                    Customer cBal = bank.getCustomer(idxBal);
                    if (cBal != null && cBal.getAccount() != null) {
                        System.out.println("Balance: " + cBal.getAccount().getBalance());
                    } else {
                        System.out.println("Customer or account not found.");
                    }
                    break;
                case 6:
                    System.out.println("Total customers: " + bank.getNumOfCustomers());
                    for (int i = 0; i < bank.getNumOfCustomers(); i++) {
                        Customer cust = bank.getCustomer(i);
                        String hasAcc = (cust.getAccount() != null) ? "Yes (Bal: " + cust.getAccount().getBalance() + ")" : "No";
                        System.out.println("[" + i + "] " + cust.getFirstName() + " " + cust.getLastName() + " - Has Account: " + hasAcc);
                    }
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}
