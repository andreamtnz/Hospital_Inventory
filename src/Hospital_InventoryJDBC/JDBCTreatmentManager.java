package Hospital_InventoryJDBC;

import java.sql.PreparedStatement;
import java.util.List;

import Hospital_InventoryPOJO.Materials;
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
		return null;
	}

	@Override
	public void assignDoctor(int doctor_id, int treatment_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignNurse(int nurse_id, int treatment_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignToTreatment(Materials m, Treatment t, Integer q) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Treatment getTreatmentById(int treatment_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
