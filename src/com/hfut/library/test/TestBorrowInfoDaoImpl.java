package com.hfut.library.test;

import java.util.List;

import org.junit.Test;

import com.hfut.library.dao.BorrowInfoDao;
import com.hfut.library.dao.impl.BorrowInfoDaoImpl;
import com.hfut.library.entity.BorrowInfo;

public class TestBorrowInfoDaoImpl {
	private BorrowInfoDao dao = new BorrowInfoDaoImpl();
	@Test
	public void createBorrowInfoTest(){
		dao.createBorrowInfo("2","4");
	}
	@Test
	public void getBorrowInfoTest(){
		BorrowInfo borrowInfo = dao.getBorrowInfo("3", "4");
		System.out.println(borrowInfo.toString());
	}
	@Test
	public void findByIdTest(){
		List<BorrowInfo> list = dao.findById("3");
		for (BorrowInfo borrowInfo : list) {
			System.out.println(borrowInfo.toString());
		}
	}
	@Test
	public void deleteBorrowInfoTest(){
		dao.deleteBorrowInfo("3");
	}
}
