package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Store;
import model.User;

public class StoreDAO {

	private JDBCUtil jdbcUtil = null;

	public StoreDAO() {
		jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성
	}

	/**
	 * 예약한 상품이름 보여주기
	 */
	/*
	 * public List<Store> showPname(Store store) throws SQLException { String sql =
	 * "SELECT pname " + "FROM reservation " + "WHERE id = ?";
	 * 
	 * Object[] param = new Object[] {store.getId()};
	 * jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil 에 insert문과 매개 변수 설정
	 * 
	 * try { ResultSet rs = jdbcUtil.executeQuery(); // select 문 실행 List<Store>
	 * resList = new ArrayList<Store>(); while(rs.next()) { Store s = new Store(
	 * rs.getString("pname")); resList.add(s); } return resList; } catch (Exception
	 * ex) { jdbcUtil.rollback(); ex.printStackTrace(); } finally {
	 * jdbcUtil.commit(); jdbcUtil.close(); // resource 반환 } return null; }
	 * 
	 */

	public List<Store> showPname(User user) throws SQLException {
		String sql = "SELECT r.pname, r.pcount, store.location, store.phone, store.sno, r.id "
				+ "FROM reservation r, stock , store " + "WHERE r.id = ? " + "and r.sno = stock.sno "
				+ "and r.pno = stock.pno " + "and stock.sno = store.sno";

		Object[] param = new Object[] { user.getId() };
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil 에 insert문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // select 문 실행
			List<Store> resList = new ArrayList<Store>();
			while (rs.next()) {
				Store s = new Store(rs.getString("pname"), rs.getInt("pcount"), rs.getString("location"),
						rs.getString("phone"), rs.getInt("sno"), rs.getString("id"));
				resList.add(s);
			}
			return resList;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}

	/**
	 * 새로운 가게 생성.
	 */

	public int createStore(Store store) throws SQLException {
		String sql = "INSERT INTO STORE VALUES (sno_seq.nextval, ?, ?, ?, ?, ?)";
		Object[] param = new Object[] { store.getLocation(), store.getSname(), store.getSbrand(), store.getPhone(),
				store.getId() };
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
	 * 예약한 상품 테이블에 삽입.
	 */
	public int InsertRes(Store store) throws SQLException {
		String sql = "INSERT INTO RESERVATION VALUES (rvno_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		Object[] param = new Object[] { store.getSno(), store.getId(), store.getPname(), store.getPno(),
				store.getGender(), store.getAge(), store.getPcount() };

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
	 * 예약 완료 후, 예약 확인 화면에 띄우기 위한 상품 정보 선택
	 */
	public List<Store> showRes(Store store) throws SQLException {
		String sql = "SELECT pname, sbrand, sname, rvno, id, pcount "
				+ "FROM (reservation JOIN store USING(sno)) rv JOIN product USING(pno) "
				+ "WHERE id = ? AND rvno = rvno_seq.currval";

		Object[] param = new Object[] { store.getId() };
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil 에 insert문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // select 문 실행
			List<Store> resList = new ArrayList<Store>();
			while (rs.next()) {
				Store s = new Store(rs.getString("sname"), rs.getString("sbrand"), rs.getString("id"),
						rs.getInt("rvno"), rs.getString("pname"), rs.getInt("pcount"));
				resList.add(s);
			}
			return resList;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}

	/**
	 * 우리 매장 재고 확인
	 */
	public List<Store> LookupOurStore(Store store) throws SQLException {
		String sql = "SELECT s.sno, st.pno, st.pname, st.amount " + "FROM store s , master m, stock st "
				+ "WHERE s.id = m.id AND s.sno = st.sno AND m.id = ?";

		jdbcUtil.setSqlAndParameters(sql, new Object[] { store.getId() }); // JDBCUtil 에 insert문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // select 문 실행
			List<Store> stockList = new ArrayList<Store>();
			while (rs.next()) {
				Store s = new Store(rs.getInt("sno"), rs.getInt("pno"), rs.getString("pname"), rs.getInt("amount"));
				stockList.add(s);
			}
			return stockList;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}

	public int InsertStatistic(Store store) throws SQLException {
		String sql = "Insert into statistic (pno, gender, rvcount, age, week) values(?,?,?,?, SYSDATE) ";
		jdbcUtil.setSqlAndParameters(sql,
				new Object[] { store.getPno(), store.getGender(), store.getRvcount(), store.getAge() });

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

	// 제품 검색
	public List<Store> SearchProduct(Store prod) throws SQLException {
		String sql = "SELECT sno, pno, location, sname, sbrand, phone, a.pname, price, brand, amount "
				+ "FROM store st JOIN (SELECT sno, amount, p.pno, p.pname, price, brand, count, catno "
				+ "FROM stock s JOIN product p " + "ON s.pno = p.pno " + "WHERE p.pname LIKE ?) a " + "USING (sno) "
				+ "WHERE a.amount >= 0 AND a.catno = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { prod.getPname(), prod.getCatno() });

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Store> searchProductList = new ArrayList<Store>();
			while (rs.next()) {
				Store st = new Store(rs.getString("location"), rs.getString("sname"), rs.getString("sbrand"),
						rs.getString("phone"), rs.getString("pname"), rs.getInt("price"), rs.getString("brand"),
						rs.getInt("amount"), rs.getInt("sno"), rs.getInt("pno"));

				searchProductList.add(st);
			}
			return searchProductList;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public int supdate(Store store) throws SQLException {
		String sql = "UPDATE store " + "SET location=?, sname=?, sbrand=?, phone=? " + "WHERE id=?";
		Object[] param = new Object[] { store.getLocation(), store.getSname(), store.getSbrand(), store.getPhone(),
				store.getId() };
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil�� update���� �Ű� ���� ����

		try {
			int result = jdbcUtil.executeUpdate(); // update �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource ��ȯ
		}
		return 0;
	}

	public Store findStore(String id) throws SQLException {
		String sql = "SELECT * " + "FROM store " + "WHERE id = ?";

		Object[] param = new Object[] { id };
		jdbcUtil.setSqlAndParameters(sql, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();

			while (rs.next()) {
				Store store = new Store(rs.getString("location"), rs.getString("sname"), rs.getString("sbrand"),
						rs.getString("phone"));

				return store;
			}
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}

	public List<Store> SelectStatistic() throws SQLException {
		String sql = "select pno, gender, COUNT(pcount) as rvcount, " + "(case when age >= 50 then 50 "
				+ "when age >= 40 then 40 " + "when age >= 30 then 30 " + "when age >= 20 then 20 "
				+ "when age >= 10 then 10 " + "when age >= 0 then 1 " + "else 50 end) \"age\" " + "FROM reservation "
				+ "GROUP BY age, gender, pno";
		jdbcUtil.setSqlAndParameters(sql, null); // JDBCUtil 에 insert문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // select 문 실행
			List<Store> statisticList = new ArrayList<Store>();
			while (rs.next()) {
				Store s = new Store(rs.getInt("pno"), rs.getString("gender"), rs.getInt("rvcount"), rs.getInt("age"));
				statisticList.add(s);
			}
			return statisticList;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}

	public List<Store> showReservation(Store store) throws SQLException {
		String sql = "SELECT * " + "FROM reservation" + "WHERE sno = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { store.getSno() });

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Store> researchList = new ArrayList<Store>();
			while (rs.next()) {
				Store s = new Store(rs.getInt("rvno"), rs.getInt("sno"), rs.getString("pname"), rs.getString("id"),
						rs.getString("gender"), rs.getInt("age"), rs.getInt("pcount"));

				researchList.add(s);
			}
			return researchList;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	// 통계 table 보기
	public List<Store> showStatistic(int age, String gender) throws SQLException {
		String sql = "SELECT rownum, pname, rvcount " + "FROM (SELECT pname, rvcount, age, gender "
				+ "FROM statistic join product using(pno) " + "WHERE age=? and gender=? " + "ORDER BY rvcount DESC) "
				+ "WHERE ROWNUM <= 5";

		jdbcUtil.setSqlAndParameters(sql, new Object[] { age, gender });

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Store> statisticList = new ArrayList<Store>();
			while (rs.next()) {
				Store st = new Store();
				st.setPname(rs.getString("pname"));
				st.setRvcount(rs.getInt("rvcount"));

				statisticList.add(st);
			}
			return statisticList;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public boolean UpdateCount(Store prod) throws SQLException {
		String sql2 = "UPDATE product SET count = count + 1 where pname = ? ";
		jdbcUtil.setSqlAndParameters(sql2, new Object[] { prod.getPname() });

		try {
			jdbcUtil.executeUpdate();
			return true;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return false;
	}

	public Store minusStock(Store store) throws SQLException {
		String sql = "UPDATE stock " + "SET amount = amount - 1 " + "WHERE sno = ? AND pno = ? ";
		Object[] param = new Object[] { store.getSno(), store.getPno() };
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil 에 insert문과 매개 변수 설정

		try {
			int result = jdbcUtil.executeUpdate();
			store.setAmount(store.getAmount() - 1);// insert 문 실행

			if (result == 1) {
				return store;
			}
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}

	// 예약 삭제 (재고 수량 ++)
	public Store plusStock(Store store) throws SQLException {
		String sql = "UPDATE stock " + "SET amount = amount + 1 " + "WHERE sno = ? AND pname = ? ";
		Object[] param = new Object[] { store.getSno(), store.getPname() };
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil 에 insert문과 매개 변수 설정

		try {
			int result = jdbcUtil.executeUpdate();
			store.setAmount(store.getAmount() + 1);// insert 문 실행

			if (result == 1) {
				return store;
			}
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}

	// 예약 삭제 (reservation table에서 삭제)
	public Store deleteRes(Store store) throws SQLException {
		String sql = "DELETE reservation " + "WHERE id = ? AND pname = ?";
		Object[] param = new Object[] { store.getId(), store.getPname() };
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil 에 insert문과 매개 변수 설정

		try {
			int result = jdbcUtil.executeUpdate();

			if (result == 1) {
				return store;
			}
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}

	public List<Store> showReservation(String id) throws SQLException {
		String sql = "select rvno, pname, reservation.id as userid, gender, age, pcount, location "
				+ "from reservation join store using(sno) " + "where store.id = ?";

		jdbcUtil.setSqlAndParameters(sql, new Object[] { id });

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Store> reservationList = new ArrayList<Store>();
			while (rs.next()) {
				Store s = new Store(rs.getInt("rvno"), rs.getString("pname"), rs.getString("userid"),
						rs.getString("gender"), rs.getInt("age"), rs.getInt("pcount"), rs.getString("location"));

				reservationList.add(s);
			}
			return reservationList;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public int UpdateStockAmount(Store store) throws SQLException {
		String sql = "UPDATE stock " + "SET amount = ? " + "WHERE sno = ? and pno = ?";
		Object[] param = new Object[] { store.getAmount(), store.getSno(), store.getPno() };
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

	public int DeleteStock(Store store) throws SQLException {
		String sql = "DELETE FROM stock WHERE sno = ? AND pno = ?";

		Object[] param = new Object[] { store.getSno(), store.getPno() };
		jdbcUtil.setSqlAndParameters(sql, param);

		try {
			int result = jdbcUtil.executeUpdate();
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

	public int findStock(Store store) throws SQLException {
		String sql = "SELECT pno " + "FROM product " + "WHERE pname = ?";

		Object[] param = new Object[] { store.getPname() };
		jdbcUtil.setSqlAndParameters(sql, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			int pno = 0;

			while (rs.next())
				pno = rs.getInt("pno");

			return pno;

		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return 0;
	}

	public int InsertStock(Store store) throws SQLException {
		String sql = "INSERT INTO stock (sno, pno, pname, amount) VALUES(?, ?, ?, ?)";

		Object[] param = new Object[] { store.getSno(), store.getPno(), store.getPname(), store.getAmount() };
		jdbcUtil.setSqlAndParameters(sql, param);

		try {
			int result = jdbcUtil.executeUpdate();
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

}
