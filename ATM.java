package org.atm.com;

import java.util.Vector;

public class ATM implements ATMInterface {
    private Vector<User> users = new Vector<>();
    private User authenticatedUser;

    @Override
    public void addUser(String accountNumber, String pin) {
        users.add(new User(accountNumber, pin));
        displayMessage("User added successfully!");
    }

    @Override
    public void authenticateUser(String accountNumber, String pin) {
        for (User user : users) {
            if (user.getAccountNumber().equals(accountNumber) && user.getPin().equals(pin)) {
                authenticatedUser = user;
                displayMessage("Authentication successful!");
                return;
            }
        }
        displayMessage("Authentication failed! Check account number or PIN.");
    }

    @Override
    public void checkBalance() {
        if (authenticatedUser != null) {
            displayMessage("Your balance is: " + authenticatedUser.getBalance());
        } else {
            displayMessage("Please authenticate first.");
        }
    }

    @Override
    public void depositMoney(double amount) {
        if (authenticatedUser != null) {
            authenticatedUser.deposit(amount);
            displayMessage("Deposited: " + amount);
            displayMessage("New balance: " + authenticatedUser.getBalance());
        } else {
            displayMessage("Please authenticate first.");
        }
    }

    @Override
    public void withdrawMoney(double amount) {
        if (authenticatedUser != null) {
            if (authenticatedUser.withdraw(amount)) {
                displayMessage("Withdrew: " + amount);
                displayMessage("New balance: " + authenticatedUser.getBalance());
            } else {
                displayMessage("Insufficient funds!");
            }
        } else {
            displayMessage("Please authenticate first.");
        }
    }

    @Override
    public void changePin(String newPin) {
        if (authenticatedUser != null) {
            authenticatedUser.changePin(newPin);
            displayMessage("PIN changed successfully!");
        } else {
            displayMessage("Please authenticate first.");
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
