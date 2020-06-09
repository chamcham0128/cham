package model;

public class Product {
	private int pno;
	private int catno;
	private String pname;
	private int price;
	private String brand;
	private int count;
	private String catname;
	private int age;
	private String gender;
	private int rvcount;
	private String week;
	private int rno;
	private String content;
	private float gpa;
	private String id;

	public Product() {
		super();
	} // 奄沙 持失切

	public Product(String pname, int count, int catno) {
		super();
		this.pname = pname;
		this.count = count;
		this.catno = catno;
	}

	public Product(String id, int pno) {
		super();
		this.id = id;
		this.pno = pno;
	} // review 持失切2 /* 呪舛 */

	public Product(int catno, String catname) {
		super();
		this.catno = catno;
		this.catname = catname;
	} // category 持失切

	public Product(int pno, String content, float gpa, String id) {
		this.pno = pno;
		this.content = content;
		this.gpa = gpa;
		this.id = id;
	}

	public Product(int pno, int catno, String pname, int price, String brand, int count) {
		super();
		this.pno = pno;
		this.catno = catno;
		this.pname = pname;
		this.price = price;
		this.brand = brand;
		this.count = count;
	} // product 持失切

	public Product(int pno, int age, String gender, int rvcount, String week) {
		super();
		this.pno = pno;
		this.age = age;
		this.gender = gender;
		this.rvcount = rvcount;
		this.week = week;
	} // statistic 持失切

	public Product(int pno, int rno, String content, float gpa, String id) {
		super();
		this.pno = pno;
		this.rno = rno;
		this.content = content;
		this.gpa = gpa;
		this.id = id;
	} // review 持失切

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getRvcount() {
		return rvcount;
	}

	public void setRvcount(int rvcount) {
		this.rvcount = rvcount;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public int getCatno() {
		return catno;
	}

	public void setCatno(int catno) {
		this.catno = catno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
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

	@Override
	public String toString() {
		return "Product [pno=" + pno + ", catno=" + catno + ", pname=" + pname + ", price=" + price + ", brand=" + brand
				+ ", count=" + count + "]";
	}

}