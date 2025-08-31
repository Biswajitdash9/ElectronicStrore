package com.product.panel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class DeleteProductServlet  extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
	  
	int row	=new DeleteProductDAO().deleteProduct(req.getParameter("pcode"));
	
	if(row>0)
	{
		req.setAttribute("msg","Data deleted successfully");
		req.getRequestDispatcher("view1").include(req, res);
	}
	else {
		req.setAttribute("msg", "data not deleted");
		req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
	}
		
	}

}
