package Hospital_InventoryJDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Hospital_InventoryPOJO.Administrator;
import Hospital_InventoryPOJO.Doctor;
import Hospital_inventoryInterfaces.AdministratorManager;

public class JDBCAdministratorManager implements AdministratorManager{

	private JDBCManager manager;
	
	public JDBCAdministratorManager(JDBCManager m)
	{
		this.manager = m;
	}
	@Override
	public void addAdministrator(Administrator a) {
		// TODO Auto-generated method stub
		try{
			String sql = "INSERT INTO administrator (name, email) VALUES (?,?)";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setString(1, a.getName());
			prep.setString(2, a.getEmail());
			
			prep.executeUpdate();			
					
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Administrator> getListAdministrator() {
		// TODO Auto-generated method stub
		List<Administrator> administrators = new ArrayList<Administrator>();
		
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql = "SELECT * FROM administrator";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Integer id = rs.getInt("administrator_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				
				Administrator a = new Administrator(id,name, email);
				administrators.add(a);
			}
			
			rs.close();
			stmt.close();	
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return administrators;
	}

	@Override
	public void removeAdministrator(int id) {
		// TODO Auto-generated method stub
			try {
				
				String sql = "DELETE FROM administrator WHERE administrator_id=?;";
				PreparedStatement prep = manager.getConnection().prepareStatement(sql);
				
				prep.setInt(1,id);
				
				prep.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
				
		}
	@Override
	public Administrator getAdministratorByID(int id) {
		// TODO Auto-generated method stub
		Administrator a = null;
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql = "SELECT * FROM administrator WHERE administrator_id=" + id;
			ResultSet rs = stmt.executeQuery(sql);
			
				String name = rs.getString("name");
				String email = rs.getString("email");
				a = new Administrator(id, name, email);				
			
			rs.close();
			stmt.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return a;
	}
	}


