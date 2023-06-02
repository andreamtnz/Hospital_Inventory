
package Hospital_InventoryJPA;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Hospital_InventoryPOJO.Role;
import Hospital_InventoryPOJO.User;
import Hospital_inventoryInterfaces.UserManager;

public class JPAUserManager implements UserManager{
	
	private EntityManager em ; 
	
	public JPAUserManager() {
		this.connect();
	}

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		
		em = Persistence.createEntityManagerFactory("Hospital_Inventory-provider").createEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		em.getTransaction().commit();
		
		if(this.getRoles().isEmpty()) {
			Role administrator = new Role("administrator");
			Role doctor = new Role("doctor");
			Role nurse = new Role("nurse");
			this.newRole(administrator);
			this.newRole(doctor);
			this.newRole(nurse);
		}
		
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		
		em.close();
		
	}

	@Override
	public void newUser(User u) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		
	}
	

	@Override
	public void newRole(Role r) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
	}

	@Override
	public Role getRole(String email) {
		// TODO Auto-generated method stub
		Query q = em.createNativeQuery("SELECT roles FROM user WHERE email=?", Role.class);
		q.setParameter(1, email);
		Role r = (Role) q.getSingleResult();
		return r;
	}

	
	@Override
	public List<Role> getRoles() {
		// TODO Auto-generated method stub
		Query q = em.createNativeQuery("SELECT * FROM roles", Role.class);
		List<Role> roles = (List<Role>) q.getResultList();
		
		return roles;
	}

	@Override
	public User checkPassword(String email, String passwd) {
		// TODO Auto-generated method stub
		User u = null;
		
		Query q = em.createNativeQuery("Select * from users where email =? AND password = ?", User.class);
		q.setParameter(1, email);
		q.setParameter(2, passwd.getBytes());
		/*try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(passwd.getBytes());
			byte[] digest = md.digest();
			q.setParameter(2,digest);
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}*/
		
		try {
			u = (User) q.getSingleResult(); // if there is any user with this email and password we should get a result
			
		}catch(NoResultException e) {}
		
		return u;
	}

	@Override
	public Role getRoleByName(String name) {
		// TODO Auto-generated method stub
		Role r = null;
		Query q = em.createNativeQuery("Select * from roles where name=?", Role.class);
		q.setParameter(1, name);
		try {
			r = (Role) q.getSingleResult(); 
			
		}catch(NoResultException e) {}
		return r;
	}

	@Override
	public void changePassword(User u, String password) {
		// TODO Auto-generated method stub
		u.setPassword(password.getBytes());
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		System.out.println("Password changed!");
	}
	

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		Query q = em.createNativeQuery("SELECT * FROM user", User.class);
		List<User> users = (List<User>) q.getResultList();
		
		return users;
	}
}
