package Hospital_InventoryJDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import Hospital_InventoryPOJO.Distribuitor;
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
			String sql = "INSERT INTO doctor (name, department, email) VALUES (?,?,?)";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setString(1, d.getName());
			prep.setString(2, d.getDepartment());
			prep.setString(3, d.getEmail());
			prep.executeUpdate();
					
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Doctor> getListDoctor() {
		// TODO Auto-generated method stub
		List<Doctor> doctors = new ArrayList<Doctor>();
		
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql = "SELECT * FROM doctor";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Integer id = rs.getInt("doctor_id");
				String name = rs.getString("name");
				String department = rs.getString("department");
				String email = rs.getString("email");
				
				Doctor d = new Doctor(id,name, department, email);
				doctors.add(d);
			}
			
			rs.close();
			stmt.close();	
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return doctors;
	}

	@Override
	public void removeDoctor(int id) {
		// TODO Auto-generated method stub
		try {
			
			String sql = "DELETE FROM doctor WHERE doctor_id=?;";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setInt(1,id);
			prep.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateDepartment(int doctor_id, String department) {
		// TODO Auto-generated method stub
		
		try {
			
			String sql = "UPDATE Doctor SET department=? WHERE doctor_id=?;";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setString(1, department);
			prep.setInt(2, doctor_id);
			
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
			String sql = "SELECT * FROM doctor WHERE doctor_id=" + id;
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
