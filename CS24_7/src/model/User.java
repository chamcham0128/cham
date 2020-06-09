package model;

import java.sql.SQLException;
import java.util.Calendar;

import model.service.PasswordMismatchException;
import model.service.UserNotFoundException;

public class User {
	private String id; // 아이디
	private String name; // 이름
	private String phone; // 전화번호
	private String pwd; // 비밀번호
	private String email; // 이메일
	private String birth; // 생년월일
	private String gender; // 성별
	private String licenseNo; // 사업자등록번호
	private int num;

	public User() {
		super();
	} // 기본 생성자

	public User(String id, String name, String phone, String pwd, String email, String birth, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.pwd = pwd;
		this.email = email;
		this.birth = birth;
		this.gender = gender;
	} // 소비자 생성자

	public User(String id, String name, String phone, String pwd, String birth, String licenseNo, String email,
			int num) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.pwd = pwd;
		this.birth = birth;
		this.licenseNo = licenseNo;
		this.email = email;
		this.num = num;
	} // 업주 생성자

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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	/* 비밀번호 검사 */
	public boolean matchPassword(String pwd) {
		if (pwd == null) {
			return false;
		}
		return this.pwd.equals(pwd);
	}

	public boolean isSameUser(String id) {
		return this.id.equals(id);
	}

	/* 나이 계산 */
	public static int calAge(String birth) {
		String[] birthday = birth.split("-");
		int year = Integer.parseInt(birthday[0]);

		Calendar cal = Calendar.getInstance();

		int age = cal.get(Calendar.YEAR) - year + 1;

		return age;
	}

	public User findUser(String userId) throws SQLException, UserNotFoundException {
		User user = findUser(userId);

		if (user == null) {
			throw new UserNotFoundException(userId + "는 존재하지 않는 아이디입니다.");
		}
		return user;
	}

	public boolean login(String userId, String password)
			throws SQLException, UserNotFoundException, PasswordMismatchException {
		User user = findUser(userId);

		if (!user.matchPassword(password)) {
			throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
		}
		return true;
	}
}
