package Hospital_inventoryInterfaces;

import java.util.List;

import Hospital_InventoryPOJO.Materials;

public interface MaterialsManager {

	//adding a new material
	public void addMaterial(Materials m);
	//removing a material by it´s id
	public void removeMaterial(int id);
	//changing data
	public void changeMaterial(Materials m);
	//get a list of materials
	public List<Materials> getListMaterials();
	
	public Materials getMaterialByID(int id);
	public void updateStock(int id, int stock);
	
	public List<Materials> getMaterialsByDistributor(int distributor_id);
	public List<Integer> getlistMaterials_id();
	public List<String> getlistMaterials_name(int dist_id);
	
}
