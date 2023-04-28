package Hospital_InventoryJDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import Hospital_InventoryPOJO.Doctor;
import Hospital_inventoryInterfaces.DoctorManager;

public class JDBCDoctorManager implements DoctorManager{
	
	private JDBCManager manager;
	
	public JDBCDoctorManager(JDBCManager manager) {
		this.manager = manager;
	}

	@Override
	public void addDoctor(Doctor d) {
		// TODO Auto-generated method stub
		try{
			String sql = "INSERT INTO doctor (name, department) VALUES (?,?)";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setString(1, d.getName());
			prep.setString(2, d.getDepartment());
			prep.executeUpdate();
			System.out.println("Doctor added");
					
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Doctor> getListDoctor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeDoctor(int id) {
		// TODO Auto-generated method stub
		try {
			
			String sql = "DELETE FROM doctor WHERE id=?;";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setInt(1,id);
			prep.executeUpdate();
			System.out.println("Doctor removed");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateDepartment(int id) {
		// TODO Auto-generated method stub
		String dep = "";
		try {
			System.out.println("Enter the new department:");
			BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
			dep = reader.readLine();
			String sql = "UPDATE doctor SET department=? WHERE id=?;";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setString(1, dep);
			prep.setInt(2, id);
			
			prep.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Doctor getDoctorByID(int id) {
		// TODO Auto-generated method stub
		Doctor d = null;
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql = "SELECT * FROM doctor WHERE id=" + id;
			ResultSet rs = stmt.executeQuery(sql);
			
				String name = rs.getString("name");
				String department = rs.getString("department");
				String email = rs.getString("email");
				d = new Doctor(id, name, department, email);				
			
			rs.close();
			stmt.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return d;
	}
	

}
