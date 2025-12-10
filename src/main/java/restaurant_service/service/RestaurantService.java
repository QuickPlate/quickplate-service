package restaurant_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restaurant_service.dto.Meal;
import restaurant_service.dto.Order;
import restaurant_service.dto.Customer;
import restaurant_service.dto.CartItem;
import restaurant_service.repository.MealRepository;
import restaurant_service.repository.OrderRepository;
import restaurant_service.repository.CustomerRepository;
import restaurant_service.repository.CartItemRepository;

@Service
public class RestaurantService {
	@Autowired
	private MealRepository mealRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CartItemRepository cartItemRepository;
	
	public List<Meal> getMeals() {
		List<Meal> meals = mealRepository.findAll();
		return meals;
	}
	
	public List<Order> getOrders() {
		List<Order> orders = orderRepository.findAll();
		return orders;
	}
	
	public Order createOrder(Order order) {
	    Order newOrder = new Order();

	    String safeEmail = "demo@quickplate.com";
	    String safeName = "DemoUser";
	    
	    Customer customerToLink = null;
	    Optional<Customer> existingCustomer = customerRepository.findByEmail(safeEmail);

	    if (existingCustomer.isPresent()) {
	        customerToLink = existingCustomer.get();
	    } else {
	        Customer newCustomer = new Customer();
	        newCustomer.setName(safeName);
	        newCustomer.setEmail(safeEmail);
	        customerToLink = customerRepository.save(newCustomer);
	    }
	    
	    newOrder.setCustomer(customerToLink);
	    
	    newOrder.setStreet("1234 Demo Lane");
	    newOrder.setCity("Faketown");
	    newOrder.setZip("00000");
	    // --- SECURITY SWAP END ---

	    newOrder = orderRepository.save(newOrder);

	    for (CartItem cartItem : order.getCart()) {
	        CartItem cartItemData = new CartItem();
	        cartItemData.setName(cartItem.getName());
	        cartItemData.setPrice(cartItem.getPrice());
	        cartItemData.setQuantity(cartItem.getQuantity());

	        Meal meal = mealRepository.findById(cartItem.getMeal().getId())
	                .orElseThrow(() -> new RuntimeException("Meal not found with ID: " + cartItem.getMeal().getId()));
	        cartItemData.setMeal(meal);

	        newOrder.addCartItem(cartItemData);
	    }

	    return orderRepository.save(newOrder);
	}
	
	public List<Customer> getCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return customers;
	}
	
	public Customer createCustomer(Customer customer) {
//		if customerRepository.findAll();
		customer.setName("DemoUser");
		customer.setEmail("demo@quickplate.com");
		return customerRepository.save(customer);
	}
	
	public List<CartItem> getCartItems() {
		List<CartItem> cartItems = cartItemRepository.findAll();
		return cartItems;
	}
	
	public CartItem createCartItem(CartItem cartItem) {
		return cartItemRepository.save(cartItem);
	}

}
