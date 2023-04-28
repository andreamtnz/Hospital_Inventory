package Hospital_InventoryPOJO;

import java.io.Serializable;
import java.util.Objects;

public class Administrator implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3811233637153096668L;
	
	private Integer id;
	private String name;
	private String email;
	
	public Administrator() {
		super();
	}
	
	public Administrator (String nameAd, String email) {
		this.name = nameAd;
		this.email = email;
	}
	public Administrator(Integer id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrator other = (Administrator) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Administrator [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
