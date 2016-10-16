package com.hfut.library.service;

import java.util.List;

import com.hfut.library.entity.Book;
import com.hfut.library.exception.ISBNRepeatException;
/**
 * Í¼ÊéÂß¼­ÅÐ¶Ï½Ó¿Ú
 * @author ZC
 *
 */
public interface BookService {
	public List<Book> findAll();
	public List<Book> fingByName(String name);
	public void removeBook(String ISBN);
	public void addBook(Book book) throws ISBNRepeatException;
	public void updateBook(Book book);
	public Book findByISBN(String ISBN);
	public List<Book> findByAuthor(String author);
}
