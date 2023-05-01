package Hospital_InventoryJDBC;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import Hospital_InventoryPOJO.Distribuitor;
import Hospital_InventoryPOJO.Doctor;
import Hospital_inventoryInterfaces.DistributorManager;

public class JDBCDistributorManager implements DistributorManager{
	
	private JDBCManager manager;
	 
	 public JDBCDistributorManager (JDBCManager m)
	 {
		  this.manager = m;
	 }

	@Override
	public void addDistributor(Distribuitor d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Distribuitor> getlistDistributors() {
		// TODO Auto-generated method stub
		List<Distribuitor> distributors = new ArrayList<Distribuitor>();
		
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql = "SELECT * FROM distributor";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String type = rs.getString("type");
				
				Distribuitor d = new Distribuitor(id,name, type);
				distributors.add(d);
			}
			
			rs.close();
			stmt.close();	
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return distributors;
	}

	@Override
	public void removeDistributor(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Distribuitor getDistributorByID(int id) {
		// TODO Auto-generated method stub
		Distribuitor d = null;
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql = "SELECT * FROM distributor WHERE id=" + id;
			ResultSet rs = stmt.executeQuery(sql);
			
				String name = rs.getString("name");
				String type = rs.getString("type");
				d = new Distribuitor(id, name, type);				
			
			rs.close();
			stmt.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return d;
	}

}
