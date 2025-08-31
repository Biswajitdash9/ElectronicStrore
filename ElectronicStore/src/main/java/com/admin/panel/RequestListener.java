package com.admin.panel;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener,ServletRequestAttributeListener
{
	@Override
	public void requestInitialized(ServletRequestEvent sre)
	{
		System.out.println("Request object initialized");
	}
	@Override
	public void requestDestroyed(ServletRequestEvent sre)
	{
		System.out.println("Request object Destroyed");

	}
	
	@Override
	public void attributeAdded(ServletRequestAttributeEvent scae)
	{
	
		System.out.println("Attribute added to ServletRequest object");
		System.out.println("Attribute Name "+scae.getName());

	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent scae)
	{
		
		System.out.println("Attribute removed from the servletRequest object");
	}

}


