package Database;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;

import org.apache.log4j.Logger;

public class DBTest {
	
	static Logger log = Logger.getLogger(DBTest.class.getName());

	WebDriver driver;

	static String SQL;
	static int phoneNumber = 227299;
	static String rollNumber = "Bhargav";
	static String mailID = "san@yopmail.com";

	public static ResultSet selectDBdata() throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM playnewdb.Panna_ContactUs;";
		String query1 = "SELECT name FROM registration where id=1";
		Connection dataBase = new Connection();
		ResultSet data = dataBase.getData(query);
		System.out.println(data);
		while (data.next()) {
			System.out.println(data.getString(1) + " " + data.getString(2) + " " + data.getString(3));
		}
		return data;
	}

	public void insertDBdata() throws ClassNotFoundException, SQLException {
		String query = "insert into registration values('2','bhnau12','testing123')";
		Connection dataBase = new Connection();
		dataBase.insertData(query);
	}

	public static void updateDBdata() throws ClassNotFoundException, SQLException {

		SQL = "UPDATE Panna_ContactUs SET contact=" + "'" + phoneNumber + "'," + " name=" + "'" + rollNumber
				+ "'" + " WHERE email=" + "'" + mailID + "'";

		//String query = "update registration set name='56777' where profession='testing123'";
		Connection dataBase = new Connection();
		dataBase.updateData(SQL);
		log.info("Suceessfully executed querry "+SQL);

	}
	

}
