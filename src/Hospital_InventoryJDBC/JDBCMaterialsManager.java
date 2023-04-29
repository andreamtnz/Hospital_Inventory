package Hospital_InventoryJDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

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
			String sql = "INSERT INTO material (name, type, stock, price, distributorID) VALUES (?,?,?,?,?)";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setString(1, m.getName());
			prep.setString(2, m.getType());
			prep.setInt(3, m.getStock());
			prep.setFloat(4, m.getPrice());
			prep.setInt(5, m.getDistributor());

			prep.executeUpdate();
			System.out.println("Material added");
					
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeMaterial(int id) {
		// TODO Auto-generated method stub
		try {
			
			String sql = "DELETE FROM material WHERE id=?;";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setInt(1,id);
			prep.executeUpdate();
			System.out.println("Material removed");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void changeMaterial(Materials m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Materials> getListMaterials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Materials getMaterialBYID(int id) {
		// TODO Auto-generated method stub
		Materials m = null;
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql = "SELECT * FROM material WHERE id=" + id;
			ResultSet rs = stmt.executeQuery(sql);
			
				String name = rs.getString("name");
				String type = rs.getString("type");
				Integer stock = rs.getInt("stock");
				Float price = rs.getFloat("price");
				Integer distributor = rs.getInt("distributorID");
				m = new Materials(id, name, type, stock, price, distributor);				
			
			rs.close();
			stmt.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return m;
	}
	

}
