package Hospital_inventoryInterfaces;

import java.util.List;
import Hospital_InventoryPOJO.Materials;
import Hospital_InventoryPOJO.Order;
import Hospital_InventoryPOJO.Treatment;

public interface OrderManager {
	//add an order
	public void addOrder(Order o);
	//add materials to a order
	public void addToOrder(Materials m, Order o, Integer q);
	//get a list of orders
	public List<Order> getListOrder();
	public Order getOrderById(int order_id);
	public void updateStatus(int order_id, String state);
}
