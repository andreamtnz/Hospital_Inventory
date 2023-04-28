package Hospital_InventoryJDBC;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCManager {

	private Connection c = null;

	public JDBCManager() {
		
		try 
		{			
			// Open the DB connection
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:./db/proyecto.db");
			System.out.println("Database connection opened.");
			
			//create tables
			this.createTables();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			System.out.print("Libraries not loaded");
		}
	}
	
	private void createTables() {
		// Create Tables
		try {
		Statement stmt = c.createStatement();
		String sql = "CREATE TABLE administrator ("
		+ "	id	    INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ "	name	TEXT NOT NULL,"
		+ ");";
		stmt.executeUpdate(sql);
		sql = "CREATE TABLE material ("
		+ "	id	    INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ "	name	TEXT NOT NULL,"
		+ "	type	TEXT NOT NULL,"
		+ "	stock	INTEGER,"
		+ "	price	FLOAT,"
		+ "	distributorID	INTEGER NOT NULL REFERENCES distributor(id) ON DELETE RESTRICT"
		+ ");";
		stmt.executeUpdate(sql);
		sql = "CREATE TABLE distributor ("
		+ "	id	    INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ "	name	TEXT NOT NULL,"
		+ "	type	TEXT NOT NULL"
		+ ");";
		stmt.executeUpdate(sql);
		sql = "CREATE TABLE doctor ("
		+ "	id	    INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ "	name	TEXT NOT NULL,"
		+ "	department	TEXT NOT NULL"
		+ ");";
		stmt.executeUpdate(sql);
		sql = "CREATE TABLE nurse ("
		+ "	id	    INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ "	name	TEXT NOT NULL,"
		+ "	department	TEXT NOT NULL"
		+ ");";
		stmt.executeUpdate(sql);
		sql = "CREATE TABLE treatment ("
		+ "	id	    INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ "	name	TEXT NOT NULL,"
		+ " date    DATE,"
		+ " time    TEXT,"
		+ "	patient	TEXT,"
		+ ");";
		stmt.executeUpdate(sql);
		sql = "CREATE TABLE order ("
		+ "	id	    INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ "	state	TEXT NOT NULL,"
		+ " date    DATE,"
		+ " cost    FLOAT,"
		+ " administratorID	INTEGER NOT NULL REFERENCES administrator(id) ON DELETE RESTRICT"
		+ ");";
		stmt.executeUpdate(sql);
		sql = "CREATE TABLE has ("
		+ "	materialID	INTEGER,"
		+ "	orderID	INTEGER,"
		+ " quantity INTEGER,"
		+ "	FOREIGN KEY(materialID) REFERENCES material(id) ON DELETE CASCADE,"
		+ "	FOREIGN KEY(orderID) REFERENCES order(id) ON DELETE CASCADE,"
		+ "	PRIMARY KEY(materialID,orderID)\r\n"
		+ ");";
		stmt.executeUpdate(sql);
		sql = "CREATE TABLE needs ("
		+ "	treatmentID	INTEGER,"
		+ "	materialID	INTEGER,"
		+ " quantity    INTEGER,"
		+ "	FOREIGN KEY(treatmentID) REFERENCES treatment(id) ON DELETE CASCADE,"
		+ "	FOREIGN KEY(materialID) REFERENCES material(id) ON DELETE CASCADE,"
		+ "	PRIMARY KEY(treatmentID,materialID)\r\n"
		+ ");";
		stmt.executeUpdate(sql);
		sql = "CREATE TABLE perform ("
		+ "	nurseID	INTEGER,"
		+ "	treatmentID	INTEGER,"
		+ "	FOREIGN KEY(nurseID) REFERENCES nurse(id) ON DELETE CASCADE,"
		+ "	FOREIGN KEY(treatmentID) REFERENCES treatment(id) ON DELETE CASCADE,"
		+ "	PRIMARY KEY(nurseID,treatmentID)\r\n"
		+ ");";
		stmt.executeUpdate(sql);
		sql = "CREATE TABLE request ("
		+ "	doctorID	INTEGER,"
		+ "	treatmentID	INTEGER,"
		+ "	FOREIGN KEY(doctorID) REFERENCES doctor(id) ON DELETE CASCADE,"
		+ "	FOREIGN KEY(treatmentID) REFERENCES treatment(id) ON DELETE CASCADE,"
		+ "	PRIMARY KEY(doctorID,treatmentID)\r\n"
		+ ");";
		stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// Do not complain if tables already exist
			if (!e.getMessage().contains("already exists")) {
				e.printStackTrace();
			}
		}
	}
	
	public Connection getConnection() {
		
		return c;
	}
	
	public void disconnect()
	{		
		try {
			c.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();			
		}
	}
}
