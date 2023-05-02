package Hospital_InventoryJDBC;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Hospital_InventoryPOJO.Doctor;
import Hospital_InventoryPOJO.Nurse;
import Hospital_InventoryPOJO.Materials;
import Hospital_InventoryPOJO.Order;
import Hospital_InventoryPOJO.Treatment;
import Hospital_inventoryInterfaces.TreatmentManager;


public class JDBCTreatmentManager implements TreatmentManager{
	
	private JDBCManager manager;
	
	public JDBCTreatmentManager(JDBCManager manager) {
		this.manager = manager;
	}

	@Override
	public void addTreatment(Treatment t) {
		// TODO Auto-generated method stub
		try{
			String sql = "INSERT INTO treatment (name, date, time, patient) VALUES (?,?,?,?)";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setString(1, t.getName());
			prep.setDate(2, t.getDate());
			prep.setString(3, t.getTime());
			prep.setString(4, t.getPatient());

			prep.executeUpdate();
			System.out.println("Treatment added");
					
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Treatment> getListTreatments() {
		// TODO Auto-generated method stub
		List<Treatment> treatments = new ArrayList<Treatment>();
		
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql = "SELECT * FROM treatment";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				Date date = rs.getDate("date");
				String time = rs.getString("time");
				String patient = rs.getString("patient");
				List<Doctor> doctors = new ArrayList<Doctor>();
				doctors = getDoctorsInTreatment(id);
				List <Nurse> nurses = new ArrayList<Nurse>();
				nurses = getNursesInTreatment(id);
				
				Treatment t = new Treatment(id, name, date, time, patient, doctors, nurses);
				treatments.add(t);
			}
			
			rs.close();
			stmt.close();	
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return treatments;
	}

	@Override
	public List<Doctor> getDoctorsInTreatment(int treatment_id){
		List<Doctor> doctors = new ArrayList<Doctor>();
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql = "SELECT * FROM doctor AND requests WHERE id=" + treatment_id;
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Integer doctor_id = rs.getInt("doctor_id");
				String name = rs.getString("name");
				String department = rs.getString("department");
				String email = rs.getString("email");
				Doctor d = new Doctor(doctor_id, name,department, email);		
				
				doctors.add(d);
			}
			rs.close();
			stmt.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return doctors;
	}
	
	@Override
	public List<Nurse> getNursesInTreatment(int treatment_id){
		List<Nurse> nurses = new ArrayList<Nurse>();
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql = "SELECT * FROM nurse AND performs WHERE id=" + treatment_id;
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Integer nurse_id = rs.getInt("nurse_id");
				String name = rs.getString("name");
				String department = rs.getString("department");
				String email = rs.getString("email");
				Nurse n = new Nurse(nurse_id, name,department, email);		
				
				nurses.add(n);
			}
			rs.close();
			stmt.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return nurses;
	}
	
	
	@Override
	public void assignDoctor(int doctor_id, int treatment_id) {
		// TODO Auto-generated method stub
		try{
			String sql = "INSERT INTO examines (doctor_id,treatment_id) VALUES (?,?)";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setInt(1, doctor_id);
			prep.setInt(2, treatment_id);		
			
			prep.executeUpdate();			
					
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void assignNurse(int nurse_id, int treatment_id) {
		// TODO Auto-generated method stub
		try{
			String sql = "INSERT INTO performs (nurse_id,treatment_id) VALUES (?,?)";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setInt(1, nurse_id);
			prep.setInt(2, treatment_id);		
			
			prep.executeUpdate();			
					
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void assignToTreatment(Materials m, Treatment t, Integer q) {
		// TODO Auto-generated method stub
		try{
			String sql = "INSERT INTO needs (treatmentID,materialID, quantity) VALUES (?,?,?)";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setInt(1, t.getId());
			prep.setInt(2, m.getId());	
			prep.setInt(3, q);		

			
			prep.executeUpdate();			
					
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Treatment getTreatmentById(int treatment_id) {
		// TODO Auto-generated method stub
		Treatment t = null;
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql = "SELECT * FROM doctor WHERE id=" + treatment_id;
			ResultSet rs = stmt.executeQuery(sql);
			
				String name = rs.getString("name");
				Date date = rs.getDate("date");
				String time = rs.getString("time");
				String patient = rs.getString("email");
				t = new Treatment(treatment_id, name,date, time, patient);				
			
			rs.close();
			stmt.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return t;
	}

	@Override
	public void removeTreatment(int id) {
		// TODO Auto-generated method stub
		try {
			
			String sql = "DELETE FROM treatment WHERE id=?;";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setInt(1,id);
			prep.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	


}
