package Hospital_InventoryPOJO;

import java.util.Objects;

public class Needs {

	private Integer quantity;
	private Integer treatment;
	private Integer material;
	
	public Needs() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(material, quantity, treatment);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Needs other = (Needs) obj;
		return Objects.equals(material, other.material) && Objects.equals(quantity, other.quantity)
				&& Objects.equals(treatment, other.treatment);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getTreatment() {
		return treatment;
	}

	public void setTreatment(Integer treatment) {
		this.treatment = treatment;
	}

	public Integer getMaterial() {
		return material;
	}

	public void setMaterial(Integer material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Needs [quantity=" + quantity + ", treatment=" + treatment + ", material=" + material + "]";
	}
	
	
}
