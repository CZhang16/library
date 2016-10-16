package com.hfut.library.dao;

import java.util.List;

import com.hfut.library.entity.BorrowInfo;

/**
 * 借阅关系操作接口
 * @author ZC
 *
 */
public interface BorrowInfoDao {
	public void createBorrowInfo(String id,String ISBN);//借书
	public void deleteBorrowInfo(String no);//还书
	public List<BorrowInfo> findById(String id);//根据用户搜索已借书籍
	public BorrowInfo getBorrowInfo(String id,String ISBN);//获取借阅信息
}
