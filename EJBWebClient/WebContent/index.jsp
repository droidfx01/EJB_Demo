<%@ page import='javax.naming.*'%>
<%@ page import='java.io.*'%>
<%@ page import='java.util.*'%>
<%@ page import='net.droidfx.stateful.*'%>

<HTML>
<BODY>
	<FORM action="index.jsp">
		Enter a to-do item: <INPUT type="text" name="item" size="20" value=""><BR>
		<INPUT type="submit" name="todo" value="Add Item"> <INPUT
			type="submit" name="todo" value="List Items"> <INPUT
			type="submit" name="todo" value="Clear List">
	</FORM>

	<%
		//INSERT CODE HERE
		String action = request.getParameter("todo");
		ToDoRemote td = (ToDoRemote) session.getAttribute("todo");
		if (td == null) {
			try {
				InitialContext ctx = new InitialContext();
				td = (ToDoRemote) ctx.lookup("java:global/EJB_EAR_Demo/EJB_Demo/ToDo!net.droidfx.stateful.ToDoRemote");
				session.setAttribute("todo", td);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}

		if (action != null) {
			if (action.equals("Add Item")) {
				String item = request.getParameter("item");
				if (!(item.equals(""))) {
					td.addItem(item);
					out.println("Added item: " + item);
				}
			} else if (action.equals("List Items")) {
				Vector<String> items = td.listItems();
				out.println("Items:");
				for (int i = 0; i != items.size(); i++) {
					out.println("<br>" + (i + 1) + ". "
							+ items.elementAt(i));
				}
			} else if (action.equals("Clear List")) {
				td.clearItems();
				out.println("Items cleared");
			}
		}
	%>
</BODY>
</HTML>
