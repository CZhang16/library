package com.hfut.library.entity;
/**
 * ”√ªß¿‡
 * @author ZC
 *
 */
public class Custom {
	private String id;
	private String name;
	private String phone;
	private String gender;
	private String password;
	private boolean isAdmin;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Custom(String id, String name, String phone, String gender,
			String password, boolean isAdmin) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.gender = gender;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	public Custom() {
		super(); 
	}
	@Override
	public String toString() {
		return "Custom [id=" + id + ", name=" + name + ", phone=" + phone
				+ ", gender=" + gender + ", password=" + password
				+ ", isAdmin=" + isAdmin + "]";
	}
	
}
