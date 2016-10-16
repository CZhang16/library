package com.hfut.library.entity;

import java.util.Date;

/**
 * ͼ�����û����Ĺ�ϵʵ����
 * @author ZC
 *
 */
public class BorrowInfo {
	private String no;//�������
	private String ISBN;//���
	private String id;//�û����
	private Date date;//����ʱ��
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public BorrowInfo(String no, String iSBN, String id, Date date) {
		super();
		this.no = no;
		ISBN = iSBN;
		this.id = id;
		this.date = date;
	}
	public BorrowInfo() {
		super();
	}
	@Override
	public String toString() {
		return "BorrowInfo [no=" + no + ", ISBN=" + ISBN + ", id=" + id
				+ ", date=" + date + "]";
	}
	
}
