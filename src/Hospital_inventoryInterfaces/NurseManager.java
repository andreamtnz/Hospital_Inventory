package Hospital_inventoryInterfaces;

import java.util.List;

import Hospital_InventoryPOJO.Nurse;

public interface NurseManager {

	//add a administrator
		public void addNurse(Nurse n);
		//get a list of the administrators
		public List<Nurse> getListNurse();
		//remove an administrator by it´s id
		public void removeNurse(int id);
		public void updateDepartment(int id);
		public Nurse getNurseByID(int id);
}
