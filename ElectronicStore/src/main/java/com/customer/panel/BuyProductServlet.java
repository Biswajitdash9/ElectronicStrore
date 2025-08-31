package com.customer.panel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.product.panel.ProductBean;

@WebServlet("/buy")
public class BuyProductServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
	HttpSession	session=req.getSession(false);
	
	if(session==null)
	{
		req.getRequestDispatcher("CustomerLogin.jsp").forward(req, res);
	}
	else
	{
		ProductBean pb=new BuyProductDAO().showData(req.getParameter("pcode"));
		if(pb==null) {
			System.out.println("null pb");
		}
		
		session.setAttribute("productbean", pb);
		req.getRequestDispatcher("BuyProduct.jsp").forward(req, res);
	}
		
	}

}
