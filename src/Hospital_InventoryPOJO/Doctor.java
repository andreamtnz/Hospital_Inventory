package Hospital_InventoryPOJO;

import java.io.Serializable;
import java.util.Objects;

public class Doctor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6814603893152445627L;
	
	
	private Integer id;
	private String name;
	private String department;
	
	public Doctor() {
		super();
	}
	
	public Doctor (String name, String department) {
		this.name = name;
		this.department = department;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(department, id, name);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		return Objects.equals(department, other.department) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}



	public Integer getId() {
		return id;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}



	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", department=" + department + "]";
	}
	
}
