package net.droidfx.bank.listener;

import javax.persistence.PostRemove;
import javax.persistence.PrePersist;

public class BankListener {

	@PrePersist
	public void doSomeListenStuff(Object o) {
		System.out.println("@PrePersist from listener");
	}
	
	@PostRemove
	public void doSomeRemoveListening(Object o) {
		System.out.println("@PostRemove from listener");
	}
}
