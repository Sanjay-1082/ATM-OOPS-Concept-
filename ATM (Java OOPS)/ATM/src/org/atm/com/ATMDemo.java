package org.atm.com;

import java.util.Scanner;

public class ATMDemo {
	public static String accountNo;
	public static String pinNo;
	
	
    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner scanner = new Scanner(System.in);

        // Sample User Creation
        atm.addUser("12345", "1111");
        atm.addUser("67890", "2222");
        
        while (true) {
            System.out.println("Enter account number:");
            String accountNumber = scanner.nextLine();
            System.out.println("Enter PIN:");
            String pin = scanner.nextLine();

            atm.authenticateUser(accountNumber, pin);

            boolean sessionActive = true;
            while (sessionActive) {
                System.out.println("1. Check Balance\n2. Deposit Money\n3. Withdraw Money\n4. Change PIN\n5. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        System.out.println("Enter amount to deposit:");
                        double depositAmount = scanner.nextDouble();
                        atm.depositMoney(depositAmount);
                        break;
                    case 3:
                        System.out.println("Enter amount to withdraw:");
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdrawMoney(withdrawAmount);
                        break;
                    case 4:
                        System.out.println("Enter new PIN:");
                        String newPin = scanner.nextLine();
                        atm.changePin(newPin);
                        break;
                    case 5:
                        sessionActive = false;
                        break;
                    default:
                        atm.displayMessage("Invalid option! Please try again.");
                }
            }
        }
    }
}

