package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;

import model.dao.JDBCUtil;

public class ProductDAO {
	private JDBCUtil jdbcUtil = null;

	public ProductDAO() {
		jdbcUtil = new JDBCUtil();
	}

	public Product createProduct(Product prod) throws SQLException {
		String sql = "INSERT INTO product VALUES (pno_seq.nextval, ?, ?, ?, ?, ?)";
		Object[] param = new Object[] { prod.getCatno(), prod.getPname(), prod.getPrice(), prod.getBrand(),
				prod.getCount() };

		jdbcUtil.setSqlAndParameters(sql, param);

		String key[] = { "pno" };
		try {
			jdbcUtil.executeUpdate(key);
			ResultSet rs = jdbcUtil.getGeneratedKeys();
			if (rs.next()) {
				String generatedKey = rs.getString(1);
				prod.setId(generatedKey);
			}
			return prod;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return null;
	}

	/* 수정 */
	public Product createReview(Product prod) throws SQLException {
		String sql = "INSERT INTO Review VALUES (rno_seq.nextval, ?, ?, ?, ?)";
		Object[] param = new Object[] { prod.getGpa(), prod.getContent(), prod.getPno(), prod.getId() };

		jdbcUtil.setSqlAndParameters(sql, param);

		String key[] = { "rno" };
		try {
			jdbcUtil.executeUpdate(key);
			ResultSet rs = jdbcUtil.getGeneratedKeys();
			if (rs.next()) {
				String generatedKey = rs.getString(1);
				prod.setId(generatedKey);
			}
			return prod;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return null;
	}

	public List<Product> calproductRank() throws SQLException {
		String sql = "SELECT rownum, pname , count, catno " + "FROM (SELECT pname, count, catno " + "FROM product "
				+ "ORDER BY count DESC) " + "WHERE ROWNUM <= 5";
		jdbcUtil.setSqlAndParameters(sql, null);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Product> prodRankList = new ArrayList<Product>();

			while (rs.next()) {
				Product rankProd = new Product(rs.getString("pname"), rs.getInt("count"), rs.getInt("catno"));
				prodRankList.add(rankProd);
			}
			return prodRankList;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public boolean existingproduct(String pName) throws SQLException {
		String sql = "SELECT count(*) FROM product WHERE pname=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { pName });

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return false;
	}

	public List<String> searchSimilarProduct(String[] prod) throws SQLException {
		String sql = "SELECT pname " + "FROM product " + "WHERE pname = ?";
		String s = null;
		for (int i = 0; i < prod.length; i++) {
			s = "% " + prod[i];
		}
		s += "%";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { s });

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<String> prodRankList = new ArrayList<String>();
			while (rs.next()) {
				String pName = rs.getString("pname");
				prodRankList.add(pName);
			}
			return prodRankList;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return null;
	}

	// 리뷰 보여주기
	public List<Product> showReview(int pno) throws SQLException {
		String sql = "SELECT * " + "FROM review " + "WHERE pno = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { pno });

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Product> reviewList = new ArrayList<Product>();
			while (rs.next()) {
				Product review = new Product(rs.getInt("pno"), rs.getInt("rno"), rs.getString("content"),
						rs.getFloat("gpa"), rs.getString("id"));
				reviewList.add(review);
			}
			return reviewList;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

}