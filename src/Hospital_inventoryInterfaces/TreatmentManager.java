package Hospital_inventoryInterfaces;

import java.util.List;

import Hospital_InventoryPOJO.Doctor;
import Hospital_InventoryPOJO.Nurse;
import Hospital_InventoryPOJO.Materials;
import Hospital_InventoryPOJO.Treatment;


public interface TreatmentManager {

	//add a treatment
	public void addTreatment(Treatment t);
	//get a list of treatments
	public List<Treatment> getListTreatments();
	//assign a doctor
	public void assignDoctor(int doctor_id, int treatment_id);
	public void assignNurse(int nurse_id, int treatment_id);
	public void assignToTreatment(Materials m, Treatment t, Integer q);
	public Treatment getTreatmentById(int treatment_id); 
	public void removeTreatment(int treatment_id);
	public List<Doctor> getDoctorsInTreatment(int treatment_id);
	public List<Nurse> getNursesInTreatment(int treatment_id);
	public List<Integer> getlistTreatments_id();
	
}
 
