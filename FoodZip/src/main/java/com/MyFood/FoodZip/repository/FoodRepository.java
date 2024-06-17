package com.MyFood.FoodZip.repository;

import java.util.List;

import com.MyFood.FoodZip.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface FoodRepository extends JpaRepository<Food, Long> {

	
	List<Food> findByRestaurantId(Long restaurantId);
	
	@Query("SELECT f FROM Food f WHERE "
			+ "f.name LIKE %:keyword% OR "
			+ "f.foodCategory.name LIKE %:keyword% AND "
			+ "f.restaurant!=null"
	)
	List<Food> searchByNameOrCategory(@Param("keyword") String keyword);


	

}
