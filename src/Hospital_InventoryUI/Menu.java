package Hospital_InventoryUI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Hospital_InventoryJDBC.*;
import Hospital_InventoryJPA.JPAUserManager;
import Hospital_inventoryInterfaces.*;
import Hospital_InventoryPOJO.*;




public class Menu {
	
	private static BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
	private static AdministratorManager administratorManager;
	private static DoctorManager doctorManager;
	private static HasManager hasManager;
	private static MaterialsManager materialsManager;
	private static NeedsManager needsManager;
	private static NurseManager nurseManager;
	private static OrderManager orderManager;
	private static TreatmentManager treatmentManager;
	private static UserManager userManager;
	private static JDBCManager jdbcManager;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	jdbcManager = new JDBCManager();
	administratorManager= new JDBCAdministratorManager(jdbcManager);
	doctorManager = new JDBCDoctorManager(jdbcManager);
	//hasManager = new JDBCHasManager(jdbcManager); // hay que hacerlo 
	materialsManager = new JDBCMaterialsManager(jdbcManager);
	//needsManager = new JDBCNeedsManager(jdbcManager);
	nurseManager = new JDBCNurseManager(jdbcManager);
	orderManager = new JDBCOrderManager(jdbcManager);
	treatmentManager = new JDBCTreatmentManager(jdbcManager);
	userManager = new JPAUserManager();

	
	try {
		do {
			System.out.println("Choose an option");
			System.out.println("1. Login Administrator");
			System.out.println("2. Login Doctor");
			System.out.println("3. Login Nurse");
			System.out.println("0. exit");

			int choice = Integer.parseInt(reader.readLine());
			switch(choice)
			{
			case 1:
				loginAdministrator();
				break;
			case 2:
				loginDoctor();
				break;
			case 3:
				loginNurse();
				break;
			case 0: 
				jdbcManager.disconnect();
				userManager.disconnect();
				System.exit(0);
			default:
				break;
			}
		}while(true);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
//ADMINISTRADOR
	private static void administratorMenu (Integer id) throws Exception{
		
		try {
			do {
				System.out.println("Choose an option");
				System.out.println("1. Work with materials");
				System.out.println("2. Work with distributors");
				System.out.println("3. Work with orders");
				System.out.println("4. Work with doctors");
				System.out.println("5. Work with nurses");
				System.out.println("0. exit");

				int choice = Integer.parseInt(reader.readLine());
				switch(choice)
				{
				case 1:
					materialsSubMenu();
					break;
				case 2:
//					distibutorsSubMenu();  COMENTADO PORQUE FALTA JDBCMANAGER
					break;
				case 3:
					ordersSubMenu(); 
					break;
				case 4:
					doctorsSubMenu(); 
					break;
				case 5:
					nursesSubMenu(); 
					break;
				case 0: 
					jdbcManager.disconnect();
					userManager.disconnect();
					System.exit(0);
				default:
					break;
				}
			}while(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static void loginAdministrator() throws Exception{
		
		System.out.println("Email:");
		String email = reader.readLine();
		
		System.out.println("Password: ");
		String passwd = reader.readLine();
		User u = userManager.checkPassword(email, passwd);
		
		if(u!=null & u.getRole().getName().equals("owner"))
		{	
			System.out.println("Login Successful!");
			administratorMenu(u.getId());
		}
		
	}
	
	
	//submenu materiales Administrador
private static void materialsSubMenu () throws Exception{
		
		try {
			do {
				System.out.println("Choose an option");
				System.out.println("1.View all materials");
				System.out.println("2. Search a material");
				System.out.println("3. Add a new material");
				System.out.println("4. Modify an existing material");
				System.out.println("5. Delete an existing material");
				System.out.println("6. View full stock");
				System.out.println("7. Search stock of a material");
				System.out.println("8. Modify stock of a material");
				System.out.println("0. exit");

				int choice = Integer.parseInt(reader.readLine());
				switch(choice)
				{
				case 1:
	//				viewMaterials(); //shows all info about all the materials, full table
					break;
				case 2:
	//				searchMaterial();
					break;
				case 3:
					addMaterial();
					break;
		/*		case 4:  			CASES COMENTADOS PORQUE HAY QUE HACER LOS MÉTODOS
					modifyMaterial();
					break;
				case 5:
					deleteMaterial();
					break;
				case 6:
					viewStocks(); //shows id, name and stock of all materials
					break;
				case 7:
					searchStock();
					break;
				case 8:
					modifyStock();
					break;		*/
				case 0: 
					jdbcManager.disconnect();
					userManager.disconnect();
					System.exit(0);
				default:
					break;
				}
			}while(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	//submenu distribuidores Administrador
private static void distributorsSubMenu() throws Exception{
	
	try {
		do {
			System.out.println("Choose an option");
			System.out.println("1.View all distributors");
			System.out.println("2. Search a distributor");
			System.out.println("3. Add a new distributor");
			System.out.println("4. View all materials from a specific distributor");
			
			System.out.println("0. exit");

			int choice = Integer.parseInt(reader.readLine());
			switch(choice)
			{
			case 1:
//				viewMDistributors(); //shows all info about all the materials, full table
				break;
			case 2:
//				searchDistributor();
				break;
			case 3:
//				addDistributor();
				break;
			case 4:  		//	CASES COMENTADOS PORQUE HAY QUE HACER LOS MÉTODOS
//				viewMaterialsDistributot();
				break;
	
			case 0: 
				jdbcManager.disconnect();
				userManager.disconnect();
				System.exit(0);
			default:
				break;
			}
		}while(true);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	//submenu Order Administrador
private static void ordersSubMenu() throws Exception{
	
	try {
		do {
			System.out.println("Choose an option");
			System.out.println("1. View all orders");
			System.out.println("2. Search an order");
			System.out.println("3. Place an order");
			System.out.println("4. Modify an order status");
			System.out.println("0. exit");

			int choice = Integer.parseInt(reader.readLine());
			switch(choice)
			{
			case 1:
//				viewOrders();
				break;
			case 2:
//				searchOrder();
				break;
			case 3:
//				placeOrder();
				break;
			case 4:
//				upsateStatus();
				break;
			case 0: 
				jdbcManager.disconnect();
				userManager.disconnect();
				System.exit(0);
			default:
				break;
			}
		}while(true);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


	//submenu Doctor Administrador
private static void doctorsSubMenu() throws Exception{
	
	try {
		do {
			System.out.println("Choose an option");
			System.out.println("1. View all doctors");
			System.out.println("2. Search a doctor");
			System.out.println("3. Add a new doctor");
			System.out.println("4. Update a doctor's department");
			System.out.println("5. Delete a doctor");
			System.out.println("0. exit");

			int choice = Integer.parseInt(reader.readLine());
			switch(choice)
			{
			case 1:
//				viewDoctors();
				break;
			case 2:
//				searchDoctor();
				break;
			case 3:
				addDoctor();
				break;
			case 4:
				updateDoctor();
				break;
			case 5:
				deleteDoctor();
				break;
			case 0: 
				jdbcManager.disconnect();
				userManager.disconnect();
				System.exit(0);
			default:
				break;
			}
		}while(true);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


//submenu Nurse Administrador
private static void nursesSubMenu() throws Exception{
	
	try {
		do {
			System.out.println("Choose an option");
			System.out.println("1. View all nurses");
			System.out.println("2. Search a nurse");
			System.out.println("3. Add a new nurse");
			System.out.println("4. Update a nurse's department");
			System.out.println("5. Delete a nurse");
			System.out.println("0. exit");

			int choice = Integer.parseInt(reader.readLine());
			switch(choice)
			{
			case 1:
//				viewNurses();
				break;
			case 2:
//				searchNurse();
				break;
			case 3:
				addNurse();
				break;
			case 4:
				updateNurse();
				break;
			case 5:
				deleteNurse();
				break;
			case 0: 
				jdbcManager.disconnect();
				userManager.disconnect();
				System.exit(0);
			default:
				break;
			}
		}while(true);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


//DOCTOR
	
private static void doctorMenu (Integer id) throws Exception{
		
		try {
			do {
				System.out.println("Choose an option");
				System.out.println("1. View all treatments");
				System.out.println("2. Search treatment");
				System.out.println("3. Add a treatment");
				System.out.println("4. Delete an existing treatment");
				System.out.println("5. Assign doctor to a treatment");
				System.out.println("6. Assign nurse to a treatment");
				System.out.println("7. View stock of all materials");
				System.out.println("8. Search stock of a material");
				System.out.println("9. Modify stock of a material");
				System.out.println("0. exit");

				int choice = Integer.parseInt(reader.readLine());
				switch(choice)
				{
				case 1:
//					viewTreatments();
					break;
				case 2:
//					searchTreatment();
					break;
				case 3:
//					addTreatment(); 
					break;
				case 4:
//					deleteTreatment(); 
					break;
				case 5:
					assignDoctorToTreatment(); 
					break;
				case 6:
					assignNurseToTreatment();
					break;
				case 7:
//					viewStocks();
					break;
				case 8:
//					searchStock();
					break;
				case 9:
					modifyStock();
				case 0: 
					jdbcManager.disconnect();
					userManager.disconnect();
					System.exit(0);
				default:
					break;
				}
			}while(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
private static void loginDoctor() throws Exception{
		
		System.out.println("Email:");
		String email = reader.readLine();
		
		System.out.println("Password: ");
		String passwd = reader.readLine();
		User u = userManager.checkPassword(email, passwd);
		
		if(u!=null & u.getRole().getName().equals("owner"))
		{	
			System.out.println("Login Successful!");
			doctorMenu(u.getId());
		}
		
	}


//NURSE

private static void nurseMenu (Integer id) throws Exception{
	
	try {
		do {
			System.out.println("Choose an option");
			System.out.println("1. View all treatments");
			System.out.println("2. Search treatment");
			System.out.println("3. View stock of all materials");
			System.out.println("4. Search stock of a material");
			System.out.println("5. Modify stock of a material");
			System.out.println("0. exit");

			int choice = Integer.parseInt(reader.readLine());
			switch(choice)
			{
			case 1:
//				viewTreatments();
				break;
			case 2:
//				searchTreatment();
				break;
			case 3:
//				viewStocks();
				break;
			case 4:
//				searchStock();
				break;
			case 5:
//				modifyStock();
				break;
				
			case 0: 
				jdbcManager.disconnect();
				userManager.disconnect();
				System.exit(0);
			default:
				break;
			}
		}while(true);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
private static void loginNurse() throws Exception{
	
	System.out.println("Email:");
	String email = reader.readLine();
	
	System.out.println("Password: ");
	String passwd = reader.readLine();
	User u = userManager.checkPassword(email, passwd);
	
	if(u!=null & u.getRole().getName().equals("owner"))
	{	
		System.out.println("Login Successful!");
		nurseMenu(u.getId());
	}
	
}		


	
/*	private static void chooseVet() throws Exception{
		// TODO Auto-generated method stub
		Vet v = new Vet();
		System.out.println("Please choose a vet, type its ID:");
		System.out.println(vetManager.getListAllVets());
		Integer vetID = Integer.parseInt(reader.readLine());
		//show vet data
		v = vetManager.getVetbyId(vetID);
		System.out.println(v.toString());
	}  */

	private static void assignDoctorToTreatment() throws Exception{
		// TODO Auto-generated method stub
		System.out.println("Please enter the doctor ID to assign:");
		Integer doctor_id = Integer.parseInt(reader.readLine());
		System.out.println("Please enter the treatment ID to assign:");
		Integer treatment_id = Integer.parseInt(reader.readLine());
		
		treatmentManager.assignDoctor(doctor_id, treatment_id);
		System.out.println("Doctor assigned");

		
	}
	
	private static void assignNurseToTreatment() throws Exception{
		// TODO Auto-generated method stub
		System.out.println("Please enter the nurse ID to assign:");
		Integer nurse_id = Integer.parseInt(reader.readLine());
		System.out.println("Please enter the treatment ID to assign:");
		Integer treatment_id = Integer.parseInt(reader.readLine());
		
		treatmentManager.assignDoctor(nurse_id, treatment_id);
		System.out.println("Nurse assigned");

		
	}



/*private static Materials selectMaterial() throws Exception{
	// TODO Auto-generated method stub
	Materials m = new Materials();
	System.out.println("Please choose a material, type its ID:");
	System.out.println(materialsManager.getListAllMaterials());
	Integer materialID = Integer.parseInt(reader.readLine());
	
	m = materialsManager.getMaterialbyId(materialID);
	System.out.println(v.toString());
}*/


/*private static void wiewMaterials() throws Exception {
		// TODO Auto-generated method stub
		List<Materials> materials = new ArrayList<Materials>();
		
		try {
			materials = materialsManager.getListAllMaterials();
			int i;
			for(i=0; i< materials.size(); i++)
			{
				System.out.println(materials.get(i).toString());
			}
		
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

*/
	public static void addMaterial() throws Exception
	{
		
		System.out.println("Type the name:");
		String name = reader.readLine();
		System.out.println("Type the type:");
		String type = reader.readLine();
		System.out.println("Type the stock:");
		Integer stock = Integer.parseInt(reader.readLine());
		System.out.println("Type the price:");
		Float price = Float.parseFloat(reader.readLine());
		System.out.println("Type the distributor ID:");
		Integer distributor_id = Integer.parseInt(reader.readLine());
	
		Materials m = new Materials(name, type, stock, price, distributor_id);
		materialsManager.addMaterial(m);
		System.out.println("Material added");

	}
	
	
/*	public static void addDistributor() throws Exception
	{
		
		System.out.println("Type the name:");
		String name = reader.readLine();
		System.out.println("Type the type:");
		String type = reader.readLine();
	
	
		Distribuitor d = new Distribuitor(name, type,);
		distributorManager.addDistributor(d);
		
		System.out.println("Distributor added");
	}		*/ //HAY QUE HACER JDBCMANAGER DE DISTRIBUITOR
	
	
/*	public static void placeOrder() throws Exception
	{
		System.out.println("Type the id of the material you want to order: ");
		int materialID = Integer.parseInt(reader.readLine());
		System.out.println("Type the amount of materials you want to order: ");
		int amount = Integer.parseInt(reader.readLine());
		//HAY QUE COMPLETAR	
	} */
	
	public static void addDoctor() throws Exception
	{
		
		System.out.println("Type the name:");
		String name = reader.readLine();
		System.out.println("Type the department:");
		String department = reader.readLine();
		System.out.println("Type the email:");
		String email = reader.readLine();
			
		Doctor d = new Doctor(name, department, email);
		doctorManager.addDoctor(d);
		
		System.out.println("Doctor added");

	}
	
	public static void addNurse() throws Exception
	{
		
		System.out.println("Type the name:");
		String name = reader.readLine();
		System.out.println("Type the department:");
		String department = reader.readLine();
		System.out.println("Type the email:");
		String email = reader.readLine();
			
		Nurse n = new Nurse(name, department, email);
		nurseManager.addNurse(n);
		
		System.out.println("Nurse added");

	}
	
		
	public static void updateDoctor() throws Exception
	{
		System.out.println("Please enter the id of the doctor to update:");
		int doctor_id =  Integer.parseInt(reader.readLine());
		System.out.println("Please enter the new department:");
		String department = reader.readLine();
		
		doctorManager.updateDepartment(doctor_id, department);
		System.out.println("Doctor department updated");

	}
	
	public static void updateNurse() throws Exception
	{
		System.out.println("Please enter the id of the nurse to update:");
		int nurse_id =  Integer.parseInt(reader.readLine());
		System.out.println("Please enter the new department:");
		String department = reader.readLine();
		
		nurseManager.updateDepartment(nurse_id, department);
		System.out.println("Nurse department updated");

	}
	
	public static void modifyStock() throws Exception
	{
		System.out.println("Please enter the id of the material:");
		int material_id =  Integer.parseInt(reader.readLine());
		System.out.println("Please enter the new stock:");
		int stock = Integer.parseInt(reader.readLine());
		
		materialsManager.updateStock(material_id, stock);
		System.out.println("Stock modified");

	}
	
	public static void updateStatus() throws Exception
	{
		System.out.println("Please enter the id of the order:");
		int order_id =  Integer.parseInt(reader.readLine());
		System.out.println("Please enter the new status:");
		String status = reader.readLine();
		
		orderManager.updateStatus(order_id, status);
		System.out.println("Status updated");

	}

	
	public static void deleteDoctor() throws Exception
	{
		System.out.println("Please enter the id of the doctor to delete:");
		int doctor_id =  Integer.parseInt(reader.readLine());
		doctorManager.removeDoctor(doctor_id);
		System.out.println("Doctor deleted");
	}
	
	public static void deleteNurse() throws Exception
	{
		System.out.println("Please enter the id of the doctor to delete:");
		int nurse_id =  Integer.parseInt(reader.readLine());
		nurseManager.removeNurse(nurse_id);
		System.out.println("Nurse deleted");
	}
	
	public static void deleteTreatment() throws Exception
	{
		System.out.println("Please enter the id of the treatment to delete:");
		int treatment_id =  Integer.parseInt(reader.readLine());
		treatmentManager.removeTreatment(treatment_id);
		
		System.out.println("Treatment deleted");

	}
	

}
