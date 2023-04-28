package Hospital_inventoryInterfaces;


import java.util.List;
import Hospital_InventoryPOJO.Administrator;


public interface AdministratorManager {
	//add a administrator
	public void addAdministrator(Administrator a);
	//get a list of the administrators
	public List<Administrator> getListAdministrator();
	//remove an administrator by it´s id
	public void removeAdministrator(int id);
	//get an administrator by it´s id
	public Administrator getAdministratorByID(int id);
}
