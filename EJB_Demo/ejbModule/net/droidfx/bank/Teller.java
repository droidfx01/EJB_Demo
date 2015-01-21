package net.droidfx.bank;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.droidfx.entity.BankAccount;

/**
 * Session Bean implementation class Teller
 */
@Stateless(mappedName = "Teller")
public class Teller implements TellerRemote, TellerLocal {

	@PersistenceContext(unitName="BankAccountJPA")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public Teller() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public int createAccount(String ownerName, int balance) {
		BankAccount account = new BankAccount();
		account.setBalance(balance);
		account.setOwnerName(ownerName);
		em.persist(account);
		return account.getId();
	}

	@Override
	public BankAccount deposit(int id, int amount) {
		BankAccount account = em.find(BankAccount.class, id);
		account.deposit(amount);
		return account;
	}

	@Override
	public BankAccount withdraw(int id, int amount) {
		BankAccount account = em.find(BankAccount.class, id);
		account.withdraw(amount);
		return account;
	}

	@Override
	public void closeAccount(int id) {
		BankAccount account = em.find(BankAccount.class, id);
		em.remove(account);
	}

}
