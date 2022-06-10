package com.vastpro.ATM;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Withdraw
 */
@WebServlet("/Withdraw")
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Withdraw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		int with=Integer.parseInt(request.getParameter("amnt"));
		String card=request.getParameter("card");
		pw.print("Successfully withdraw from "+card);
		double bal=Double.parseDouble(request.getParameter("balance"));
		double result=bal-with;
		pw.print("<br>");
		pw.print("Available Balance: "+result);
		pw.print("<form method='post'>");
		pw.print("<tr><td><input type='hidden' name='with' value=' "+with+"' /></td></tr>");
		pw.print("<tr><td><input type='hidden' name='balance' value=' "+result+"' /></td></tr>");
		pw.print("<tr><td><input type='submit' name='MiniSatement' value='MiniSatement' "
				+ "formaction='miniStmntServlet' /></td></tr>");
		pw.print("<tr><td><input type='submit' name='Home' value='Home' formaction='ATM.html' /></td></tr>");
		pw.print("</form>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
