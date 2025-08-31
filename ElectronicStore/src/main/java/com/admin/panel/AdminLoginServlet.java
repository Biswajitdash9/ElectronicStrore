package com.admin.panel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/adminlogin")
public class AdminLoginServlet  extends HttpServlet
{

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
	
		AdminBean abean=new AdminLoginDAO().checkAdminLogin(req.getParameter("aname"), req.getParameter("pwd"));
		
		
		
		if(abean==null)
		{
		
			req.setAttribute("msg","Wrong Credentials ");
			req.getRequestDispatcher("AdminLogin.jsp").forward(req, res);
			
		}
		else {
			HttpSession	session=req.getSession();
			session.setAttribute("abean",abean);
			req.getRequestDispatcher("AdminHome.jsp").forward(req, res);
			
		}
		
	}
}
