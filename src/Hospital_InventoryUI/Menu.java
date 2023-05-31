package Hospital_InventoryUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import Hospital_InventoryJDBC.*;
import Hospital_InventoryJPA.JPAUserManager;
import Hospital_inventoryInterfaces.*;
import Hospital_InventoryPOJO.*;
import Hospital_InventoryXMLManager.XMLDoctor_NurseManager;




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
	private static DistributorManager distributorManager;
	private static JDBCManager jdbcManager;
	private static XMLManager xmlManager;
	
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
	distributorManager = new JDBCDistributorManager(jdbcManager);
	xmlManager = new XMLDoctor_NurseManager(jdbcManager);

	
	try {
		do {
			System.out.println("Choose an option");
			System.out.println("1. Login Administrator");
			System.out.println("2. Login Doctor");
			System.out.println("3. Login Nurse");
			System.out.println("4. Sign up");
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
			case 4: 
				signup(); 
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
				System.out.println("\nAdministrator Menu");
				System.out.println("\nChoose an option");
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
					distributorsSubMenu(); 
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
		
		if(u!=null & u.getRole().getName().equals("administrator"))
		{	
			System.out.println("Login Successful!");
			administratorMenu(u.getId());
		}
		
	}
	
	
	//submenu materiales Administrador
private static void materialsSubMenu () throws Exception{
		
		try {
			boolean check = true;
			do {
				System.out.println("\nAdministrator Menu - Work with Materials");
				System.out.println("\nChoose an option");
				System.out.println("1. View all materials");
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
					viewMaterials(); //shows all info about all the materials, full table
					break;
				case 2:
					searchMaterial();
					break;
				case 3:
					addMaterial();
					break;
				case 4:  			
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
					break;		
				case 0: 
					check = false;
					break;
				default:
					break;
				}
			}while(check);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	//submenu distribuidores Administrador
private static void distributorsSubMenu() throws Exception{
	
	try {
		boolean check = true;
		do {
			System.out.println("\nAdministrator Menu - Work with Distributors");
			System.out.println("\nChoose an option");
			System.out.println("1. View all distributors");
			System.out.println("2. Search a distributor");
			System.out.println("3. Add a new distributor");
			System.out.println("4. View all materials from a specific distributor");
			System.out.println("0. Back to Administrator Menu");

			int choice = Integer.parseInt(reader.readLine());
			switch(choice)
			{
			case 1:
				viewDistributors(); //shows all info about all the distributors, full table
				break;
			case 2:
				searchDistributor();
				break;
			case 3:
				addDistributor();
				break;
			case 4:  		
				viewMaterialsDistributor();
				break;
	
			case 0: 
				check = false;
				break;
			default:
				break;
			}
		}while(check);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	//submenu Order Administrador
private static void ordersSubMenu() throws Exception{
	
	try {
		boolean check = true;
		do {
			System.out.println("\nAdministrator Menu - Work with Orders");
			System.out.println("\nChoose an option");
			System.out.println("1. View all orders");
			System.out.println("2. Search an order");
			System.out.println("3. Place an order");
			System.out.println("4. Modify an order status");
			System.out.println("0. exit");

			int choice = Integer.parseInt(reader.readLine());
			switch(choice)
			{
			case 1:
				viewOrders();
				break;
			case 2:
				searchOrder();
				break;
			case 3:
				placeOrder();
				break;
			case 4:
				updateStatus();
				break;
			case 0: 
				check = false;
				break;
			default:
				break;
			}
		}while(check);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


	//submenu Doctor Administrador
private static void doctorsSubMenu() throws Exception{
	
	try {
		boolean check = true;
		do {
			System.out.println("\nAdministrator Menu - Work with Doctors");
			System.out.println("\nChoose an option");
			System.out.println("1. View all doctors");
			System.out.println("2. Search a doctor");
			System.out.println("3. Add a new doctor");
			System.out.println("4. Update a doctor's department");
			System.out.println("5. Delete a doctor");
			System.out.println("6. Save in xml and html");
			System.out.println("0. exit");

			int choice = Integer.parseInt(reader.readLine());
			switch(choice)
			{
			case 1:
				viewDoctors();
				break;
			case 2:
				searchDoctor();
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
			case 6:
				printMe();
				break;
			case 0: 
				check = false;
				break;
			default:
				break;
			}
		}while(check);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


//submenu Nurse Administrador
private static void nursesSubMenu() throws Exception{
	
	try {
		boolean check = true;
		do {
			System.out.println("\nAdministrator Menu - Work with Nurses");
			System.out.println("\nChoose an option");
			System.out.println("1. View all nurses");
			System.out.println("2. Search a nurse");
			System.out.println("3. Add a new nurse");
			System.out.println("4. Update a nurse's department");
			System.out.println("5. Delete a nurse");
			System.out.println("6. Save nurse in xml");
			System.out.println("0. exit");

			int choice = Integer.parseInt(reader.readLine());
			switch(choice)
			{
			case 1:
				viewNurses();
				break;
			case 2:
				searchNurse();
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
			case 6:
				printMeNurse();
				break;
			case 0: 
				check = false;
				break;
			default:
				break;
			}
		}while(check);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


	
private static void doctorMenu (Integer id) throws Exception{
		
		try {
			do {
				System.out.println("\nDoctor Menu");
				System.out.println("\nChoose an option");
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
					viewTreatments();
					break;
				case 2:
					searchTreatment();
					break;
				case 3:
					addTreatment(); 
					break;
				case 4:
					deleteTreatment(); 
					break;
				case 5:
					assignDoctorToTreatment(); 
					break;
				case 6:
					assignNurseToTreatment();
					break;
				case 7:
					viewStocks();
					break;
				case 8:
					searchStock();
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
		
		if(u!=null & u.getRole().getName().equals("doctor"))
		{	
			System.out.println("Login Successful!");
			doctorMenu(u.getId());
		}
		
	}


//NURSE

private static void nurseMenu (Integer id) throws Exception{
	
	try {
		do {
			System.out.println("\nNurse Menu");
			System.out.println("\nChoose an option");
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
				viewTreatments();
				break;
			case 2:
				searchTreatment();
				break;
			case 3:
				viewStocks();
				break;
			case 4:
				searchStock();
				break;
			case 5:
				modifyStock();
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
	
	if(u!=null & u.getRole().getName().equals("nurse"))
	{	
		System.out.println("Login Successful!");
		nurseMenu(u.getId());
	}
	
}		


	
	private static void searchMaterial() throws Exception {	//done
		// TODO Auto-generated method stub
		try {
		showMaterialsID();
		Materials m = new Materials();
		System.out.println("\nPlease choose a material, type its ID:");
		Integer material_id = Integer.parseInt(reader.readLine());
		//show material data
		boolean check = checkMaterial_id(material_id);
		if (check == false) {
			System.out.println("Material not found");
		}
		else {		
		m = materialsManager.getMaterialByID(material_id);
		System.out.println(m.toString());
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	} 

	
	private static void viewDistributors() {
		List<Distribuitor> distributors = new ArrayList<Distribuitor>();
		distributors = distributorManager.getlistDistributors();
		ListIterator<Distribuitor> iterator = distributors.listIterator();
		System.out.println("\nDistributors");
		while(iterator.hasNext()) {
			Distribuitor dist = iterator.next();
			System.out.println(dist.toString());
		}
	}
	
	private static void viewMaterialsDistributor() throws Exception{ //done
		try {
		showDistributorsID();
		System.out.println("\nSelect a distributor to see the materials it sells:");
		int distributorID = Integer.parseInt(reader.readLine());
		boolean check = checkDistributor_id(distributorID);
		if (check == false) {
			System.out.println("Distributor not found");
		}
		else {
		List<Materials> materials = new ArrayList<Materials>();
		materials = materialsManager.getMaterialsByDistributor(distributorID);
		ListIterator<Materials> iterator = materials.listIterator();
		while(iterator.hasNext()) {
			Materials mat = iterator.next();
			System.out.println(mat.toString());
		}
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void searchDistributor() throws Exception{ //done
		// TODO Auto-generated method stub
		try {
		showDistributorsID();
		System.out.println("\nPlease choose a distributor, type its ID:");
		Integer distributor_id = Integer.parseInt(reader.readLine());
		boolean check = checkDistributor_id(distributor_id);
		if (check == false) {
			System.out.println("Distributor not found");
		}
		else {
		Distribuitor d = new Distribuitor();
		d = distributorManager.getDistributorByID(distributor_id);
		System.out.println(d.toString());
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	} 
	
	private static void searchTreatment() throws Exception{ //done
		// TODO Auto-generated method stub
		try {
		showTreatmentsID();
		System.out.println("Please choose a treatment, type its ID:");
		Integer treatment_id = Integer.parseInt(reader.readLine());
		//show material data
		Treatment t = new Treatment();
		t = treatmentManager.getTreatmentById(treatment_id);
		System.out.println(t.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	} 
	
	private static void searchOrder() throws Exception { 	//done
		// TODO Auto-generated method stub
		try {
		showOrdersID();
				
		Order o = new Order();
		System.out.println("Please choose an order, type its ID:");
		System.out.println(orderManager.getListOrder());
		Integer order_id = Integer.parseInt(reader.readLine());
		//show material data
		o = orderManager.getOrderByID(order_id);
		System.out.println(o.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void viewDoctors() {
		List<Doctor> doctors = new ArrayList<Doctor>();
		doctors = doctorManager.getListDoctor();
		ListIterator<Doctor> iterator = doctors.listIterator();
		System.out.println("\nDoctors");
		while(iterator.hasNext()) {
			Doctor doc = iterator.next();
			System.out.println(doc.toString());
		}
	}
	
	private static void viewNurses() {
		List<Nurse> nurses = new ArrayList<Nurse>();
		nurses = nurseManager.getListNurse();
		ListIterator<Nurse> iterator = nurses.listIterator();
		System.out.println("\nNurses");
		while(iterator.hasNext()) {
			Nurse nur = iterator.next();
			System.out.println(nur.toString());
		}
	}

	private static void searchDoctor() throws Exception { 	//done
		// TODO Auto-generated method stub
		try {
		showDoctorsID();
		Doctor d = new Doctor();
		System.out.println("Please choose a doctor, type its ID:");
		Integer doctor_id = Integer.parseInt(reader.readLine());
		//show material data
		d = doctorManager.getDoctorByID(doctor_id);
		System.out.println(d.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void searchNurse() throws Exception{	//done
		// TODO Auto-generated method stub
		try {
		showNursesID();
		Nurse n = new Nurse();
		System.out.println("Please choose a nurse, type its ID:");
		System.out.println(nurseManager.getListNurse());
		Integer nurse_id = Integer.parseInt(reader.readLine());
		//show material data
		n = nurseManager.getNurseByID(nurse_id);
		System.out.println(n.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void assignDoctorToTreatment() throws Exception{ 	//done
		try {
		showDoctorsID();
		System.out.println("Please enter the doctor ID to assign:");
		Integer doctor_id = Integer.parseInt(reader.readLine());
		showTreatmentsID();
		System.out.println("Please enter the treatment ID to assign:");
		Integer treatment_id = Integer.parseInt(reader.readLine());
		
		treatmentManager.assignDoctor(doctor_id, treatment_id);
		System.out.println("Doctor assigned");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void assignNurseToTreatment() throws Exception{	//done
		// TODO Auto-generated method stub
		try {
		showNursesID();
		System.out.println("Please enter the nurse ID to assign:");
		Integer nurse_id = Integer.parseInt(reader.readLine());
		showTreatmentsID();
		System.out.println("Please enter the treatment ID to assign:");
		Integer treatment_id = Integer.parseInt(reader.readLine());
		
		treatmentManager.assignNurse(nurse_id, treatment_id);
		System.out.println("Nurse assigned");
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}


private static void selectMaterial() throws Exception{   //este método es el mismo que searchMaterial()
	// TODO Auto-generated method stub
	Materials m = new Materials();
	System.out.println("Please choose a material, type its ID:");
	System.out.println(materialsManager.getListMaterials());
	Integer materialID = Integer.parseInt(reader.readLine());
	
	m = materialsManager.getMaterialByID(materialID);
	System.out.println(m.toString());
}


private static void viewMaterials() throws Exception { // creo que no hace falta el try catch
		// TODO Auto-generated method stub
		List<Materials> materials = new ArrayList<Materials>();
		System.out.println("\nMaterials");
		
		try {
			materials = materialsManager.getListMaterials();
			int i;
			for(i=0; i< materials.size(); i++)
			{
				System.out.println(materials.get(i).toString());
			}
		
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No hay meateriales registrados");
		}
	}


	
	public  static void addMaterial() throws Exception {
		try {
		System.out.println("Type the name:");
		String name = reader.readLine();
		System.out.println("Type the type:");
		String type = reader.readLine();
		System.out.println("Type the stock:");
		Integer stock = Integer.parseInt(reader.readLine());
		System.out.println("Type the price:");
		Float price = Float.parseFloat(reader.readLine());
		showDistributorsID();
		System.out.println("Type the distributor ID:");
		Integer distributor_id = Integer.parseInt(reader.readLine());
		boolean check = checkDistributor_id(distributor_id);
		while (!check) {
			System.out.println("Distributor ID not valid. Please try again:");
			distributor_id = Integer.parseInt(reader.readLine());
			check = checkDistributor_id(distributor_id);		
		}
		boolean check2 = checkRepeatedMaterial(distributor_id, name);
		while (!check2) {
			System.out.println("Error. The material "+name+ "already exists for the distributor " + distributor_id);
		}
		
		if (check == true && check2 == true) {
	
		Materials m = new Materials(name, type, stock, price, distributor_id);
		materialsManager.addMaterial(m);
		System.out.println("Material added");}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static boolean checkRepeatedMaterial(int dist_id, String name) {
		boolean r;
		List<String> mat_dist = materialsManager.getlistMaterials_name(dist_id);
		if (mat_dist.contains(name)) {
			r = true;
		}
		else {
			r = false;
		}
		
		return r;
	}
	
	 
	
	public static boolean checkDistributor_id (int id) {
		boolean r = false;
		List<Integer> dist_id = new ArrayList<Integer>();
		dist_id = distributorManager.getlistDistributors_id();

		if (dist_id.contains(id)){
			r = true;
		}
		else {
			r = false;
		}
			
		return r;
		}
	
	public static boolean checkMaterial_id (int id) {
		boolean r = false;
		List<Integer> mat_id = new ArrayList<Integer>();
		mat_id = materialsManager.getlistMaterials_id();
		
		if (mat_id.contains(id)){
			r = true;
		}
		else {
			r = false;
		}
			
		return r;
		}
	
	public static boolean checkDoctor_id (int id) {
		boolean r = false;
		List<Integer> doc_id = new ArrayList<Integer>();
		doc_id = doctorManager.getlistDoctors_id();
		
		if (doc_id.contains(id)){
			r = true;
		}
		else {
			r = false;
		}
			
		return r;
		}
	
	public static boolean checkNurse_id (int id) {
		boolean r = false;
		List<Integer> nur_id = new ArrayList<Integer>();
		nur_id = nurseManager.getlistNurses_id();
		
		if (nur_id.contains(id)){
			r = true;
		}
		else {
			r = false;
		}
		
		return r;
	}
		
		public static boolean checkOrder_id (int id) {
			boolean r = false;
			List<Integer> ord_id = new ArrayList<Integer>();
			ord_id = orderManager.getlistOrders_id();
			
			if (ord_id.contains(id)){
				r = true;
			}
			else {
				r = false;
			}
			return r;
			}
		
		public static boolean checkTreatment_id (int id) {
			boolean r = false;
			List<Integer> tre_id = new ArrayList<Integer>();
			tre_id = treatmentManager.getlistTreatments_id();				
				if (tre_id.contains(id)){
					r = true;
				}
				else {
					r = false;
				}
		return r;
		}
		
		
		

	
	public static void addDistributor() throws Exception {	//done
		
		System.out.println("Type the name:");
		String name = reader.readLine();
		System.out.println("Type the type:");
		String type = reader.readLine();
	
	
		Distribuitor d = new Distribuitor(name, type);
		distributorManager.addDistributor(d);
		
		System.out.println("Distributor added");
	}		 
	
	
	public static void placeOrder() throws Exception {
		boolean check = false;
		int distributorID = 0;
		Date date = new Date(System.currentTimeMillis()); 
		Float price = null;
		Order o = new Order(date,price);
		List<Distribuitor> distributors = new ArrayList<Distribuitor>();
		List<Materials> materials = new ArrayList<Materials>();
		distributors = distributorManager.getlistDistributors();
		ListIterator<Distribuitor> iterator = distributors.listIterator();
		while(iterator.hasNext()) {
			Distribuitor dist = iterator.next();
			System.out.println(dist.getId() + "->" + dist.getName());
		}
		do {
		System.out.println("Introduce the ID of the distributor you want to order from:");
		distributorID = Integer.parseInt(reader.readLine());
		check = checkDistributor_id(distributorID);
		}while(!check);
		
		while(check) {
			materials = materialsManager.getMaterialsByDistributor(distributorID);
			ListIterator<Materials> iterator2 = materials.listIterator();
			while(iterator2.hasNext()) {
				Materials mat = iterator2.next();
				System.out.println(mat.getId() + "->" + mat.getName());
			}
			System.out.println("Type your option:");
			System.out.println("1. Order something from the list");
			System.out.println("2. Order a new material from this distributor");
			int choice = Integer.parseInt(reader.readLine());
			Materials m = null;
			
			switch(choice) {
			
			case 1:{
				while(m==null) {
					System.out.println("Type the id of the material you want to order");
					int materialID = Integer.parseInt(reader.readLine());
					m = materialsManager.getMaterialByID(materialID);
					if(m==null) {
						System.out.println("This material doesn´t exist");
					}
				}
				break;
				
			}
			case 2:{
				System.out.println("Type the name:");
				String name = reader.readLine();
				System.out.println("Type the type:");
				String type = reader.readLine();
				System.out.println("Type the price:");
				Float cost = Float.parseFloat(reader.readLine());
			
				m = new Materials(name, type, 0, cost, distributorID);
				materialsManager.addMaterial(m);
				break;
			}
			}
			System.out.println("Type the amount of materials you want to order: ");
				int amount = Integer.parseInt(reader.readLine());
				price = price + m.getPrice()*amount;
				System.out.println("Cost:" + price);
				orderManager.addToOrder(m, o, amount);
				String answer = "";
				while(!answer.equalsIgnoreCase("yes")||!answer.equalsIgnoreCase("no")) {
					System.out.println("Do you want to order other materials?[yes/no]");
					answer = reader.readLine();
					if(answer.equalsIgnoreCase("no")) {
						orderManager.addOrder(o);
						o.setCost(price);
						System.out.println("Your order will cost " + price + "$");
						check = false;
						break;
					}
				}
		}
		
	} 
	
	private static void viewOrders() { // aqui creo que no hace falta el try catch
		List<Order> orders = new ArrayList<Order>();
		System.out.println("\nOrders");
		try {
			orders = orderManager.getListOrder();
			int i;
			for(i=0; i< orders.size(); i++)
			{
				System.out.println(orders.get(i).toString());
			}
		
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void addDoctor() throws Exception {	//done
		
		System.out.println("Type the name:");
		String name = reader.readLine();
		System.out.println("Type the department:");
		String department = reader.readLine();
		System.out.println("Type the email:");
		String email = reader.readLine();
			
		Doctor d = new Doctor(name, department, email);
		doctorManager.addDoctor(d);
		
		xmlManager.doctor2xml(d);
		
		System.out.println("Doctor added");

	}
	
	public static void addNurse() throws Exception {	//done

		System.out.println("Type the name:");
		String name = reader.readLine();
		System.out.println("Type the department:");
		String department = reader.readLine();
		System.out.println("Type the email:");
		String email = reader.readLine();
			
		Nurse n = new Nurse(name, department, email);
		nurseManager.addNurse(n);
		
		xmlManager.nurse2xml(n);
		
		System.out.println("Nurse added");

	}
	
		
	public static void updateDoctor() throws Exception { 	//done
		try {
		showDoctorsID();
		boolean check;
		int doctor_id = 0;
		do {
			System.out.println("Please enter the id of the doctor to update:");
			doctor_id =  Integer.parseInt(reader.readLine());
			check = checkDoctor_id(doctor_id);
		}while (!check);
		
		System.out.println("Please enter the new department:");
		String department = reader.readLine();
		
		doctorManager.updateDepartment(doctor_id, department);
		System.out.println("Doctor department updated");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void updateNurse() throws Exception {		//done
		try {
		showNursesID();
		boolean check;
		int nurse_id;
		do {
			System.out.println("Please enter the id of the nurse to update:");
			nurse_id =  Integer.parseInt(reader.readLine());
			check = checkNurse_id(nurse_id);
		}while(!check);
		System.out.println("Please enter the new department:");
		String department = reader.readLine();
		
		nurseManager.updateDepartment(nurse_id, department);
		System.out.println("Nurse department updated");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void modifyStock() throws Exception { 	//done
		try {
		showMaterialsID();
		boolean check;
		int material_id;
		do {
			System.out.println("Please enter the id of the material:");
			material_id =  Integer.parseInt(reader.readLine());
			check = checkMaterial_id(material_id);
		}while(!check);
		System.out.println("Please enter the new stock:");
		int stock = Integer.parseInt(reader.readLine());
		
		materialsManager.updateStock(material_id, stock);
		System.out.println("Stock modified");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void updateStatus() throws Exception {		//done
		try {
		showOrdersID();
		boolean check;
		int order_id;
		do {
			System.out.println("Please enter the id of the order:");
			order_id =  Integer.parseInt(reader.readLine());
			check = checkOrder_id(order_id);
		}while(!check);
		System.out.println("Please enter the new status:");
		String status = reader.readLine();
		
		orderManager.updateStatus(order_id, status);
		System.out.println("Status updated");
		if(status.equalsIgnoreCase("delivered")) {
			List<Materials> materials = orderManager.getMaterialsOrder(order_id);
			int i;
			for(i=0; i< materials.size(); i++)
			{
				int stock = materials.get(i).getStock();
				materialsManager.updateStock(materials.get(i).getId(), stock);
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	
	public static void deleteDoctor() throws Exception {		//done
		try {
		showDoctorsID();
		int doctor_id;
		boolean check;
		do {
			System.out.println("Please enter the id of the doctor to delete:");
			doctor_id =  Integer.parseInt(reader.readLine());
			check = checkDoctor_id(doctor_id);
		}while(!check);
		doctorManager.removeDoctor(doctor_id);
		System.out.println("Doctor deleted");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteNurse() throws Exception {			//done
		try {
		showNursesID();
		boolean check;
		int nurse_id;
		do {
			System.out.println("Please enter the id of the doctor to delete:");
			nurse_id =  Integer.parseInt(reader.readLine());
			check = checkNurse_id(nurse_id);
		}while(!check);
		nurseManager.removeNurse(nurse_id);
		System.out.println("Nurse deleted");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteTreatment() throws Exception {		//done
		try {
		showTreatmentsID();
		boolean check;
		int treatment_id;
		
		do {
			System.out.println("Please enter the id of the treatment to delete:");
			treatment_id =  Integer.parseInt(reader.readLine());
			check = checkTreatment_id(treatment_id);
		}while(!check);
		treatmentManager.removeTreatment(treatment_id);
		
		System.out.println("Treatment deleted");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteMaterial() throws Exception {		//done
		try {
		showMaterialsID();
		boolean check;
		int material_id;
		do {
			System.out.println("Please enter the id of the material to delete:");
			material_id =  Integer.parseInt(reader.readLine());
			check = checkMaterial_id(material_id);
		}while(!check);
		materialsManager.removeMaterial(material_id);
		
		System.out.println("Material deleted");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void viewTreatments() {		//creo que sobra try catch
		List<Treatment> treatments = new ArrayList<Treatment>();
		System.out.println("\nTreatments");
		try {
			treatments = treatmentManager.getListTreatments();
			int i;
			for(i=0; i< treatments.size(); i++)
			{
				System.out.println(treatments.get(i).toString());
			}
		
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void viewStocks() throws Exception { //creo que sobra try catch
		// TODO Auto-generated method stub
		List<Materials> materials = new ArrayList<Materials>();
		System.out.println("\nStock");
		
		try {
			materials = materialsManager.getListMaterials();
			int i;
			for(i=0; i< materials.size(); i++)
			{
				System.out.println(materials.get(i).stockToString());
			}
		
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void searchStock() throws Exception{ //done
		// TODO Auto-generated method stub
		try {
		showMaterialsID();
		System.out.println("Please choose a material, type its ID:");
		Integer material_id = Integer.parseInt(reader.readLine());
		Materials m = new Materials();
		m = materialsManager.getMaterialByID(material_id);
		System.out.println(m.stockToString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	} 
	
	
	//SHOW ALL ID'S METHODS FOR ALL CLASSES
	
	private static void showDoctorsID() {
		List<Doctor> doctors = new ArrayList<Doctor>();
		doctors = doctorManager.getListDoctor();
		ListIterator<Doctor> iterator =  doctors.listIterator();
		System.out.println();
		while(iterator.hasNext()) {
			Doctor doc = iterator.next();
			System.out.println(doc.getId() + "->" + doc.getName());
		}
	}
	
	private static void showNursesID() {
		List<Nurse> nurses = new ArrayList<Nurse>();
		nurses = nurseManager.getListNurse();
		ListIterator<Nurse> iterator =  nurses.listIterator();
		System.out.println();
		while(iterator.hasNext()) {
			Nurse nur = iterator.next();
			System.out.println(nur.getId() + "->" + nur.getName());
		}
	}
	
	private static void showOrdersID() {
		List<Order> orders = new ArrayList<Order>();
		orders = orderManager.getListOrder();
		ListIterator<Order> iterator =  orders.listIterator();
		System.out.println();
		while(iterator.hasNext()) {
			Order ord = iterator.next();
			System.out.println(ord.getId());
		}
	}

	private static void showTreatmentsID() {
		List<Treatment> treatments = new ArrayList<Treatment>();
		treatments = treatmentManager.getListTreatments();
		ListIterator<Treatment> iterator =  treatments.listIterator();
		System.out.println();
		while(iterator.hasNext()) {
			Treatment tre = iterator.next();
			System.out.println(tre.getId() + "->" + tre.getName());
		}
	}
	
	private static void showMaterialsID() {
		List<Materials> materials = new ArrayList<Materials>();
		materials = materialsManager.getListMaterials();
		ListIterator<Materials> iterator =  materials.listIterator();
		System.out.println();
		while(iterator.hasNext()) {
			Materials mat= iterator.next();
			System.out.println(mat.getId() + "->" + mat.getName());
		}
	}
	
	private static void showDistributorsID() {
		List<Distribuitor> distributors = new ArrayList<Distribuitor>();
		distributors = distributorManager.getlistDistributors();
		ListIterator<Distribuitor> iterator =  distributors.listIterator();
		System.out.println();
		while(iterator.hasNext()) {
			Distribuitor dist= iterator.next();
			System.out.println(dist.getId() + "->" + dist.getName());
		}
	}
	
	private static void signup() throws Exception{
		System.out.println("\nWhat type of sign up do you want to do?");
		System.out.println("1. As a administrator");
		System.out.println("2. As a doctor");
		System.out.println("3. As a nurse");
		
		int choice = Integer.parseInt(reader.readLine());
		
		System.out.println("Name:");
		String name = reader.readLine();
		
		System.out.println("Email:");
		String email = reader.readLine();
		
		System.out.println("Password: ");
		String passwd = reader.readLine();
		User u = null;
		Role r = null;
		
		switch(choice) {
			case 1:{
				r = userManager.getRoleByName("administrator");
				u = new User(email, passwd.getBytes(),r);
				userManager.newUser(u);
				Administrator a = new Administrator(name, email);
				administratorManager.addAdministrator(a);
				break;
			}
			case 2:{
				System.out.println("Department:");
				String department = reader.readLine();
				Doctor d = new Doctor(name, department, email);
				doctorManager.addDoctor(d);
				r = userManager.getRoleByName("doctor");
				u = new User(email, passwd.getBytes(),r);
				userManager.newUser(u);
				break;
			}
			case 3:{
				System.out.println("Department:");
				String department = reader.readLine();
				Nurse n = new Nurse(name, department, email);
				nurseManager.addNurse(n);
				r = userManager.getRoleByName("nurse");
				u = new User(email, passwd.getBytes(),r);
				userManager.newUser(u);
				break;
			}
			default: 
				break;
		}
		
	}
	public static void addAdministrator() throws Exception {	//done

		System.out.println("Type the name:");
		String name = reader.readLine();
		System.out.println("Type the email:");
		String email = reader.readLine();
			
		Administrator a = new Administrator(name, email);
		administratorManager.addAdministrator(a);
		
		System.out.println("Administrator added");

	}
	
	public static void addTreatment()throws Exception{
		try {
		System.out.println("Type the name:");
		String name = reader.readLine();
		System.out.println("Type the date[YYYY-MM-DD]:");
		String dateString = reader.readLine();
		Date date = Date.valueOf(dateString);
		System.out.println("Type the time[HH:MM]:");
		String time = reader.readLine();
		System.out.println("Type the name of the patient:");
		String patient = reader.readLine();
		
		List<Doctor> docs = new ArrayList<Doctor>();
		System.out.println("List of doctors");
		boolean op = false;
		while (!op) {
			showDoctorsID();
			System.out.println("Type the id of the doctor");
			int doc_id = Integer.parseInt(reader.readLine());
			Doctor d = doctorManager.getDoctorByID(doc_id);
			if(docs.contains(d)) {
				System.out.println("This doctor is already assigned to this treatment");
			}else {
				docs.add(d);				
			}
			System.out.println("Do you want to add another doctor to this treatment?");
			String a  = reader.readLine();
			if (a.equalsIgnoreCase("no")) {
				op = true;
			}
		}
		
		List <Nurse> nurs = new ArrayList<Nurse>();
		System.out.println("List of nurses");
		op = false;
		while (!op) {
			showNursesID();
			System.out.println("Type the id of the nurse");
			int nur_id = Integer.parseInt(reader.readLine());
			Nurse n = nurseManager.getNurseByID(nur_id);
			if(nurs.contains(n)) {
				System.out.println("This nurse is already assigned to this treatment");
			}else {
				nurs.add(n);				
			}
			System.out.println("Do you want to add another nurse to this treatment?");
			String a  = reader.readLine();
			if (a.equalsIgnoreCase("no")) {
				op = true;
			}
		}
		
		Treatment t = new Treatment(name,date,time,patient, docs, nurs);
		t.setDoctores(docs);
		treatmentManager.addTreatment(t);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void modifyMaterial() {
		try {
			int mat_id;
			boolean check;
			showMaterialsID();
			System.out.println("\nWhat material do you want to edit?:");
			mat_id = Integer.parseInt(reader.readLine());
			check = checkMaterial_id(mat_id);
			while(!check) {
				System.out.println("Material not found. Please try again");
				mat_id = Integer.parseInt(reader.readLine());
				check = checkMaterial_id(mat_id);
			}
			/*do {
				showMaterialsID();
				System.out.println("\nWhat material do you want to edit?:");
				mat_id = Integer.parseInt(reader.readLine());
				check = checkMaterial_id(mat_id);
			}while(!check);*/
	
			Materials m = materialsManager.getMaterialByID(mat_id);
			System.out.println("\n"+m.toString());
			//check = true;
			while(check) {
				System.out.println("\nWhat do you want to edit?:");
				System.out.println("1.Name");
				System.out.println("2.Type");
				System.out.println("3.Stock");
				System.out.println("4.Price");
				
				int choice = Integer.parseInt(reader.readLine());
					while (choice<1 || choice >4) {
						System.out.println("Option not valid. Please enter a valid option (1-4).");
						choice = Integer.parseInt(reader.readLine());
					}
				
				switch(choice) {
				case 1:{
					System.out.println("Type the new name:");
					String name = reader.readLine();
					m.setName(name);
					break;
				}
				case 2:{
					System.out.println("Type the new type:");
					String type = reader.readLine();
					m.setType(type);
					break;
				}
				case 3:{
					System.out.println("Type the new Stock:");
					int stock = Integer.parseInt(reader.readLine());
					m.setStock(stock);
					break;
				}
				case 4:{
					System.out.println("Type the new price:");
					float price = Float.parseFloat(reader.readLine());
					m.setPrice(price);;
					break;
				}
				default:
					break;
				}
				System.out.println("Do you want to edit something else?");
				String answer = reader.readLine();
				if(answer.equalsIgnoreCase("no")) {
					System.out.println(m.toString());
					materialsManager.changeMaterial(m);
					check = false;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	private static void printMe() {
		try {
		showDoctorsID();
		System.out.println("Which doctor do you want to save?");
		int id = Integer.parseInt(reader.readLine());
		xmlManager.doctorID2xml(id);;
		xmlManager.simpleTransform("./xmls/Doctor.xml", "./xmls/Doctor-Style.xslt", "./xmls/Doctor.html");
		
		System.out.println("Doctor saved");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void printMeNurse() {
		try {
		showNursesID();
		System.out.println("Which nurse do you want to save?");
		int id = Integer.parseInt(reader.readLine());
		Nurse n = nurseManager.getNurseByID(id);
		xmlManager.nurse2xml(n);;
		
		System.out.println("Doctor saved");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
