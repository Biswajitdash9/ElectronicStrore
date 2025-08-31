package com.admin.panel;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener  implements HttpSessionAttributeListener,HttpSessionListener

{
	@Override
	public void sessionCreated(HttpSessionEvent hse)
	{
		System.out.println("session object initialised" );
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent hse)
	{
		System.out.println("session object Destroyed" );

	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent hsbe)
	{
		System.out.println("Attribute added to the session object ");

		System.out.println("Attribute name:"+hsbe.getName());
	}
	@Override
	public void attributeRemoved(HttpSessionBindingEvent hsbe)
	{
		System.out.println("Attribute removed");
		
	}
}
