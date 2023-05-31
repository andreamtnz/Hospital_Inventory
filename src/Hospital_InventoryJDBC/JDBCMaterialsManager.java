package Hospital_InventoryJDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Hospital_InventoryPOJO.Distribuitor;
import Hospital_InventoryPOJO.Materials;
import Hospital_inventoryInterfaces.MaterialsManager;

public class JDBCMaterialsManager implements MaterialsManager{
	
	private JDBCManager manager;
	
	public JDBCMaterialsManager(JDBCManager manager) {
		this.manager = manager;
	}

	@Override
	public void addMaterial(Materials m) {
		// TODO Auto-generated method stub
		try{
			String sql = "INSERT INTO material (name, type, stock, price, distributor_id) VALUES (?,?,?,?,?)";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setString(1, m.getName());
			prep.setString(2, m.getType());
			prep.setInt(3, m.getStock());
			prep.setFloat(4, m.getPrice());
			prep.setInt(5, m.getDistributor());

			prep.executeUpdate();
					
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeMaterial(int id) {
		// TODO Auto-generated method stub
		try {
			
			String sql = "DELETE FROM material WHERE material_id=?;";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setInt(1,id);
			prep.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void changeMaterial(Materials m) {
		// TODO Auto-generated method stub
		try {
			
			String sql = "UPDATE material SET name=?,type=?,stock=?,price=?,distributor_id=? WHERE material_id=" + m.getId() +"";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setString(1, m.getName());
			prep.setString(2, m.getType());
			prep.setInt(3, m.getStock());
			prep.setFloat(4, m.getPrice());
			prep.setInt(5, m.getDistributor());
			
			prep.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Materials> getListMaterials() {
		// TODO Auto-generated method stub
		List<Materials> materials = new ArrayList<Materials>();
		
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql = "SELECT * FROM material";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Integer id = rs.getInt("material_id");
				String name = rs.getString("name");
				String type = rs.getString("type");
				Integer stock = rs.getInt("stock");
				Float price = rs.getFloat("price");
				Integer distributor = rs.getInt("distributor_id");
				
				Materials m = new Materials(id,name, type, stock, price, distributor);
				materials.add(m);
			}
			
			rs.close();
			stmt.close();	
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return materials;
	}
	
	@Override
	public List<Integer> getlistMaterials_id() {
		// TODO Auto-generated method stub
		List<Integer> materials_id = new ArrayList<Integer>();
		
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql = "SELECT material_id FROM material";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Integer id = rs.getInt("material_id");
				
				materials_id.add(id);
			}
			
			rs.close();
			stmt.close();	
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return materials_id;
	}
	
	@Override
	public List<String> getlistMaterials_name(int dist_id) {
		// TODO Auto-generated method stub
		List<String> materials_name = new ArrayList<String>();
		
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql = "SELECT name FROM material WHERE material_id = "+ dist_id;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				String s = rs.getString("name");
				
				materials_name.add(s);
			}
			
			rs.close();
			stmt.close();	
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return materials_name;
	}


	@Override
	public Materials getMaterialByID(int id) {
		// TODO Auto-generated method stub
		Materials m = null;
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql = "SELECT * FROM material WHERE material_id=" + id;
			ResultSet rs = stmt.executeQuery(sql);
			
				String name = rs.getString("name");
				String type = rs.getString("type");
				Integer stock = rs.getInt("stock");
				Float price = rs.getFloat("price");
				Integer distributor = rs.getInt("distributor_id");
				m = new Materials(id, name, type, stock, price, distributor);				
			
			rs.close();
			stmt.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return m;
	}
	
	@Override
	public void updateStock(int material_id, int stock) {
		// TODO Auto-generated method stub
		
		try {
			
			String sql = "UPDATE material SET stock=? WHERE material_id=?;";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setInt(1, stock);
			prep.setInt(2, material_id);
			
			prep.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Materials> getMaterialsByDistributor(int distributor_id) {
		// TODO Auto-generated method stub
		List<Materials> materials = new ArrayList<Materials>();
		
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql = "SELECT * FROM material WHERE distributor_id =" + distributor_id;
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Integer id = rs.getInt("material_id");
				String name = rs.getString("name");
				String type = rs.getString("type");
				Integer stock = rs.getInt("stock");
				Float price = rs.getFloat("price");
				
				Materials m = new Materials(id,name, type, stock, price, distributor_id);
				materials.add(m);
			}
			
			rs.close();
			stmt.close();	
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return materials;
	}
	

	

}
