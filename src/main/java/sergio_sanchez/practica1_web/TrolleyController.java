package sergio_sanchez.practica1_web;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TrolleyController {

	@Autowired
	private TrolleyRepository trolleyRepository;
	@Autowired
	private ItemsRepository itemsRepository;

	public TrolleyController() {
	}

	@PostConstruct
	public void init() {
		Item item1 = new Item("Air Jordan 1");
		Item item2 = new Item( "Adidas copa mundial");
		Item item3 = new Item("VaporMax");
		trolleyRepository.flush();
		itemsRepository.flush();
		trolleyRepository.save(new Order("PEPE").add(item1).add(item2));
		trolleyRepository.save(new Order("JUAN").add(item3));
		itemsRepository.save(item1);
		itemsRepository.save(item2);
		itemsRepository.save(item3);
	}

	@GetMapping("/")
	public String tablon(Model model ) {
		model.addAttribute("orders", trolleyRepository.findAll());
		return "index";
	}
	
	@GetMapping("/Orders/Edit/{id}")
	public String editOrder(Model model, @PathVariable long id) {
		model.addAttribute("orders", trolleyRepository.findAll());
		return "edit_order";
	}
	
	
	@PostMapping("/Orders/New")
	public String nuevoItem(Model model,  @RequestParam String description, @RequestParam(value="element[]") String[] elements) {
		Order order = new Order(description);		
		for (int i = 0; i < elements.length; i++) {
			order.add(new Item(elements[i]));
		}
		trolleyRepository.save(order);
		for(Item item : order.getItems()) {
			itemsRepository.save(item);
		}
		
		return "saved_order";
	}
	 
	@GetMapping("/Orders/New")
	public String newOrderForm(Model model) {
		model.addAttribute("name");
		return "new_order";
	}

	@GetMapping("/Order/{id}")
	public String nuevoItem(Model model, @PathVariable long id) {
		model.addAttribute("order", trolleyRepository.findById(id).get().getName());
		model.addAttribute("items", itemsRepository.findItemsFromOrder(id));
		model.addAttribute("id", id);
		return "show_order";
	}
}