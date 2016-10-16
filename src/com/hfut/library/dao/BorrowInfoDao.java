package com.hfut.library.dao;

import java.util.List;

import com.hfut.library.entity.BorrowInfo;

/**
 * ���Ĺ�ϵ�����ӿ�
 * @author ZC
 *
 */
public interface BorrowInfoDao {
	public void createBorrowInfo(String id,String ISBN);//����
	public void deleteBorrowInfo(String no);//����
	public List<BorrowInfo> findById(String id);//�����û������ѽ��鼮
	public BorrowInfo getBorrowInfo(String id,String ISBN);//��ȡ������Ϣ
}
