<%@page import="net.droidfx.entity.BankAccount"%>
<h1>Bank Account was updated.</h1>

<% 
BankAccount ba = (BankAccount) request.getAttribute("account");
if(ba==null) {
	String id = (String) request.getAttribute("closed");
	out.println("Account " + id + " was closed");
} else {
	out.println("Account " + ba.getId() +
			" owned by " + ba.getOwnerName() + 
			" has a new balance of " + ba.getBalance());
}

%>