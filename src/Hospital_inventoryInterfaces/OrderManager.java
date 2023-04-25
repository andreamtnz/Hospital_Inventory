package Hospital_inventoryInterfaces;

import java.util.List;
import Hospital_InventoryPOJO.Materials;
import Hospital_InventoryPOJO.Order;

public interface OrderManager {
	//add an order
	public void addOrder(Order o);
	//add materials to a order
	public void addToOrder(Materials m, Integer q);
	//get a list of orders
	public List<Order> getListOrder();

}
