package Hospital_inventoryInterfaces;

import java.util.List;

import Hospital_InventoryPOJO.Distribuitor;

public interface DistributorManager {
	public void addDistributor(Distribuitor d);
	
	public List<Distribuitor> getlistDistributors();
	
	public void removeDistributor(int id);
	
	public Distribuitor getDistributorByID(int id);

}
