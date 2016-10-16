package com.hfut.library.entity;
/**
 * 图书实体类
 * @author ZC
 *
 */
public class Book {
	private String ISBN;
	private String name;
	private String author;
	private String publisher;
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Book(String iSBN, String name, String author, String publisher) {
		super();
		ISBN = iSBN;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", name=" + name + ", author=" + author
				+ ", publisher=" + publisher + "]";
	}
	
}
