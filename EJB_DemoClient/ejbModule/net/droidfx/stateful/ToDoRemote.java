package net.droidfx.stateful;

import java.util.Vector;

public interface ToDoRemote {

	public abstract Vector<String> listItems();

	public abstract void clearItems();

	public abstract void addItem(String item);

}
