package dao;

public class DBConnect {
	static final String JDBC_URL = 
			"jdbc:h2:tcp://localhost/~/twoTables";
	static final String DB_USER = "sa";
	static final String DB_PASS = "";

	static void registerDriver() {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException
			    ("JDBCドライバーが見つかりません");
		}
	}
}
