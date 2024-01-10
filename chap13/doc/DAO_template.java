private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/<DB_NAME>";
private final String DB_USER = "sa";
private final String DB_PASS = "";

// DAOファイルのメソッドのテンプレート
{
	try {
		// DriverManagerに org.h2.Driver を登録する
		Class.forName("org.h2.Driver");
	} catch (ClassNotFoundException e) {
		throw new IllegalStateException
			("JDBCドライバの読み込みエラー");
	}
	try (Connection conn = DriverManager.getConnection
			(JDBC_URL, DB_USER, DB_PASS)) {
		String sql = "";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		// pStmt.setString(1, "<VALUE>");
		ResultSet rs = pStmt.executeQuery(); 
		// int result = pStmt.executeUPdate()

	} catch (SQLException e) {
		e.printStackTrace();
		return null;  //return false;
	}
}