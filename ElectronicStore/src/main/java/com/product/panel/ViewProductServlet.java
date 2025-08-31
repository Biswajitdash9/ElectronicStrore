 package com.product.panel;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/view1")
public class ViewProductServlet  extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
	
		HttpSession session=req.getSession(false);
		
		//ArrayList<ProductBean> al=new ViewProductDAO().retrieveData();
	
		if(session==null)
			
		{
			
			req.getRequestDispatcher("AdminLogin.html").forward(req, res);
			
		}
		else
		{
			
			String msg=(String)req.getAttribute("msg");
			if(msg!=null) //It giving error while  content checking 
			{
				req.setAttribute("msg", msg);
			}
		
			//res.sendRedirect("https://www.google.com");
			ViewProductDAO obj=new ViewProductDAO();
			ArrayList<ProductBean> al=obj.retrieveData();
			session.setAttribute("productlist",al );
			req.getRequestDispatcher("ViewProduct.jsp").forward(req, res);
		}
	
	}

}
