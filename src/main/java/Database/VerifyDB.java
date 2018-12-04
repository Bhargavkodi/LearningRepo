package Database;

import java.sql.SQLException;

import com.learning.base.TestBase;

public class VerifyDB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//DBTest.updateDBdata();
		Connection C = new Connection();
		//C.getDBData("insert into registration values('2','bhnau12','testing123')");
		C.getDBData("SELECT * FROM playnewdb.Panna_ContactUs");
		//DBTest.selectDBdata();
		
		//insertDBData()
		

	}

}
