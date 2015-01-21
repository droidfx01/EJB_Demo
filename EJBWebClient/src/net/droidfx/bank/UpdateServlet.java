package net.droidfx.bank;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.droidfx.entity.BankAccount;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB(beanName = "Teller")
	private TellerRemote teller;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("todo");
		String idString = request.getParameter("id");
		int id = new Integer(idString).intValue();
		String amountString = request.getParameter("amount");
		int amount = new Integer(amountString).intValue();
		BankAccount account;

		if ("Deposit".equals(action)) {
			account = teller.deposit(id, amount);
			request.setAttribute("account", account);
		} else if ("Withdraw".equals(action)) {
			account = teller.withdraw(id, amount);
			request.setAttribute("account", account);
		} else if ("Close Account".equals(action)) {
			teller.closeAccount(id);
			request.setAttribute("closed", "" + id);
		}

		request.getRequestDispatcher("displayaccount.jsp").forward(request,
				response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
