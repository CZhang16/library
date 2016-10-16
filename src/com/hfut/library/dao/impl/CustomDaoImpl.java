package com.hfut.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.hfut.library.dao.CustomDao;
import com.hfut.library.entity.Custom;
import com.hfut.library.util.JDBCUtil;
/**
 * �û�����ʵ����
 * @author ZC
 *
 */
public class CustomDaoImpl implements CustomDao {

	/**
	 * ����û�
	 */
	@Override
	public void addCustom(Custom custom) {
		// TODO Auto-generated method stub
		Connection conn =  null;
		PreparedStatement stat = null;
		try {
			//��ȡ����
			conn = JDBCUtil.getConnection();
			//����sql���
			String sql="INSERT INTO custom(id,NAME,phone,gender,PASSWORD,isadmin) VALUES(?,?,?,?,?,?);";
			//Ԥ����sql���
			stat = conn.prepareStatement(sql);
			//��������ַ�
			String id = UUID.randomUUID().toString().replace("-", "");
			//����sql���
			stat.setString(1, id);
			stat.setString(2, custom.getName());
			stat.setString(3, custom.getPhone());
			stat.setString(4, custom.getGender());
			stat.setString(5, custom.getPassword());
			//�ǹ���Ա�����ݿ���Ϊ1������Ϊ0
			if(custom.isAdmin()){
				stat.setInt(6, 1);
			}else{
				stat.setInt(6, 0);
			}
			//ִ�����
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//�ر���Դ
			JDBCUtil.close(conn, stat);
		}
	}

	/**
	 * ɾ���û�
	 */
	@Override
	public void removeCustom(String id) {
		// TODO Auto-generated method stub
		Connection conn =  null;
		PreparedStatement stat = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql="DELETE FROM custom WHERE id=?;";
			stat = conn.prepareStatement(sql);
			stat.setString(1, id);
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//�ر���Դ
			JDBCUtil.close(conn, stat);
		}
	}
	/**
	 * �޸�����
	 */
	@Override
	public void updatePassword(String id, String password) {
		// TODO Auto-generated method stub
		Connection conn =  null;
		PreparedStatement stat = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql="UPDATE custom SET PASSWORD=?WHERE id=?;";
			stat = conn.prepareStatement(sql);
			stat.setString(1, password);
			stat.setString(2, id);
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//�ر���Դ
			JDBCUtil.close(conn, stat);
		}
	}
	/**
	 * ��ȡ����
	 */
	/*@Override
	public String getPassword(String name) {
		// TODO Auto-generated method stub
		Connection conn =  null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql="SELECT PASSWORD FROM custom WHERE NAME=?;";
			stat = conn.prepareStatement(sql);
			stat.setString(1, name);
			//��ȡ��ѯ��Ϣ
			rs = stat.executeQuery();
			//����Ƶ���һ��
			rs.next();
			//��ȡ�����ֶ�����
			String password = rs.getString(1);
			return password;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//�ر���Դ
			JDBCUtil.close(conn, stat,rs);
		}
	}*/
	/**
	 * �ж��û��Ƿ����
	 */
	@Override
	public boolean haveCustom(String name) {
		// TODO Auto-generated method stub
		Connection conn =  null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql="SELECT * FROM custom WHERE NAME=?;";
			stat = conn.prepareStatement(sql);
			stat.setString(1, name);
			rs=stat.executeQuery();
			//�д�������true������false
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
			//�ر���Դ
			JDBCUtil.close(conn, stat,rs);
		}
	}

	@Override
	public Custom getCustom(String name, String password) {
		// TODO Auto-generated method stub
		Connection conn =  null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql="SELECT * FROM custom WHERE NAME=? AND password=?;";
			stat = conn.prepareStatement(sql);
			stat.setString(1, name);
			stat.setString(2, password);
			rs=stat.executeQuery();
			if(!rs.next()){
				return null;//����-1���û������������
			}else{
				Custom custom = new Custom();
				custom.setId(rs.getString("id"));
				custom.setName(rs.getString("name"));
				custom.setPassword(rs.getString("password"));
				custom.setGender(rs.getString("gender"));
				custom.setPhone(rs.getString("phone"));
				custom.setAdmin(rs.getInt("isAdmin")==0?false:true);
				
				
				
				return custom;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//�ر���Դ
			JDBCUtil.close(conn, stat,rs);
		}
	}

}
