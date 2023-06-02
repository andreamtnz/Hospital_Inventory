package Hospital_InventoryPOJO;

import java.io.Serializable;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class Treatment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7444340460612287385L;
	
	private Integer id;
	private String name;
	private Date date;
	private String time;
	private String patient;
	private List<Doctor> doctores;
	private List<Nurse> nurses;
	
	
	public Treatment() {
		super();
	}
	
	public Treatment(Integer id, String name, Date date, String time, String patient) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.time = time;
		this.patient = patient;
	}
	
	public Treatment(Integer id, String name, Date date, String time, String patient, List<Doctor> doctors, List<Nurse> nurses) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.time = time;
		this.patient = patient;
		this.doctores = doctors;
		this.nurses = nurses;
	}
	
	public Treatment( String name, Date date, String time, String patient, List<Doctor> doctors, List<Nurse> nurses) {
		this.name = name;
		this.date = date;
		this.time = time;
		this.patient = patient;
		this.doctores = doctors;
		this.nurses = nurses;
	}
		
	public Treatment(String name, Date date, String time, String patient) {
		this.name = name;
		this.date = date;
		this.time = time;
		this.patient = patient;
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


	

	public List<Nurse> getNurses() {
		return nurses;
	}


	public void setNurses(List<Nurse> nurses) {
		this.nurses = nurses;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	@Override
	public int hashCode() {
		return Objects.hash(date, doctores, id, name, nurses, patient, time);
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
				&& Objects.equals(nurses, other.nurses) && Objects.equals(patient, other.patient)
				&& Objects.equals(time, other.time);
	}


	@Override
	public String toString() {
	
		return "id=" + id + "	name=" + name + "	date=" + date.toString() + "	time=" + time + "	patient=" + patient;
	}
}
