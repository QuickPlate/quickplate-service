package restaurant_service.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_items") // A specific table for items in an order
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private int quantity;

    // Relationship to the actual Meal from the menu (optional, but good for lookup)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meal_id") // Foreign key to the meals table
    private Meal meal; // Reference to the actual Meal entity

    // Relationship to the Order it belongs to
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id") // Foreign key to the orders table
    private Order order;
    
    public CartItem() {}

    // Getters and Setters for all fields (id, name, price, quantity, meal, order)
    public int getId() { 
    	return id; 
    }
    
    public void setId(int id) { 
    	this.id = id; 
    }
    
    public String getName() { 
    	return name; 
    }
    public void setName(String name) { 
    	this.name = name; 
    }
    
    public double getPrice() { 
    	return price; 
    }
    
    public void setPrice(double price) { 
    	this.price = price; 
    }
    
    public int getQuantity() { 
    	return quantity; 
    }
    
    public void setQuantity(int quantity) { 
    	this.quantity = quantity; 
    }
    
    public Meal getMeal() { 
    	return meal; 
    }
    
    public void setMeal(Meal meal) { 
    	this.meal = meal; 
    }
    
    public Order getOrder() { 
    	return order; 
    }
    
    public void setOrder(Order order) { 
    	this.order = order; 
    }
}