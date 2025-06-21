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

        Customer customer = order.getCustomer(); 
        Customer customerToLink = null;

        if (customer != null && customer.getEmail() != null) {
            Optional<Customer> existingCustomer = customerRepository.findByEmail(customer.getEmail());

            if (existingCustomer.isPresent()) {
                customerToLink = existingCustomer.get();
            }
            else {
                Customer newCustomer = new Customer();
                newCustomer.setName(customer.getName());
                newCustomer.setEmail(customer.getEmail());
                customerToLink = customerRepository.save(newCustomer);
            }
        }
        else {
             customerToLink = customerRepository.findById(1).orElseThrow(
            		 () -> new RuntimeException("Default customer (ID 1) not found!"));
        }
        newOrder.setCustomer(customerToLink);
		newOrder.setStreet(order.getStreet());
		newOrder.setCity(order.getCity());
		newOrder.setZip(order.getZip());
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
