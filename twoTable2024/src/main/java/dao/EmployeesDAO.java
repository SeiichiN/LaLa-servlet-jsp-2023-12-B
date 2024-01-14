package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import model.dept.Dept;

public class EmployeesDAO {
	
	private final String SQL_FIND_ALL =
					"SELECT " +
					"   e.id AS id, " + 
					"   e.name AS name, " + 
					"   e.age AS age, " + 
					"   d.id AS did, " + 
					"   d.name AS dname " + 
					" FROM employees e " + 
					"   LEFT OUTER JOIN dept d " + 
					"   ON e.dept_id = d.id " + 
					" ORDER BY e.id";
	private final String SQL_EXISTS_ID =
			"SELECT id FROM employees WHERE id = ?";
	
	private final String SQL_CREATE =
			"INSERT INTO employees "
			+ " (id, name, age, dept_id) "
			+ " VALUES (?, ?, ?, ?)";
	
	private final String SQL_FIND_BY_ID =
			"SELECT "
			+ "   e.id AS id, "
			+ "   e.name AS name, "
			+ "   e.age AS age, "
			+ "   d.id AS did, "
			+ "   d.name AS dname "
			+ " FROM employees e "
			+ "   LEFT OUTER JOIN dept d "
			+ "   ON e.dept_id = d.id "
			+ " WHERE "
			+ "    e.id = ?";
	
	private final String SQL_UPDATE =
			"UPDATE employees "
			+ " SET "
			+ "   name = ?, "
			+ "    age = ?, "
			+ "    dept_id = ? "
			+ " WHERE "
			+ "    id = ?";
	
	public List<Employee> findAll() {
		List<Employee> empList = new ArrayList<>();
		DBConnect.registerDriver();
		try (Connection conn = DriverManager.getConnection
				(DBConnect.JDBC_URL, DBConnect.DB_USER, DBConnect.DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_ALL);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String did = rs.getString("did");
				String dname = rs.getString("dname");
				Dept dept = new Dept(did, dname);
				Employee emp = new Employee(id, name, age, dept);
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;
	}
	
	public Employee findById(String id) {
		Employee emp = null;
		DBConnect.registerDriver();
		try (Connection conn = DriverManager.getConnection
				(DBConnect.JDBC_URL, DBConnect.DB_USER, DBConnect.DB_PASS)) {
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_BY_ID);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String did = rs.getString("did");
				String dname = rs.getString("dname");
				Dept dept = new Dept(did, dname);
				emp = new Employee(id, name, age, dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return emp;
	}
	
	/**
	 * そのIDが存在しているかを調べる
	 * @param id
	 * @return true -- 存在している<br>
	 *          false -- 存在していない
	 */
	public boolean isExistsId(String id) {
		DBConnect.registerDriver();
		try (Connection conn = DriverManager.getConnection
				(DBConnect.JDBC_URL, DBConnect.DB_USER, DBConnect.DB_PASS)) {

			PreparedStatement pStmt = conn.prepareStatement(SQL_EXISTS_ID);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}		
		return false;
	}

	public boolean create(Employee emp) {
		DBConnect.registerDriver();
		try (Connection conn = DriverManager.getConnection
				(DBConnect.JDBC_URL, DBConnect.DB_USER, DBConnect.DB_PASS)) {

			PreparedStatement pStmt = conn.prepareStatement(SQL_CREATE);
			pStmt.setString(1, emp.getId());
			pStmt.setString(2, emp.getName());
			pStmt.setInt(3, emp.getAge());
			pStmt.setString(4, emp.getDept().getId());
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
	
	public boolean update(Employee emp) {
		DBConnect.registerDriver();
		try (Connection conn = DriverManager.getConnection
				(DBConnect.JDBC_URL, DBConnect.DB_USER, DBConnect.DB_PASS)) {

			PreparedStatement pStmt = conn.prepareStatement(SQL_UPDATE);
			pStmt.setString(1, emp.getName());
			pStmt.setInt(2, emp.getAge());
			pStmt.setString(3, emp.getDept().getId());
			pStmt.setString(4, emp.getId());
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
