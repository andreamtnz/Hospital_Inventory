package Hospital_InventoryPOJO;

import java.io.Serializable;
import java.util.Objects;

public class Nurse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8433821717626078517L;
	
	private Integer id;
	private String name;
	private String department;
	
	public Nurse() {
		super();
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
		Nurse other = (Nurse) obj;
		return Objects.equals(department, other.department) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Nurse [id=" + id + ", name=" + name + ", department=" + department + "]";
	}

	
}
