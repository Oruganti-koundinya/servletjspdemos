package com.samples.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samples.domain.Product;
import com.samples.service.ProductDetailsService;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDetailsService productdetailsservice; 
	
	public void init() throws ServletException {
		super.init();
		this.productdetailsservice = new ProductDetailsService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Product> products = this.productdetailsservice.getproducts();
		
		request.setAttribute("products", products);
		
		RequestDispatcher rd = request.getRequestDispatcher("/viewproducts.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productname = request.getParameter("productname");
		int productprice = Integer.parseInt(request.getParameter("productprice"));
		
		Product product = new Product(productname, productprice);
		
		this.productdetailsservice.addProduct(product);
		
		List<Product> products = this.productdetailsservice.getproducts();
		
		request.setAttribute("products", products);
		
		RequestDispatcher rd = request.getRequestDispatcher("/viewproducts.jsp");
		rd.forward(request, response);
	}

}
