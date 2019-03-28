package com.kexun.entity;

public class Product {

	private Integer pid;
	private String pname;
	private String pdetail;
	private String price;

	public Product() {
	}

	public Product(Integer pid, String pname, String pdetail, String price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pdetail = pdetail;
		this.price = price;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPdetail() {
		return pdetail;
	}

	public void setPdetail(String pdetail) {
		this.pdetail = pdetail;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
