package restaurant_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import restaurant_service.dto.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, String> {


}
