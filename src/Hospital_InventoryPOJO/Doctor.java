package Hospital_InventoryPOJO;

import java.io.Serializable;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Doctor")
@XmlType(propOrder = {"email", "department"})
public class Doctor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6814603893152445627L;
	
	@XmlTransient
	private Integer id;
	@XmlAttribute
	private String name;
	@XmlElement
	private String department;
	@XmlElement
	private String email;
	
	public Doctor() {
		super();
	}
	
	public Doctor ( String name, String department, String email) {
		this.name = name;
		this.department = department;
		this.email = email;
	}
	
	public Doctor (Integer id, String name, String department, String email) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.email = email;
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", department=" + department + ", email=" + email + "]";
	}
	
}
