package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dept.Dept;

public class DeptDAO {
	private final String SQL_FIND_ALL =
					"SELECT id, name FROM dept ORDER BY id";
	
	private final String SQL_EXISTS_DEPT_ID =
			"SELECT id FROM dept WHERE id = ?";
	
	private final String SQL_FIND_BY_ID =
			"SELECT name FROM dept WHERE id = ?";

	private final String SQL_CREATE =
			"INSERT INTO dept (id, name) VALUES (?, ?)";
	
	public List<Dept> findAll() {
		List<Dept> deptList = new ArrayList<>();
		DBConnect.registerDriver();
		try (Connection conn = DriverManager.getConnection
				(DBConnect.JDBC_URL, DBConnect.DB_USER, DBConnect.DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_ALL);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				Dept dept = new Dept(id, name);
				deptList.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return deptList;
	}

	/**
	 * 部署IDがすでに存在しているかを調べる
	 * @param id
	 * @return true -- すでに存在している<br>
	 *         false -- 存在していない
	 */
	public boolean isExistsId(String id) {
		DBConnect.registerDriver();
		try (Connection conn = DriverManager.getConnection
				(DBConnect.JDBC_URL, DBConnect.DB_USER, DBConnect.DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_EXISTS_DEPT_ID);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public String findNameById(String id) {
		String name = null;
		try (Connection conn = DriverManager.getConnection
				(DBConnect.JDBC_URL, DBConnect.DB_USER, DBConnect.DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_BY_ID);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				name = rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return name;
	}
	
	public boolean create(Dept dept) {
		try (Connection conn = DriverManager.getConnection
				(DBConnect.JDBC_URL, DBConnect.DB_USER, DBConnect.DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_CREATE);
			pStmt.setString(1, dept.getId());
			pStmt.setString(2, dept.getName());
		    int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
