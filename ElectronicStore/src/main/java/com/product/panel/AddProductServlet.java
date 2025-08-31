package com.product.panel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.panel.AdminLoginDAO;

@WebServlet("/aps")
public class AddProductServlet  extends HttpServlet
{

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		
		try 
		{
			HttpSession session=req.getSession();
			
			
			if(session==null)
			{
				req.getRequestDispatcher("AdminLogin.html").forward(req, res);
			}
			else
			{
				
				ProductBean pb=new ProductBean();
				
				pb.setpCode(req.getParameter("pcode"));
				pb.setpName(req.getParameter("pname"));
				pb.setpCompany(req.getParameter("pcomp"));
				pb.setpPrice(req.getParameter("pprice"));
				pb.setpQtn(req.getParameter("pqty"));
					
				int rowcount=new AddProductDAO().insertProductDetails(pb);
				
				if(rowcount>0)
				{
					req.setAttribute("msg","Product Details Added Successfully");
					req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
				}
//				else 
//				{
//					req.setAttribute("msg","Product Details addition failed");
//					req.getRequestDispatcher("AddProduct.jsp").forward(req, res);	
//				}
//					
			}

			
		}catch(Exception e)
		{

		req.setAttribute("msg","Duplicate Product ids are not allowed");
		req.getRequestDispatcher("Error.jsp").forward(req, res);	
	
		}
	}
}
