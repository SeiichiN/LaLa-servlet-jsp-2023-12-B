package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Dept;
import model.Employee;

public class EmployeesDAO {
	private final String JDBC_URL =
			"jdbc:h2:tcp://localhost/~/twoTables";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
			
	private final String SQL_FIND_ALL =
			"SELECT "
			+ "  e.id AS id, "
			+ "  e.name AS name, "
			+ "  e.age AS age, "
			+ "  d.id AS did, "
			+ "  d.name AS dname "
			+ "FROM employees e "
			+ "  INNER JOIN dept d "
			+ "  ON e.dept_id = d.id "
			+ "ORDER BY e.id";
	

	private void registerDriver() {
		try {
			// DriverManagerに org.h2.Driver を登録する
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException
				("JDBCドライバの読み込みエラー");
		}		
	}
	
	
	public List<Employee> findAll() {
		List<Employee> empList = new ArrayList<>();
		
		registerDriver();
		try (Connection conn = DriverManager.getConnection
				(JDBC_URL, DB_USER, DB_PASS)) {
			
			PreparedStatement pStmt = conn.prepareStatement(SQL_FIND_ALL);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String did = rs.getString("did");
				String dname = rs.getString("dname");
				Dept dept = new Dept(did, dname);
				Employee employee = new Employee(id, name, age, dept);
				empList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;
	}
	
} // class end
