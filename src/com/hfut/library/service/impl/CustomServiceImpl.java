package com.hfut.library.service.impl;

import com.hfut.library.dao.CustomDao;
import com.hfut.library.dao.impl.CustomDaoImpl;
import com.hfut.library.entity.Custom;
import com.hfut.library.exception.HaveCustomException;
import com.hfut.library.service.CustomService;
/**
 * 用户逻辑判断接口实现类
 * @author ZC
 *
 */
public class CustomServiceImpl implements CustomService {
	private CustomDao dao= new CustomDaoImpl();
	@Override
	public void addCustom(Custom custom) throws HaveCustomException {
		// TODO Auto-generated method stub
		//判断用户名是否存在
		if(dao.haveCustom(custom.getName())){
			throw new HaveCustomException("用户名已存在");
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
