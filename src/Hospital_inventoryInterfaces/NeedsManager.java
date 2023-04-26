package Hospital_inventoryInterfaces;

import Hospital_InventoryPOJO.Needs;

public interface NeedsManager {

	public void addNeeds(Needs n);
	//add a material to the treatment
	public void assignToTreatment(int material_id, int treatment_id, int quantity);
	
}
