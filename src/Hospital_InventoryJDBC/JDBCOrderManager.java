package Hospital_InventoryJDBC;

import java.util.List;
import java.sql.PreparedStatement;
import java.util.List;

import Hospital_InventoryPOJO.Materials;
import Hospital_InventoryPOJO.Order;
import Hospital_inventoryInterfaces.OrderManager;

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
			String sql = "INSERT INTO order (state, date, cost, administrator) VALUES (?,?,?,?)";
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
	public void addToOrder(Materials m, Integer q) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> getListOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrderById(int order_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
