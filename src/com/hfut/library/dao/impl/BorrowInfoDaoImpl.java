package com.hfut.library.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.hfut.library.dao.BorrowInfoDao;
import com.hfut.library.entity.BorrowInfo;
import com.hfut.library.util.JDBCUtil;

public class BorrowInfoDaoImpl implements BorrowInfoDao {

	@Override
	public void createBorrowInfo(String id,String ISBN) {
		// TODO Auto-generated method stub
		Connection conn =  null;
		PreparedStatement stat = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql="INSERT INTO borrowinfo(NO,id,ISBN,DATE) VALUES (?,?,?,?);";
			stat = conn.prepareStatement(sql);
			//创建随机字符
			String no = UUID.randomUUID().toString().replace("-", "");
			stat.setString(1, no);
			stat.setString(2, id);
			stat.setString(3, ISBN);
			stat.setDate(4, new Date(new java.util.Date().getTime()));
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
	 * 根据编号删除信息
	 */
	@Override
	public void deleteBorrowInfo(String no) {
		// TODO Auto-generated method stub
		Connection conn =  null;
		PreparedStatement stat = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql="DELETE FROM borrowinfo WHERE NO=?;";
			stat = conn.prepareStatement(sql);
			stat.setString(1, no);
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

	@Override
	public List<BorrowInfo> findById(String id) {
		// TODO Auto-generated method stub
		Connection conn =  null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql="SELECT * FROM borrowInfo WHERE id LIKE ?;";
			stat = conn.prepareStatement(sql);
			stat.setString(1, id);
			//获取查询信息
			rs = stat.executeQuery();
			//创建图书集合类对象list
			List<BorrowInfo> list = new ArrayList<BorrowInfo>();
			//将信息封装成类并放入list中
			while(rs.next()){
				BorrowInfo borrowInfo = new BorrowInfo();
				borrowInfo.setNo(rs.getString("no"));
				borrowInfo.setId(rs.getString("id"));
				borrowInfo.setISBN(rs.getString("ISBN"));
				borrowInfo.setDate(rs.getDate("date"));
				list.add(borrowInfo);
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
	public BorrowInfo getBorrowInfo(String id, String ISBN) {
		// TODO Auto-generated method stub
		Connection conn =  null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql="SELECT * FROM borrowinfo WHERE ID=? AND ISBN=?;";
			stat = conn.prepareStatement(sql);
			stat.setString(1, id);
			stat.setString(2, ISBN);
			//获取查询信息
			rs = stat.executeQuery();
			//将信息封装成类并放入list中
			rs.next();
			BorrowInfo borrowInfo = new BorrowInfo();
			borrowInfo.setNo(rs.getString("no"));
			borrowInfo.setId(rs.getString("id"));
			borrowInfo.setISBN(rs.getString("ISBN"));
			borrowInfo.setDate(rs.getDate("date"));
			
			return borrowInfo;
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
