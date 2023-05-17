package Hospital_inventoryInterfaces;

import java.io.File;
import java.util.List;

import Hospital_InventoryPOJO.*;

public interface XMLManager {
	
	public void doctor2xml(Doctor d);
	public void doctorID2xml(Integer id);
	public void nurse2xml(Nurse n);
	public Doctor xml2doctor(File xml);
	public Nurse xml2nurse (File xml);
	public void simpleTransform(String sourcePath, String xsltPath,String resultDir);
}
