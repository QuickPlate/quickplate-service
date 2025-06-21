package restaurant_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import restaurant_service.dto.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
