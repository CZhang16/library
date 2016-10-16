package com.hfut.library.dao;

import java.util.List;

import com.hfut.library.entity.Book;

/**
 * 图书操作接口
 * @author ZC
 *
 */
public interface BookDao {
	public List<Book> findAll();
	public List<Book> fingByName(String name);
	public void removeBook(String ISBN);
	public void addBook(Book book);
	public void updateBook(Book book);
	public Book findByISBN(String ISBN);
	public List<Book> findByAuthor(String author);
	public boolean ISBNExist(String ISBN);
	
}
