package com.customer.panel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/customerlogin")
public class CustomerLoginServlet  extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException 
	{
		
		CustomerBean cb=new CustomerLoginDAO().checkValidCustomer(req.getParameter("uname"),req.getParameter("pwd"));
		
		if(cb==null)
		{
			req.setAttribute("msg", "Wrong Credentials");
			req.getRequestDispatcher("CustomerLogin.jsp").forward(req, res);
		}
		else
		{
			HttpSession session=req.getSession();
			session.setAttribute("cbean", cb);
			
			req.getRequestDispatcher("CustomerHome.jsp").forward(req, res);
			
		}
		
		
	}

}
