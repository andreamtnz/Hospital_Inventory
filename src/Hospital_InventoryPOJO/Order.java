package Hospital_InventoryPOJO;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2139695442355747482L;
	
	
	private Integer id;
	private String state;
	private Date date;
	private Float cost;
	private Integer administrador;
	
	public Order() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}
	

	public Integer getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Integer administrador) {
		this.administrador = administrador;
	}

	@Override
	public int hashCode() {
		return Objects.hash(administrador, cost, date, id, state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(administrador, other.administrador) && Objects.equals(cost, other.cost)
				&& Objects.equals(date, other.date) && Objects.equals(id, other.id)
				&& Objects.equals(state, other.state);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", state=" + state + ", date=" + date + ", cost=" + cost + ", administrador="
				+ administrador + "]";
	}

	
	
	
}
