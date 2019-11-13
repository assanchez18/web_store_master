package sergio_sanchez.practica1_web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class TrolleyController {

	//@Autowired
	//private Usuario usuario;

	private List<Order> orders= new ArrayList<Order>();
	//private List<Item> orders = new ArrayList<Item>();

	public TrolleyController() {
		orders.add(new Order("1"));
		orders.add(new Order("2"));
		orders.get(0).add(new Item("Air Jordan 1"));
		orders.get(0).add(new Item("Adidas copa mundial"));
		orders.get(1).add(new Item("VaporMax"));
	}

	@GetMapping("/")
	public String tablon(Model model, HttpSession session) {

		model.addAttribute("orders", orders);
		model.addAttribute("bienvenida", session.isNew());

		return "Trolley";
	}
/*
	@PostMapping("/Item/nuevo")
	public String nuevoItem(Model model, Item Item) {

		Items.add(Item);

		usuario.setNombre(Item.getNombre());
		usuario.incItems();

		return "Item_guardado";

	}
*/
	@GetMapping("/Order/nuevo_form")
	public String newOrderForm(Model model) {

		model.addAttribute("name");

		return "new_order";
	}

	@GetMapping("/Order/{num}")
	public String nuevoItem(Model model, @PathVariable int num) {

		Order order = orders.get(num - 1);

		model.addAttribute("order", order);
		model.addAttribute("items", order.getItems());

		return "show_order";
	}
}