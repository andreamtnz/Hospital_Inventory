package Hospital_inventoryInterfaces;


import java.util.List;

import Hospital_InventoryPOJO.Doctor;
public interface DoctorManager {
	//add a doctor
	public void addDoctor(Doctor d);
	//get a list of all the doctors
	public List<Doctor> getListDoctor();
	//remove a doctor by it´s id
	public void removeDoctor(int id);
	//change department
	public void updateDepartment(int id, String dep);
}
