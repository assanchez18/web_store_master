package sergio_sanchez.practica1_web;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="ORDERS_T")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> items;
	private String name;
	
	public Order() {}
	
	public Order(String name) {
		super();
		this.name = name;
		this.items = new ArrayList<Item>();
	}
	
	public Order(String name, List<Item> items) {
		super();
		this.items = items;
		this.name = name;
	}
	
	public void add(List<Item> items) {
		this.items = items;
	}
	
	public Order add(Item item) {
		this.items.add(item);
		return this;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return "Order " + this.name + ": ";
	}
	
	public List<Item> getItems() {
		return this.items;
	}
	
	public long getId() {
		return this.id;
	}
	
}
