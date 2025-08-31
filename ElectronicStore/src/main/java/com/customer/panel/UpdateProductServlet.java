 package com.customer.panel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.buyrecord.panel.RecordBean;
@WebServlet("/buy1")
public class UpdateProductServlet  extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
	
		 int availability; int required;
	 HttpSession	session=req.getSession(false);
	 if(session==null)
	 {
			req.getRequestDispatcher("CustomerLogin.jsp").forward(req, res);
	 }
	 else
	 {
		 CustomerBean cbean=(CustomerBean)session.getAttribute("cbean");
		 
		 availability=Integer.parseInt(req.getParameter("avail"));
		  required=Integer.parseInt(req.getParameter("quantity"));
		
		  //sending the details of product for inserting in buyrecord table
		 RecordBean rb=new RecordBean();
		 rb.setUname(cbean.getUserName());
		 rb.setPcode(req.getParameter("pcode"));
		 rb.setPname(req.getParameter("pname"));
		 rb.setPcompany(req.getParameter("pcompany"));
		 rb.setPrice(req.getParameter("price"));
		  rb.setItemPurchased(req.getParameter("quantity"));
	
		 
		 if(required<=availability && availability>0)
		 {
			 int set=availability-required;
			 
			 
			 int rowcount=new UpdateProductDAO().updateProduct(set, req.getParameter("pcode"),rb);
			 if(rowcount>0)
				 
			 {
				 int cost=required*(Integer.parseInt(req.getParameter("price")));
				 req.setAttribute("cost",cost);
				 req.getRequestDispatcher("OrderConfirmed.jsp").forward(req, res);
			 }
					 
		 }
		 else
		 {   req.setAttribute("msg", "Check the availability");
			 req.getRequestDispatcher("BuyProduct.jsp").forward(req, res);
			 
		 }

		 
	 }
	 
	}

}
