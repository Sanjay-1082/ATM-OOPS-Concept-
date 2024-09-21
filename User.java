package org.atm.com;


class User {
	private String accountNumber;
	private String pin;
	private double balance;
	private int withdrawalCount;

	public User(String accountNumber, String pin) {
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.balance = 0.0; // Initial balance
		this.withdrawalCount = 0;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getPin() {
		return pin;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public boolean withdraw(double amount) {
		if (balance >= amount) {
			balance -= amount;
			withdrawalCount++;
			if (withdrawalCount % 4 == 0) {
				balance -= 20; // Deduct fee after every 4 withdrawals
			}
			return true;
		}
		return false;
	}

	public void changePin(String newPin) {
		this.pin = newPin;
	}

	public int getWithdrawalCount() {
		return withdrawalCount;
	}
}
