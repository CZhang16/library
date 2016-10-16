package com.hfut.library.service;

import java.util.List;

import com.hfut.library.entity.BorrowInfo;
/**
 * 借阅关系逻辑接口
 * @author ZC
 *
 */
public interface BorrowInfoService {
	public void createBorrowInfo(String id,String ISBN);//借书
	public void deleteBorrowInfo(String no);//还书
	public List<BorrowInfo> findById(String id);//根据用户搜索已借书籍
	public BorrowInfo getBorrowInfo(String id,String ISBN);//获取借阅信息
}
