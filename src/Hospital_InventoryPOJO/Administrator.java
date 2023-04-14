package Hospital_InventoryPOJO;

import java.io.Serializable;
import java.util.Objects;

public class Administrator implements Serializable {
	
	
	private Integer id;
	private String name;
	
	public Administrator() {
		super();
	}
	
	public Administrator (String nameAd) {
		super();
		this.name = nameAd;
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

	@Override
	public String toString() {
		return "Administrator [id=" + id + ", name=" + name + "]";
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
	
	

}
