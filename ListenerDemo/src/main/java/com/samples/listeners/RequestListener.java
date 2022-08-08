package com.samples.listeners;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RequestListener implements ServletRequestListener{
	
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("Request Destroyed.");
	}
	
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("Request Created...");
	}

}
