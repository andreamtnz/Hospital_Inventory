package Hospital_inventoryInterfaces;

import java.util.List;
import Hospital_InventoryPOJO.Treatment;


public interface TreatmentManager {

	//add a treatment
	public void addTreatment(Treatment t);
	//get a list of treatments
	public List<Treatment> getListTreatments();
	//assign a doctor
	public void assignDoctor(int doctor_id, int treatment_id);
	public void assignNurse(int nurse_id, int treatment_id);
	public Treatment getTreatmentById(int treatment_id); 
}
 
