package com.buyrecord.panel;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customer.panel.CustomerBean;
@WebServlet("/view3")
public class MyOrderServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		
   HttpSession	session =req.getSession(false);
   
   if(session==null)
   {
	   req.getRequestDispatcher("CustomerLogin.jsp").forward(req, res);
   }
   else
   {
	  CustomerBean cbean=(CustomerBean)session.getAttribute("cbean");
	  
	  ArrayList<RecordBean> rb=new MyOrderDAO().viewRecord(cbean.getUserName());
	  
	  session.setAttribute("record", rb);
	  req.getRequestDispatcher("RecordView.jsp").forward(req, res);
   }
		
	}
	

}
