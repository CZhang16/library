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
 * 用户操作实现类
 * @author ZC
 *
 */
public class CustomDaoImpl implements CustomDao {

	/**
	 * 添加用户
	 */
	@Override
	public void addCustom(Custom custom) {
		// TODO Auto-generated method stub
		Connection conn =  null;
		PreparedStatement stat = null;
		try {
			//获取连接
			conn = JDBCUtil.getConnection();
			//构造sql语句
			String sql="INSERT INTO custom(id,NAME,phone,gender,PASSWORD,isadmin) VALUES(?,?,?,?,?,?);";
			//预编译sql语句
			stat = conn.prepareStatement(sql);
			//创建随机字符
			String id = UUID.randomUUID().toString().replace("-", "");
			//完善sql语句
			stat.setString(1, id);
			stat.setString(2, custom.getName());
			stat.setString(3, custom.getPhone());
			stat.setString(4, custom.getGender());
			stat.setString(5, custom.getPassword());
			//是管理员在数据库中为1，否则为0
			if(custom.isAdmin()){
				stat.setInt(6, 1);
			}else{
				stat.setInt(6, 0);
			}
			//执行语句
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
	 * 删除用户
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
			//关闭资源
			JDBCUtil.close(conn, stat);
		}
	}
	/**
	 * 修改密码
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
			//关闭资源
			JDBCUtil.close(conn, stat);
		}
	}
	/**
	 * 获取密码
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
			//获取查询信息
			rs = stat.executeQuery();
			//光标移到下一行
			rs.next();
			//获取密码字段内容
			String password = rs.getString(1);
			return password;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//关闭资源
			JDBCUtil.close(conn, stat,rs);
		}
	}*/
	/**
	 * 判断用户是否存在
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
			//有此名返回true，否则false
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
				return null;//返回-1，用户名或密码错误
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
			//关闭资源
			JDBCUtil.close(conn, stat,rs);
		}
	}

}
