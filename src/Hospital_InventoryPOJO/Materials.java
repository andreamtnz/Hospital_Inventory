package Hospital_InventoryPOJO;

import java.io.Serializable;
import java.util.Objects;

public class Materials implements Serializable{

	private Integer id;
	private String name;
	private String type;
	private Integer stock;
	private Float price;
	private Integer distribuidor;
	
	
	public Materials() {
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(Integer distribuidor) {
		this.distribuidor = distribuidor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(distribuidor, id, name, price, stock, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materials other = (Materials) obj;
		return Objects.equals(distribuidor, other.distribuidor) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(price, other.price)
				&& Objects.equals(stock, other.stock) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Materials [id=" + id + ", name=" + name + ", type=" + type + ", stock=" + stock + ", price=" + price
				+ ", distribuidor=" + distribuidor + "]";
	}

	
	
}
