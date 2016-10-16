package com.hfut.library.service.impl;

import com.hfut.library.dao.CustomDao;
import com.hfut.library.dao.impl.CustomDaoImpl;
import com.hfut.library.entity.Custom;
import com.hfut.library.exception.HaveCustomException;
import com.hfut.library.service.CustomService;
/**
 * �û��߼��жϽӿ�ʵ����
 * @author ZC
 *
 */
public class CustomServiceImpl implements CustomService {
	private CustomDao dao= new CustomDaoImpl();
	@Override
	public void addCustom(Custom custom) throws HaveCustomException {
		// TODO Auto-generated method stub
		//�ж��û����Ƿ����
		if(dao.haveCustom(custom.getName())){
			throw new HaveCustomException("�û����Ѵ���");
		}else{
			dao.addCustom(custom);
		}
	}

	@Override
	public void removeCustom(String id) {
		// TODO Auto-generated method stub
		dao.removeCustom(id);
	}

	@Override
	public void updatePassword(String id, String password) {
		// TODO Auto-generated method stub
		dao.updatePassword(id, password);
	}

	/*@Override
	public String getPassword(String name) {
		// TODO Auto-generated method stub
		return dao.getPassword(name);
	}*/

	@Override
	public Custom getCustom(String name, String password) {
		// TODO Auto-generated method stub
		return dao.getCustom(name, password);
	}

}
