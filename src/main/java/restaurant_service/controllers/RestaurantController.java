package restaurant_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import restaurant_service.dto.Customer;
import restaurant_service.dto.Meal;
import restaurant_service.dto.Order;
import restaurant_service.service.RestaurantService;

@RestController
public class RestaurantController {
	
	@Autowired
	private RestaurantService service;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/meals")
	public ResponseEntity<List<Meal>> meals() throws JsonMappingException, JsonProcessingException {
		System.out.println("Getting meals...");
		List<Meal> mealList = service.getMeals();
//		ObjectMapper mapper = new ObjectMapper();
//		List<Meal> mealList = mapper.readValue(meals, new TypeReference<List<Meal>>() {});
		return ResponseEntity.ok(mealList);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getOrders() throws JsonMappingException, JsonProcessingException {
		System.out.println("Getting orders...");
		List<Order> orderList = service.getOrders();
		return ResponseEntity.ok(orderList);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/orders")
	public ResponseEntity<Order> createOrder(@RequestBody Order order) throws JsonMappingException, JsonProcessingException {
		System.out.println("Updating orders...");
		Order newOrder = service.createOrder(order);
		return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
	}

	
	@CrossOrigin(origins = "*")
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomers() throws JsonMappingException, JsonProcessingException {
		System.out.println("Getting customers...");
		List<Customer> customerList = service.getCustomers();
		return ResponseEntity.ok(customerList);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/customers")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) throws JsonMappingException, JsonProcessingException {
		System.out.println("Updating customers...");
		Customer newCustomer = service.createCustomer(customer);
		return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
	}
}
