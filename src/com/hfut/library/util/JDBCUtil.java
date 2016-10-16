package com.hfut.library.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 用于使用JDBC方法获取数据库连接与关闭资源
 * @author ZC
 *
 */
public class JDBCUtil {
	
	private static String url=null;//数据库url
	private static String user=null;//数据库用户名
	private static String password=null;//数据库密码
	private static String driver=null;//驱动类位置
	/**
	 * 使用静态代码块来进行注册驱动信息，
	 * 为方便url、用户名、密码、驱动类位置更改已适应不同数据库，
	 * 将这些信息放在src/db.properties文件下,
	 * 在静态代码块中获取这些信息。
	 */
	static{
		try {
			//读取properties文件
			Properties prop = new Properties();
			InputStream in = JDBCUtil.class.getResourceAsStream("/db.properties");
			//加载文件
			prop.load(in);
			//获取属性
			url=prop.getProperty("url");
			user=prop.getProperty("user");
			password=prop.getProperty("password");
			driver=prop.getProperty("driver");
			//注册驱动程序
			Class.forName(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("注册驱动程序出错！");
		}
	}
	
	/**
	 * 获取连接对象
	 * @return
	 */
	public static Connection getConnection(){
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	/**
	 * 关闭资源
	 * @param conn
	 * @param stat
	 */
	public static void close(Connection conn,PreparedStatement stat){
		if(stat!=null)
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		
	}
	/**
	 * 关闭资源的重载方法
	 * @param conn
	 * @param stat
	 * @param rs
	 */
	public static void close(Connection conn,PreparedStatement stat,ResultSet rs){
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				throw new RuntimeException(e1);
				
			}
		if(stat!=null)
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		
	}
}
