package net.droidfx.bank;

import javax.ejb.Remote;

import net.droidfx.entity.BankAccount;

@Remote
public interface TellerRemote {
	public int createAccount(String ownerName, int balance);
	public BankAccount deposit(int id, int amount);
	public BankAccount withdraw(int id, int amount);
	public void closeAccount(int id);
}
