package net.droidfx.entity;

import java.io.Serializable;

import javax.persistence.*;

import net.droidfx.bank.listener.BankListener;

/**
 * Entity implementation class for Entity: BankAccount
 *
 */
@Entity
@Table(name = "BANKACCOUNT")
@EntityListeners(BankListener.class)
public class BankAccount implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "BALANCE")
	private int balance;
	@Column(name = "OWNERNAME")
	private String ownerName;

	public BankAccount() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public void deposit(int amount) {
		this.setBalance(getBalance() + amount);
	}

	public void withdraw(int amount) {
		this.setBalance(getBalance() - amount);
	}

}
