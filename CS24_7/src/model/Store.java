package model;

import java.sql.Date;
import java.util.ArrayList;

public class Store {

	private int sno;
	private String location;
	private String sname;
	private String sbrand;
	private String phone;
	private String id;
	private int pno;
	private int amount;
	private int rvno;
	private ArrayList<Product> ProductList;
	private String pname;
	private String gender;
	private int age;
	private int pcount;
	private int price;
	private String brand;
	private int count;
	private int catno;
	private int rvcount;
	private Date week;

	public Store() {
	}

	public Store(String id, String pname) {
		this.id = id;
		this.pname = pname;
	}

	public Store(int sno, String pname, String id) {
		this.sno = sno;
		this.pname = pname;
		this.id = id;
	}

	public Store(String pname, int pcount, String location, String phone, int sno, String id) {
		this.pname = pname;
		this.pcount = pcount;
		this.location = location;
		this.phone = phone;
		this.sno = sno;
		this.id = id;
	}

	// store 정보
	public Store(int sno, String location, String sname, String sbrand, String phone, String id) {
		this.sno = sno;
		this.location = location;
		this.sname = sname;
		this.sbrand = sbrand;
		this.phone = phone;
		this.id = id;
	}

	public Store(String pname, int catno) {
		this.pname = pname;
		this.catno = catno;
	}

	public Store(int sno, int pno) {
		this.sno = sno;
		this.pno = pno;
	}

	public Store(int sno, int pno, String pname, int amount) {
		super();
		this.sno = sno;
		this.pno = pno;
		this.amount = amount;
		this.pname = pname;
	}

	public Store(String sname, String sbrand, String id, int rvno, String pname, int pcount) {
		super();
		this.sname = sname;
		this.sbrand = sbrand;
		this.id = id;
		this.rvno = rvno;
		this.pname = pname;
		this.pcount = pcount;
	}

	// reservation 정보
	public Store(int rvno, int sno, String pname, String id, String gender, int age, int pcount) {
		this.rvno = rvno;
		this.sno = sno;
		this.pname = pname;
		this.id = id;
		this.gender = gender;
		this.age = age;
		this.pcount = pcount;
	}

	public Store(String id, int sno, int pno, String pname, String gender, int age, int pcount, int amount,
			String location, String sbrand, String sname, String phone, int price, String brand) {
		super();
		this.id = id;
		this.sno = sno;
		this.pno = pno;
		this.pname = pname;
		this.gender = gender;
		this.age = age;
		this.pcount = pcount;
		this.amount = amount;
		this.location = location;
		this.sbrand = sbrand;
		this.sname = sname;
		this.phone = phone;
		this.price = price;
		this.brand = brand;
	}

	public Store(String location, String sname, String sbrand, String phone, String id) {
		this.location = location;
		this.sname = sname;
		this.sbrand = sbrand;
		this.phone = phone;
		this.id = id;
	}

	public Store(String location, String sname, String sbrand, String phone) {
		this.location = location;
		this.sname = sname;
		this.sbrand = sbrand;
		this.phone = phone;

	}

	public Store(int pno, String gender, int rvcount, int age) {

		this.pno = pno;
		this.gender = gender;
		this.rvcount = rvcount;
		this.age = age;
	}

	public Store(String location, String sname, String sbrand, String phone, String pname, int price, String brand,
			int amount, int sno, int pno) {
		this.location = location;
		this.sname = sname;
		this.sbrand = sbrand;
		this.phone = phone;
		this.pname = pname;
		this.price = price;
		this.brand = brand;
		this.amount = amount;
		this.sno = sno;
		this.pno = pno;
	}

	public Store(String pname, String gender, int age, int rvcount, Date week) {
		this.pname = pname;
		this.gender = gender;
		this.age = age;
		this.rvcount = rvcount;
		this.week = week;
	}

	public Store(String location, String sname, String sbrand, String phone, int amount, String pname, int price,
			String brand) {
		super();
		this.location = location;
		this.sname = sname;
		this.sbrand = sbrand;
		this.phone = phone;
		this.amount = amount;
		this.pname = pname;
		this.price = price;
		this.brand = brand;
	}

	public Store(int pno, String gender, int age, int rvcount, Date week) {
		this.pno = pno;
		this.gender = gender;
		this.age = age;
		this.rvcount = rvcount;
		this.week = week;
	}

	public Store(int rvno, String pname, String id, String gender, int age, int pcount, String location) {
		super();
		this.location = location;
		this.id = id;
		this.rvno = rvno;
		this.pname = pname;
		this.gender = gender;
		this.age = age;
		this.pcount = pcount;
	}

	public int getRvcount() {
		return rvcount;
	}

	public void setRvcount(int rvcount) {
		this.rvcount = rvcount;
	}

	public Date getWeek() {
		return week;
	}

	public void setWeek(Date week) {
		this.week = week;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSbrand() {
		return sbrand;
	}

	public void setSbrand(String sbrand) {
		this.sbrand = sbrand;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getRvno() {
		return rvno;
	}

	public void setRvno(int rvno) {
		this.rvno = rvno;
	}

	public ArrayList<Product> getProductList() {
		return ProductList;
	}

	public void setProductList(ArrayList<Product> productList) {
		ProductList = productList;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPcount() {
		return pcount;
	}

	public void setPcount(int pcount) {
		this.pcount = pcount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCatno() {
		return catno;
	}

	public void setCatno(int catno) {
		this.catno = catno;
	}

}
