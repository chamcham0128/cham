package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

/**
 * 사용자 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스 USERINFO 테이블에 사용자 정보를 추가, 수정, 삭제, 검색 수행
 */
public class UserDAO {
	private JDBCUtil jdbcUtil = null;

	public UserDAO() {
		jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성
	}

	/**
	 * 사용자 ID에 해당하는 사용자를 삭제.
	 */
	public int cremove(String userId) throws SQLException {
		String sql = "DELETE FROM customer WHERE id=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { userId }); // JDBCUtil에 delete문과 매개 변수 설정

		try {
			int result = jdbcUtil.executeUpdate(); // delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return 0;
	}

	/**
	 * 사용자 ID에 해당하는 사용자(업주)를 삭제.
	 */
	public int mremove(String userId) throws SQLException {
		String sql = "DELETE FROM master WHERE id=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { userId }); // JDBCUtil에 delete문과 매개 변수 설정

		try {
			int result = jdbcUtil.executeUpdate(); // delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return 0;
	}

	/**
	 * 기존의 사용자 정보를 수정.
	 */
	public int cupdate(User user) throws SQLException {
		String sql = "UPDATE customer "
				+ "SET name=?, phone=?, pwd=?, email=?, birth=TO_DATE(?, 'YYYY-MM-DD'), gender=? " + "WHERE id=?";
		Object[] param = new Object[] { user.getName(), user.getPhone(), user.getPwd(), user.getEmail(),
				user.getBirth(), user.getGender(), user.getId() };
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil에 update문과 매개 변수 설정
		System.out.println(user.getPhone());
		try {
			int result = jdbcUtil.executeUpdate(); // update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return 0;
	}

	/**
	 * 기존의 마스터 정보를 수정.
	 */
	public int mupdate(User user) throws SQLException {
		String sql = "UPDATE master "
				+ "SET name=?, phone=?, pwd=?, email=?, birth=TO_DATE(?, 'YYYY-MM-DD'), licenseno=? " + "WHERE id=?";
		Object[] param = new Object[] { user.getName(), user.getPhone(), user.getPwd(), user.getEmail(),
				user.getBirth(), user.getLicenseNo(), user.getId() };
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil에 update문과 매개 변수 설정

		try {
			int result = jdbcUtil.executeUpdate(); // update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return 0;
	}

	/**
	 * CUSTOMER 테이블에 새로운 사용자(소비자) 생성.
	 */
	public int createCustomer(User user) throws SQLException {
		String sql = "INSERT INTO customer VALUES (?, ?, ?, ?, ?, ?, TO_DATE(? , 'YYYY-MM-DD'))";
		Object[] param = new Object[] { user.getId(), user.getGender(), user.getName(), user.getPhone(), user.getPwd(),
				user.getEmail(), user.getBirth() };
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil 에 insert문과 매개 변수 설정

		try {
			int result = jdbcUtil.executeUpdate(); // insert 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return 0;
	}

	/**
	 * MASTER 테이블에 새로운 사용자(업주) 생성.
	 */
	public int createMaster(User user) throws SQLException {
		String sql = "INSERT INTO master (id, licenseno, name, phone, pwd, email, birth) VALUES (?, ?, ?, ?, ?, ?, TO_DATE(? , 'YYYY-MM-DD'))";
		Object[] param = new Object[] { user.getId(), user.getLicenseNo(), user.getName(), user.getPhone(),
				user.getPwd(), user.getEmail(), user.getBirth() };
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil 에 insert문과 매개 변수 설정

		try {
			int result = jdbcUtil.executeUpdate(); // insert 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return 0;
	}

	/**
	 * 사용자(소비자) 정보를 검색하여 List에 저장 및 반환
	 */
	public User findcustomer(String userId) throws SQLException {
		String sql = "SELECT * " + "FROM customer " + "WHERE ID = ?";

		Object[] param = new Object[] { userId };
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil에 query문 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			while (rs.next()) {
				User customer = new User( // User 객체를 생성하여 현재 행의 정보를 저장
						rs.getString("id"), rs.getString("name"), rs.getString("phone"), rs.getString("pwd"),
						rs.getString("email"), rs.getString("birth"), rs.getString("gender"));
				return customer;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}

	/**
	 * 사용자(업주) 정보를 검색하여 List에 저장 및 반환
	 */
	public User findmaster(String userId) throws SQLException {
		String sql = "SELECT * " + "FROM master " + "WHERE id = ?";

		Object[] param = new Object[] { userId };
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil에 query문 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			while (rs.next()) {
				User master = new User( // User 객체를 생성하여 현재 행의 정보를 저장
						rs.getString("id"), rs.getString("name"), rs.getString("phone"), rs.getString("pwd"),
						rs.getString("birth"), rs.getString("licenseNo"), rs.getString("email"), 0);
				return master;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}

	/**
	 * 주어진 사용자 ID에 해당하는 업주가 존재하는지 검사
	 */
	public boolean existingMuser(String id) throws SQLException {
		String sql = "SELECT count(*) FROM master WHERE id=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { id }); // JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource 반환
		}
		return false;
	}

	/**
	 * 주어진 사용자 ID에 해당하는 customer가 존재하는지 검사
	 */
	public boolean existingCuser(String id) throws SQLException {
		String sql = "SELECT count(*) FROM customer WHERE id=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { id }); // JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource 반환
		}
		return false;
	}

}
