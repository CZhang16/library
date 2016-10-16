package com.hfut.library.service.impl;

import java.util.List;

import com.hfut.library.dao.BorrowInfoDao;
import com.hfut.library.dao.impl.BorrowInfoDaoImpl;
import com.hfut.library.entity.BorrowInfo;
import com.hfut.library.service.BorrowInfoService;

public class BorrowInfoServiceImpl implements BorrowInfoService {
	private BorrowInfoDao dao = new BorrowInfoDaoImpl();
	@Override
	public void createBorrowInfo(String id,String ISBN) {
		// TODO Auto-generated method stub
		dao.createBorrowInfo(id,ISBN);
	}

	@Override
	public void deleteBorrowInfo(String no) {
		// TODO Auto-generated method stub
		dao.deleteBorrowInfo(no);
	}

	@Override
	public List<BorrowInfo> findById(String id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public BorrowInfo getBorrowInfo(String id, String ISBN) {
		// TODO Auto-generated method stub
		return dao.getBorrowInfo(id, ISBN);
	}

}
