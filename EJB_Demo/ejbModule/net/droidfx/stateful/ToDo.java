package net.droidfx.stateful;

import java.util.Vector;

import javax.ejb.Remote;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class ToDo
 */
@Stateful(mappedName = "ToDo")
@Remote(ToDoRemote.class)
public class ToDo implements ToDoRemote {
	Vector<String> items = new Vector<String>();

	/**
	 * Default constructor.
	 */
	public ToDo() {
		// TODO Auto-generated constructor stub
	}

	public void addItem(String item) {
		items.add(item);
	}

	public void clearItems() {
		items.clear();
	}

	public Vector<String> listItems() {
		return items;
	}

}
