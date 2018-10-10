package Database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;



public class Connection {
	static Logger log = Logger.getLogger(Connection.class.getName());

	public java.sql.Connection con;
	public Statement stmt;

	public Statement getStatement() throws ClassNotFoundException, SQLException {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String connection = "jdbc:mysql://play-db.mroads.com:3306/playnewdb";
			String userName = "play";
			String password = "P@ssw0rd123";
			Class.forName(driver);
			con = DriverManager.getConnection(connection, userName, password);
			log.info(con);
			stmt = con.createStatement();
			return stmt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stmt;
	}

	public void insertData(String query) throws ClassNotFoundException, SQLException {
		Statement sta = getStatement();
		sta.executeUpdate(query);
	}

	public ResultSet getData(String query) throws ClassNotFoundException, SQLException {
		ResultSet data = getStatement().executeQuery(query);
		return data;
	}

	public void updateData(String query) throws ClassNotFoundException, SQLException {
		getStatement().executeUpdate(query);

	}

}
