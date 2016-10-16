package com.hfut.library.service;

import com.hfut.library.entity.Custom;
import com.hfut.library.exception.HaveCustomException;
/**
 * �û��߼��жϽӿ�
 * @author ZC
 *
 */
public interface CustomService {
	public void addCustom(Custom custom) throws HaveCustomException;
	public void removeCustom(String id);
	public void updatePassword(String id,String password);
	//public String getPassword(String name);
	public Custom getCustom(String name, String password);
}
