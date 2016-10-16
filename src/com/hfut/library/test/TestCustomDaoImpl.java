package com.hfut.library.test;

import org.junit.Test;

import com.hfut.library.dao.CustomDao;
import com.hfut.library.dao.impl.CustomDaoImpl;
import com.hfut.library.entity.Custom;

/**
 * CustomDaoImplµƒ≤‚ ‘¿‡
 * @author ZC
 *
 */
public class TestCustomDaoImpl {
	CustomDao dao = new CustomDaoImpl();
	@Test
	public void addCustomTest(){
		Custom custom = new Custom("2", "lishi", "334455", "n", "9999", true);
		dao.addCustom(custom);
	}
	@Test
	public void removeCustomTest(){
		String id="2";
		dao.removeCustom(id);
	}
	@Test
	public void updatePasswordTest(){
		String id="3";
		String password="6668";
		dao.updatePassword(id, password);
	}
	/*@Test
	public void getPasswordTest(){
		String name="lishi";
		System.out.println(dao.getPassword(name));
	}*/
	@Test
	public void haveCustomTest(){
		String name="lishi";
		System.out.println(dao.haveCustom(name));
	}
	@Test
	public void getAdminTest(){
		String name="lishi";
		String password = "9999";
		System.out.println(dao.getCustom(name, password));
	}

}
