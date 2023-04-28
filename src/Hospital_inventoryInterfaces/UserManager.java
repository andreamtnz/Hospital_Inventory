package Hospital_inventoryInterfaces;

import java.util.List;

import Hospital_InventoryPOJO.Role;
import Hospital_InventoryPOJO.User;

public interface UserManager {

	public void connect();
	public void disconnect();
	public void newUser(User u);
	public void newRole(Role r);
	
	public Role getRole(String email);
	
	public List<Role> getRoles();
	
	public User checkPassword(String email, String passwd);
	
}

