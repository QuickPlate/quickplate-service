package restaurant_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import restaurant_service.dto.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

}
