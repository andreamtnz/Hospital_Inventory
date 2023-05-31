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
			System.out.println("Tables created.");
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
		+ "	administrator_id	    INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ "	name	TEXT NOT NULL,"
		+ " email   TEXT NOT NULL"
		+ ");";
		stmt.executeUpdate(sql);
		sql = "CREATE TABLE material ("
		+ "	material_id	    INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ "	name	TEXT NOT NULL,"
		+ "	type	TEXT NOT NULL,"
		+ "	stock	INTEGER,"
		+ "	price	FLOAT,"
		+ "	distributor_id	INTEGER NOT NULL REFERENCES distributor(id) ON DELETE RESTRICT"
		+ ");";
		stmt.executeUpdate(sql);
		sql = "CREATE TABLE distributor ("
		+ "	distributor_id	    INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ "	name	TEXT NOT NULL,"
		+ "	type	TEXT NOT NULL"
		+ ");";
		stmt.executeUpdate(sql);
		sql = "CREATE TABLE doctor ("
		+ "	doctor_id	    INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ "	name	TEXT NOT NULL,"
		+ "	department	TEXT NOT NULL,"
		+ " email   TEXT NOT NULL"
		+ ");";
		stmt.executeUpdate(sql);
		sql = "CREATE TABLE nurse ("
		+ "	id	    INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ "	name	TEXT NOT NULL,"
		+ "	department	TEXT NOT NULL,"
		+ " email   TEXT NOT NULL"
		+ ");";
		stmt.executeUpdate(sql);
		sql = "CREATE TABLE treatment ("
		+ "	treatment_id	    INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ "	name	TEXT NOT NULL,"
		+ " date    DATE,"
		+ "	patient	TEXT,"
		+ " time    TEXT,"
		+ ");";
		stmt.executeUpdate(sql);
		sql = "CREATE TABLE order ("
		+ "	order_id	    INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ "	state	TEXT NOT NULL,"
		+ " date    DATE,"
		+ " cost    FLOAT,"
		+ " administrator_id	INTEGER NOT NULL REFERENCES administrator(administrator_id) ON DELETE RESTRICT"
		+ ");";
		stmt.executeUpdate(sql);
		sql = "CREATE TABLE has ("
		+ " has_id INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ "	material_id	INTEGER,"
		+ "	order_id	INTEGER,"
		+ " quantity INTEGER,"
		+ "	FOREIGN KEY(materialID) REFERENCES material(material_id) ON DELETE CASCADE,"
		+ "	FOREIGN KEY(orderID) REFERENCES order(order_id) ON DELETE CASCADE,"
		+ ");";
		stmt.executeUpdate(sql);
		sql = "CREATE TABLE needs ("
		+ " needs_id INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ "	treatment_id	INTEGER,"
		+ "	material_id	INTEGER,"
		+ " quantity    INTEGER,"
		+ "	FOREIGN KEY(treatmentID) REFERENCES treatment(treatment_id) ON DELETE CASCADE,"
		+ "	FOREIGN KEY(materialID) REFERENCES material(material_id) ON DELETE CASCADE,"
		+ ");";
		stmt.executeUpdate(sql);
		sql = "CREATE TABLE perform ("
		+ "	nurseID	INTEGER,"
		+ "	treatmentID	INTEGER,"
		+ "	FOREIGN KEY(nurseID) REFERENCES nurse(id) ON DELETE CASCADE,"
		+ "	FOREIGN KEY(treatmentID) REFERENCES treatment(treatment_id) ON DELETE CASCADE,"
		+ "	PRIMARY KEY(nurseID,treatmentID)\r\n"
		+ ");";
		stmt.executeUpdate(sql);
		sql = "CREATE TABLE request ("
		+ " request_id INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ "	doctor_id	INTEGER,"
		+ "	treatment_id	INTEGER,"
		+ "	FOREIGN KEY(doctor_id) REFERENCES doctor(doctor_id) ON DELETE CASCADE,"
		+ "	FOREIGN KEY(treatment_id) REFERENCES treatment(treatment_id) ON DELETE CASCADE,"
		+ ");";
		stmt.executeUpdate(sql);
		System.out.println("Tables created in java");
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
