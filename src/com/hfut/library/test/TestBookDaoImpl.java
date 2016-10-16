package com.hfut.library.test;

import java.util.List;

import org.junit.Test;

import com.hfut.library.dao.BookDao;
import com.hfut.library.dao.impl.BookDaoImpl;
import com.hfut.library.entity.Book;

/**
 * BookDaoImplµƒ≤‚ ‘¿‡
 * @author ZC
 *
 */
public class TestBookDaoImpl {
	private BookDao dao = new BookDaoImpl();
	@Test
	public void findAllTest(){
		List<Book> list = dao.findAll();
		for (Book book : list) {
			System.out.println(book.toString());
		}
	}
	@Test
	public void fingByNameTest(){
		String name="2";
		List<Book> list = dao.fingByName(name);
		for (Book book : list) {
			System.out.println(book.toString());
			
		}
	}
	@Test
	public void fingByAuthorTest(){
		String author="3";
		List<Book> list = dao.findByAuthor(author);
		for (Book book : list) {
			System.out.println(book.toString());
			
		}
	}
	@Test
	public void findByISBNTest(){
		String ISBN = "1";
		Book book = dao.findByISBN(ISBN);
		System.out.println(book.toString());
	}
	@Test
	public void removeBookTest(){
		String ISBN = "5";
		dao.removeBook(ISBN);
	}
	@Test
	public void addBookTest(){
		Book book = new Book("5","6","7","8");
		dao.addBook(book);
	}
	@Test
	public void updateBookTest(){
		Book book = new Book("5","8","8","8");
		dao.updateBook(book);
	}
}
