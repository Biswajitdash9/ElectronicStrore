package com.customer.panel;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.product.panel.ProductBean;

@WebServlet("/view2")
public class VIewCustomerProductServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
	
		HttpSession session=req.getSession(false);
		
		if(session==null)
		{
			req.getRequestDispatcher("CustomerLogin.jsp").forward(req, res);
		}
		else
		{
			  ArrayList<ProductBean> al= new ArrayList<ProductBean>();
			  
			  al=new ViewCustomerProductDAO().viewData();
			  session.setAttribute("allproduct", al);
			  req.getRequestDispatcher("ViewCustomerProduct.jsp").forward(req, res);
			  
		}
	}

}
