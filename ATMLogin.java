package com.vastpro.ATM;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ATMLogin
 */
@WebServlet("/ATMLogin")
public class ATMLogin extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	HashMap< Long, Double> hm=new HashMap<Long, Double>();
   
	public ATMLogin() 
    {
		 hm.put(1013101310l,150000.0);
		 hm.put(1234123412l,75000.0);
		 hm.put(4556122378l,201523.0);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		long cardNo=Long.parseLong(request.getParameter("card"));
		long pinNum=Long.parseLong(request.getParameter("pin"));
		String req=request.getParameter("Request");
		double bal=0;
	
		if(req.equals("Balance Enquiry"))
		{
			pw.print("<h1>Hello user</h1>"+"<br>");
			for(Map.Entry m:hm.entrySet())
			{
				if((m.getKey().equals(cardNo)))
				{
					pw.print("Card Number: "+m.getKey()+"<br>");
					pw.print("Balance: "+m.getValue()+"<br>");
				}
			}
		}
		else if(req.equals("Withdrawal"))
		{
			for(Map.Entry m:hm.entrySet())
			{
				if((m.getKey().equals(cardNo)))
				{
					bal=(double) (m.getValue());
				}
			}
			
			pw.println("<h1>Withdraw</h1>"); 
	        pw.print("<form method='post'>");  
	        pw.print("<table>");  
	        pw.print("<tr><td>Amount:</td><td><input type='number' name='amnt' /></td></tr>"); 
	        pw.print("<tr><td></td><td><input type='hidden' name='card' value=' "+cardNo+" ' /></td></tr>");
	        pw.print("<tr><td></td><td><input type='hidden' name='balance' value=' "+bal+" ' /></td></tr>");
	        pw.print("<tr><td colspan='2'><input type='submit' value='withdraw' formaction='Withdraw' /></td></tr>");  
	        pw.print("</table>");  
	        pw.print("</form>"); 
		}
		else if(req.equals("Cheque Book Request"))
		{
			pw.println("<h1>Cheque Book Request</h1>"); 
	        pw.print("<form method='post'>");  
	        pw.print("<table>");  
	        pw.print("<tr><td>Card Number:</td><td><input type='number' name='num' /></td></tr>"); 
	        pw.print("<tr><td>Reason:</td><td><input type='text'  /></td></tr>");
	        pw.print("<tr><td colspan='2'><input type='submit' value='Submit' formaction='chequeServlet'/></td></tr>");  
	        pw.print("</table>");  
	        pw.print("</form>"); 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
