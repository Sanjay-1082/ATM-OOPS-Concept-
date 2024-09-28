package org.atm.com;

public interface ATMInterface {
	void addUser(String accountNumber, String pin);
    void authenticateUser(String accountNumber, String pin);
    void checkBalance();
    void depositMoney(double amount);
    void withdrawMoney(double amount);
    void changePin(String newPin);
    void displayMessage(String message);
}
