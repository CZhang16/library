package com.hfut.library.dao;

import com.hfut.library.entity.Custom;

/**
 * �û������ӿ�
 * @author ZC
 *
 */
public interface CustomDao {
	public void addCustom(Custom custom);
	public void removeCustom(String id);
	public void updatePassword(String id,String password);
	//public String getPassword(String name);
	public boolean haveCustom(String name);
	public Custom getCustom(String name,String password);
}
