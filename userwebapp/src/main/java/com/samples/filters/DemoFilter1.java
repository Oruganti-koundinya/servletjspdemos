package com.samples.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/readuserServlet")
public class DemoFilter1 extends HttpFilter implements Filter {
       
    public DemoFilter1() {
        super();
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		System.out.println("Demofilter 1");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Before calling servlet");
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		out.println("after calling servlet");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}