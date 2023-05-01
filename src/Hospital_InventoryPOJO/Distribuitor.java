package Hospital_InventoryPOJO;

import java.io.Serializable;
import java.util.Objects;

public class Distribuitor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2751233094345411814L;
	
	
	private Integer id;
	private String name;
	private String type;
	
	public Distribuitor() {
		super();
	}
	
	public Distribuitor (String name, String type) {
		this.name = name;
		this.type = type;

	}
	public Distribuitor (Integer id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Distribuitor other = (Distribuitor) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Distribuitor [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
	
	
}
