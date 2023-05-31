package Hospital_InventoryJDBC;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import Hospital_InventoryPOJO.Doctor;
import Hospital_InventoryPOJO.Materials;
import Hospital_InventoryPOJO.Order;
import Hospital_inventoryInterfaces.OrderManager;
import Hospital_inventoryInterfaces.MaterialsManager;

public class JDBCOrderManager implements OrderManager{

 private JDBCManager manager;
	 
	 public JDBCOrderManager (JDBCManager m)
	 {
		  this.manager = m;
	 }
	 
	@Override
	public void addOrder(Order o) {
		// TODO Auto-generated method stub
		try{
			String sql = "INSERT INTO order (state, date, cost, administrator_id) VALUES (?,?,?,?)";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setString(1, o.getState());
			prep.setDate(2, o.getDate());
			prep.setFloat(3, o.getCost());
			prep.setInt(4, o.getAdministrador());
			
			prep.executeUpdate();			
					
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addToOrder(Materials m, Order o, Integer q) {
		// TODO Auto-generated method stub
		try{
			String sql = "INSERT INTO has (materialID,orderID, quantity) VALUES (?,?,?)";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setInt(1, m.getId());
			prep.setInt(2, o.getId());	
			prep.setInt(3, q);		

			
			prep.executeUpdate();			
					
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Order> getListOrder() {
		// TODO Auto-generated method stub
		List<Order> orders = new ArrayList<Order>();
		
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql = "SELECT * FROM order";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Integer id = rs.getInt("order_id");
				String state = rs.getString("state");
				Date date = rs.getDate("date");
				Float cost = rs.getFloat("cost");
				Integer administrator = rs.getInt("administrator_id");
				
				Order o = new Order(id, state, date, cost, administrator);
				orders.add(o);
			}
			
			rs.close();
			stmt.close();	
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return orders;
	}

	@Override
	public Order getOrderByID(int order_id) {
		// TODO Auto-generated method stub
		Order o = null;
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql = "SELECT * FROM order WHERE order_id=" + order_id;
			ResultSet rs = stmt.executeQuery(sql);
			
				String state = rs.getString("state");
				Date date = rs.getDate("date");
				Float cost = rs.getFloat("cost");
				Integer administrator = rs.getInt("administratorID");
				o = new Order(order_id, state, date, cost, administrator);				
			
			rs.close();
			stmt.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return o;
	}
	
	@Override
	public void updateStatus(int order_id, String state) {
		// TODO Auto-generated method stub
		
			try {
					
				String sql = "UPDATE Order SET state=? WHERE order_id=?;";
				PreparedStatement prep = manager.getConnection().prepareStatement(sql);
				prep.setString(1, state);
				prep.setInt(2, order_id);
		
				prep.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
				}
	}

	@Override
	public List<Materials> getMaterialsOrder(int order_id) {
		// TODO Auto-generated method stub
		List<Materials> materials = new ArrayList<Materials>();
		
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql = "SELECT * FROM has WHERE orderID=" + order_id;
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Integer id = rs.getInt("materialID");
				Integer quantity = rs.getInt("quantity");
				MaterialsManager materialsManager = new JDBCMaterialsManager(manager);
				Materials m = materialsManager.getMaterialByID(id);
				m.setStock(quantity+m.getStock());
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
	public List<Integer> getlistOrders_id() {
		// TODO Auto-generated method stub
		List<Integer> orders_id = new ArrayList<Integer>();
		
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql = "SELECT order_id FROM order";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Integer id = rs.getInt("order_id");
				
				orders_id.add(id);
			}
			
			rs.close();
			stmt.close();	
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return orders_id;
	}

}
