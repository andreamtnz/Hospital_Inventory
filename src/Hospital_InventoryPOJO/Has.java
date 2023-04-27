package Hospital_InventoryPOJO;

import java.io.Serializable;
import java.util.Objects;

public class Has implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8796055926873154708L;
	
	
	private Integer quantity;
	private Integer order;
	private Integer material;
	
	public Has() {
		super();
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getMaterial() {
		return material;
	}

	public void setMaterial(Integer material) {
		this.material = material;
	}

	@Override
	public int hashCode() {
		return Objects.hash(material, order, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Has other = (Has) obj;
		return Objects.equals(material, other.material) && Objects.equals(order, other.order)
				&& Objects.equals(quantity, other.quantity);
	}

	@Override
	public String toString() {
		return "Has [quantity=" + quantity + ", order=" + order + ", material=" + material + "]";
	}
	
}
