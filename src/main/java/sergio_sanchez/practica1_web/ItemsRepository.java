package sergio_sanchez.practica1_web;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemsRepository extends JpaRepository<Item, Long>{
	@Query(
			value = "SELECT * FROM ITEMS_T item WHERE ID IN (select ITEMS_ID from ORDERS_T_ITEMS where ORDER_ID = ?1)",
			nativeQuery = true)
			ArrayList<Item> findItemsFromOrder(long orderId);
}
