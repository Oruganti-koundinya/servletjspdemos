package com.samples.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samples.domain.Book;
import com.samples.service.BookstoreService;

@WebServlet("/books")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BookstoreService bookstoreService;

	public void init() throws ServletException {
		super.init();
		this.bookstoreService = new BookstoreService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Book> books = this.bookstoreService.getBooks();

		request.setAttribute("books", books);

		RequestDispatcher rd = request.getRequestDispatcher("/viewbooks.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookname = request.getParameter("bookname");
		String isbn = request.getParameter("isbn");
		String pricestr = request.getParameter("price");
		
		if (bookname == null || isbn == null || pricestr == null) {
			// write a response invalid input
			// return
		}
			
		int priceint = Integer.parseInt(pricestr);

		Book book = new Book(isbn, bookname, priceint);

		this.bookstoreService.addBook(book);

		List<Book> books = this.bookstoreService.getBooks();

		request.setAttribute("books", books);

		RequestDispatcher rd = request.getRequestDispatcher("/viewbooks.jsp");
		rd.forward(request, response);
	}

}