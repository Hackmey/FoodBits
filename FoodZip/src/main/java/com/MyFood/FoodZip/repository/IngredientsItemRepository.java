package com.MyFood.FoodZip.repository;

import java.util.List;

import com.MyFood.FoodZip.models.IngredientCategory;
import com.MyFood.FoodZip.models.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IngredientsItemRepository extends JpaRepository<Ingredients, Long> {

	
	List<Ingredients> findByRestaurantId(Long id);

//	@Query("SELECT e FROM IngredientsItem e "
//			+ "WHERE e.restaurant.id = :restaurantId "
//			+ "AND lower(e.name) = lower(:name)"
//			+ "AND e.category.name = :categoryName")
//	Ingredients findByRestaurantIdAndNameIngoreCase(
//			@Param("restaurantId") Long restaurantId,
//			@Param("name") String name,
//			@Param("categoryName") String categoryName);
}
