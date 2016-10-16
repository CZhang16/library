package com.hfut.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hfut.library.dao.BookDao;
import com.hfut.library.entity.Book;
import com.hfut.library.util.JDBCUtil;
/**
 * 图书操作实现类
 * @author ZC
 *
 */
public class BookDaoImpl implements BookDao {
	/**
	 * 得到全部图书
	 */
	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		Connection conn =  null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql="SELECT * FROM book;";
			stat = conn.prepareStatement(sql);
			
			//获取查询信息
			rs = stat.executeQuery();
			//创建图书集合类对象list
			List<Book> list = new ArrayList<Book>();
			//将信息封装成类并放入list中
			while(rs.next()){
				Book book = new Book();
				book.setISBN(rs.getString("ISBN"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				list.add(book);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//关闭资源
			JDBCUtil.close(conn, stat,rs);
		}
	}
	/**
	 * 根据书名查找图书
	 */
	@Override
	public List<Book> fingByName(String name) {
		// TODO Auto-generated method stub
		Connection conn =  null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql="SELECT * FROM book WHERE NAME LIKE ?;";
			//增加模糊查询条件
			String nameTemp = "%"+name+"%";
			stat = conn.prepareStatement(sql);
			stat.setString(1, nameTemp);
			//获取查询信息
			rs = stat.executeQuery();
			//创建图书集合类对象list
			List<Book> list = new ArrayList<Book>();
			//将信息封装成类并放入list中
			while(rs.next()){
				Book book = new Book();
				book.setISBN(rs.getString("ISBN"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				list.add(book);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//关闭资源
			JDBCUtil.close(conn, stat,rs);
		}
	}
	/**
	 * 删除图书
	 */
	@Override
	public void removeBook(String ISBN) {
		// TODO Auto-generated method stub
		Connection conn =  null;
		PreparedStatement stat = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql="DELETE FROM book WHERE ISBN=?;";
			stat = conn.prepareStatement(sql);
			stat.setString(1, ISBN);
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//关闭资源
			JDBCUtil.close(conn, stat);
		}
	}
	/**
	 * 添加图书
	 */
	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		Connection conn =  null;
		PreparedStatement stat = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql="INSERT INTO book(ISBN,NAME,author,publisher) VALUES (?,?,?,?);";
			stat = conn.prepareStatement(sql);
			stat.setString(1, book.getISBN());
			stat.setString(2, book.getName());
			stat.setString(3, book.getAuthor());
			stat.setString(4, book.getPublisher());
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//关闭资源
			JDBCUtil.close(conn, stat);
		}
	}
	/**
	 * 修改图书信息
	 */
	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		Connection conn =  null;
		PreparedStatement stat = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql="UPDATE book SET NAME=?,author=?,publisher=?WHERE ISBN=?;";
			stat = conn.prepareStatement(sql);
			stat.setString(1, book.getName());
			stat.setString(2, book.getAuthor());
			stat.setString(3, book.getPublisher());
			stat.setString(4, book.getISBN());
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//关闭资源
			JDBCUtil.close(conn, stat);
		}
	}
	/**
	 * 根据书号查询图书
	 */
	@Override
	public Book findByISBN(String ISBN) {
		// TODO Auto-generated method stub
		Connection conn =  null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql="SELECT * FROM book WHERE ISBN LIKE ?;";
			stat = conn.prepareStatement(sql);
			stat.setString(1, ISBN);
			//获取查询信息
			rs = stat.executeQuery();
			//将信息封装成类并放入list中
			rs.next();
			Book book = new Book();
			book.setISBN(rs.getString("ISBN"));
			book.setName(rs.getString("name"));
			book.setAuthor(rs.getString("author"));
			book.setPublisher(rs.getString("publisher"));
			
			return book;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//关闭资源
			JDBCUtil.close(conn, stat,rs);
		}
	}

	/**
	 * 根据作者查询图书
	 */
	@Override
	public List<Book> findByAuthor(String author) {
		// TODO Auto-generated method stub
		Connection conn =  null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql="SELECT * FROM book WHERE author LIKE ?;";
			stat = conn.prepareStatement(sql);
			//增加模糊查询条件
			String authorTemp = "%"+author+"%";
			stat.setString(1, authorTemp);
			//获取查询信息
			rs = stat.executeQuery();
			//创建图书集合类对象list
			List<Book> list = new ArrayList<Book>();
			//将信息封装成类并放入list中
			while(rs.next()){
				Book book = new Book();
				book.setISBN(rs.getString("ISBN"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				list.add(book);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//关闭资源
			JDBCUtil.close(conn, stat,rs);
		}
	}
	@Override
	public boolean ISBNExist(String ISBN) {
		// TODO Auto-generated method stub
		Connection conn =  null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql="SELECT * FROM book WHERE ISBN=?;";
			stat = conn.prepareStatement(sql);
			stat.setString(1, ISBN);
			//获取查询信息
			rs = stat.executeQuery();
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//关闭资源
			JDBCUtil.close(conn, stat,rs);
		}
	}

}
