package com.customer.panel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/customerRegister")
public class CustomerRegistrationServlet extends HttpServlet
{

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		CustomerBean cb=new CustomerBean();
		
		cb.setUserName(req.getParameter("cname"));
		cb.setPassword(req.getParameter("pwd"));
		cb.setFirstName(req.getParameter("fname"));
		cb.setLastName(req.getParameter("lname"));
		cb.setAddress(req.getParameter("addr"));
		cb.setMail(req.getParameter("mail"));
		cb.setMobile(req.getParameter("mob"));
		
		int rowcount=new CustomerRegisterDAO().insertCustomerData(cb);
		
		if(rowcount>0)
		{
			req.setAttribute("msg","Registration Completed successfully");
			req.getRequestDispatcher("CustomerLogin.jsp").forward(req, res);
		}
		else 
		{
		
			req.setAttribute("msg","Registration failed");
			req.getRequestDispatcher("CustomerLogin.jsp").forward(req, res);
		}
		
	}
}
