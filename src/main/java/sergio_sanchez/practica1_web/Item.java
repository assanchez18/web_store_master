package sergio_sanchez.practica1_web;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITEMS_T")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	private String name;

	public Item() {
		this.name = "no_name";
	}
	
	public Item(String name) {
		this.name = name;
	}
	
	public String getStringName() {
		return this.name;
	}
}
