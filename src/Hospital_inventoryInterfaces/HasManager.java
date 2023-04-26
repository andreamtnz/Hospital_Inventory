package Hospital_inventoryInterfaces;

import Hospital_InventoryPOJO.Has;

public interface HasManager {

	public void addHas(Has h);
	//assign a material to an order
	public void assignToOrder(int material_id, int order_id, int quantity);
}
