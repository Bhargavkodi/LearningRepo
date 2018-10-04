 package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connectMySQL {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://play-db.mroads.com:3306/playnewdb", "play", "P@ssw0rd123");
		System.out.println("connection established");
		
		Statement s1 = con.createStatement();
		
		
	}

}
