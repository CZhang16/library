package com.hfut.library.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ����ʹ��JDBC������ȡ���ݿ�������ر���Դ
 * @author ZC
 *
 */
public class JDBCUtil {
	
	private static String url=null;//���ݿ�url
	private static String user=null;//���ݿ��û���
	private static String password=null;//���ݿ�����
	private static String driver=null;//������λ��
	/**
	 * ʹ�þ�̬�����������ע��������Ϣ��
	 * Ϊ����url���û��������롢������λ�ø�������Ӧ��ͬ���ݿ⣬
	 * ����Щ��Ϣ����src/db.properties�ļ���,
	 * �ھ�̬������л�ȡ��Щ��Ϣ��
	 */
	static{
		try {
			//��ȡproperties�ļ�
			Properties prop = new Properties();
			InputStream in = JDBCUtil.class.getResourceAsStream("/db.properties");
			//�����ļ�
			prop.load(in);
			//��ȡ����
			url=prop.getProperty("url");
			user=prop.getProperty("user");
			password=prop.getProperty("password");
			driver=prop.getProperty("driver");
			//ע����������
			Class.forName(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ע�������������");
		}
	}
	
	/**
	 * ��ȡ���Ӷ���
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
	 * �ر���Դ
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
	 * �ر���Դ�����ط���
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
