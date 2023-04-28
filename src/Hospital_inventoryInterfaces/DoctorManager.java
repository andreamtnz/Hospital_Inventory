package Hospital_inventoryInterfaces;


import java.util.List;

import Hospital_InventoryPOJO.Doctor;
public interface DoctorManager {
	//add a doctor
	public void addDoctor(Doctor d);
	//get a list of all the doctors
	public List<Doctor> getListDoctor();
	public Doctor getDoctorByID(int id);
	//remove a doctor by it´s id
	public void removeDoctor(int id); //creo que sería mejor poner (Doctor d)
	//change department
	public void updateDepartment(int id); // aquí lo mismo, creo que mejor (Doctor d), y ya dentro del método se pide el departamento nuevo
}
