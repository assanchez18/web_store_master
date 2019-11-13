package sergio_sanchez.practica1_web;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private List<Item> items;
	private String name;
	
	public Order(String name) {
		super();
		this.items = new ArrayList<Item>();
		this.name = name;
	}
	
	public void add(List<Item> items) {
		this.items = items;
	}
	
	public void add(Item item) {
		this.items.add(item);
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
	
}
