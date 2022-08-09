package com.samples;

import java.util.ArrayList;
import java.util.List;

import com.samples.domain.Book;
import com.samples.domain.Chapter;
import com.samples.domain.Publisher;
import com.samples.service.BookstoreService;

public class BookstoreTest {

	public static void main(String[] args) {

		BookstoreService bookStoreService = new BookstoreService();
		Book book = bookStoreService.getBook("isbn-000117jd93301");
		System.out.println(book);
		
	}

	public static void savebook() {
		Publisher publisher = new Publisher("mann", "Manning");

		Book book = new Book("isbn-000117jd93301", "Java Bible", publisher);

		List<Chapter> chapters = new ArrayList<>();
		Chapter chapter1 = new Chapter(1, "Introduction");
		Chapter chapter2 = new Chapter(2, "Datatypes");
		Chapter chapter3 = new Chapter(3, "Loops");
		chapters.add(chapter1);
		chapters.add(chapter2);
		chapters.add(chapter3);

		book.setChapters(chapters);

		BookstoreService bookStoreService = new BookstoreService();
		bookStoreService.addBook(book);
	}
	
	

}