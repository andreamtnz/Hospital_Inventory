package Hospital_InventoryJDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import Hospital_InventoryPOJO.Doctor;
import Hospital_InventoryPOJO.Nurse;
import Hospital_inventoryInterfaces.NurseManager;

public class JDBCNurseManager implements NurseManager{
	
	private JDBCManager manager;
	
	public JDBCNurseManager(JDBCManager manager) {
		this.manager = manager;
	}

	@Override
	public void addNurse(Nurse n) {
		// TODO Auto-generated method stub
		try{
			String sql = "INSERT INTO nurse (name, department) VALUES (?,?)";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setString(1, n.getName());
			prep.setString(2, n.getDepartment());
			prep.executeUpdate();
			System.out.println("Nurse added");
					
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Nurse> getListNurse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeNurse(int id) {
		// TODO Auto-generated method stub
		try {
			
			String sql = "DELETE FROM nurse WHERE id=?;";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setInt(1,id);
			prep.executeUpdate();
			System.out.println("Nurse removed");
			
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
			String sql = "UPDATE nurse SET department=? WHERE id=?;";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setString(1, dep);
			prep.setInt(2, id);
			
			prep.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Nurse getNurseByID(int id) {
		// TODO Auto-generated method stub
		Nurse n = null;
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql = "SELECT * FROM nurse WHERE id=" + id;
			ResultSet rs = stmt.executeQuery(sql);
			
				String name = rs.getString("name");
				String department = rs.getString("department");
				String email = rs.getString("email");
				n = new Nurse(id, name, department, email);				
			
			rs.close();
			stmt.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return n;
	}

	
}
