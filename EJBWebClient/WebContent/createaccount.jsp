<%@ page import='javax.naming.*'%>
<%@ page import='java.io.*'%>
<%@ page import='java.util.*'%>
<%@ page import='net.droidfx.bank.*'%>

<HTML>
<BODY>
	<FORM action="createaccount.jsp">
		<h1>Create A Bank Account</h1>
		Name: <INPUT type="text" name="ownername" size="20" value=""><BR>
		Balance: <INPUT type="text" name="balance" size="20" value=""><BR>
		<INPUT type="submit" name="todo" value="Add Account"><br>
	</FORM>

	<%
		//INSERT CODE HERE
		String ownerName = request.getParameter("ownername");
		String balanceString = request.getParameter("balance");

		if (ownerName != null) {
			try {
				InitialContext ctx = new InitialContext();
				TellerRemote teller = (TellerRemote) ctx
						.lookup("java:global/EJB_EAR_Demo/EJB_Demo/Teller!net.droidfx.bank.TellerRemote");
				int balance = new Integer(balanceString).intValue();
				int id = teller.createAccount(ownerName, balance);
				out.println("Account created. ID: " + id);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
	%>
</BODY>
</HTML>
