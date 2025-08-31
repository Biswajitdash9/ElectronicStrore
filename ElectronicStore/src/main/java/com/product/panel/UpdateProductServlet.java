package com.product.panel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/update")
public class UpdateProductServlet  extends HttpServlet
{

	protected void doPost(HttpServletRequest  req,HttpServletResponse res) throws ServletException, IOException
	{
	
		HttpSession	session=req.getSession(false);
		//session.invalidate();
		
		if(session==null)
		{
			req.getRequestDispatcher("AdminLogin.html").forward(req, res);
		}
		else
		{
			String pcode=req.getParameter("pcode");
		ArrayList<ProductBean>	al=(ArrayList<ProductBean>)session.getAttribute("productlist");
		ProductBean pb=null;
		Iterator<ProductBean> i=al.iterator();
		
		while(i.hasNext()) {
			pb=i.next();
			if(pcode.equals(pb.getpCode()))
			{
				break;
			}
		}
		
		pb.setpPrice(req.getParameter("pprice"));
		pb.setpQtn(req.getParameter("pqty"));
		
		UpdateProductDAO obj=new UpdateProductDAO();
		int rowcount=obj.updateData(pb);
		
		if(rowcount>0) {
			
		
		req.setAttribute("msg","Product data updated");
		req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
		}
		else {

			req.setAttribute("msg","Product data NOT updated");
			req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
			
		}
		
		}
	}
}
