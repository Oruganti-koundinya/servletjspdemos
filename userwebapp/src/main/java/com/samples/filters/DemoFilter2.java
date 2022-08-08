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
public class DemoFilter2 extends HttpFilter implements Filter {
       
    public DemoFilter2() {
        super();
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		System.out.println("Demofilter 2");

		// pass the request along the filter chain
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}