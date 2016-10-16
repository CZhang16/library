package com.hfut.library.service.impl;

import java.util.List;

import com.hfut.library.dao.BookDao;
import com.hfut.library.dao.impl.BookDaoImpl;
import com.hfut.library.entity.Book;
import com.hfut.library.exception.ISBNRepeatException;
import com.hfut.library.service.BookService;
/**
 * 图书操作逻辑类
 * @author ZC
 *
 */
public class BookServiceImpl implements BookService {
	private BookDao dao = new BookDaoImpl();
	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<Book> fingByName(String name) {
		// TODO Auto-generated method stub
		return dao.fingByName(name);
	}

	@Override
	public void removeBook(String ISBN) {
		// TODO Auto-generated method stub
		dao.removeBook(ISBN);
	}

	@Override
	public void addBook(Book book) throws ISBNRepeatException {
		// TODO Auto-generated method stub
		if(dao.ISBNExist(book.getISBN())){
			throw new ISBNRepeatException("此书号已存在");
		}else{
			dao.addBook(book);
		}
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		dao.updateBook(book);
	}

	@Override
	public Book findByISBN(String ISBN) {
		// TODO Auto-generated method stub
		return dao.findByISBN(ISBN);
	}

	@Override
	public List<Book> findByAuthor(String author) {
		// TODO Auto-generated method stub
		return dao.findByAuthor(author);
	}

}
