package Hospital_InventoryPOJO;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Treatment implements Serializable{

	private Integer id;
	private String name;
	private Timestamp date;
	private String patient;
	private List<Doctor> doctores;
	
	
	public Treatment() {
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
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
	public String getPatient() {
		return patient;
	}
	public void setPatient(String patient) {
		this.patient = patient;
	}


	


	public List<Doctor> getDoctores() {
		return doctores;
	}


	public void setDoctores(List<Doctor> doctores) {
		this.doctores = doctores;
	}


	@Override
	public int hashCode() {
		return Objects.hash(date, doctores, id, name, patient);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Treatment other = (Treatment) obj;
		return Objects.equals(date, other.date) && Objects.equals(doctores, other.doctores)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(patient, other.patient);
	}


	@Override
	public String toString() {
		return "Treatment [id=" + id + ", name=" + name + ", date=" + date + ", patient=" + patient + ", doctores="
				+ doctores + "]";
	}


	


	


	
	
}
