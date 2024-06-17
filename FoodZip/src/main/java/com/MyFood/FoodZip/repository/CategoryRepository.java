package com.MyFood.FoodZip.repository;

import java.util.List;

import com.MyFood.FoodZip.models.Food;
import com.MyFood.FoodZip.models.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<FoodCategory, Long> {

	public List<FoodCategory> findByRestaurantId(Long id);
}
