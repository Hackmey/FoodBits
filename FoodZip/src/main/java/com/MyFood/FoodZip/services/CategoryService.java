package com.MyFood.FoodZip.services;

import com.MyFood.FoodZip.exception.RestaurantException;
import com.MyFood.FoodZip.models.FoodCategory;

import java.util.List;


public interface CategoryService {
	
	public FoodCategory createCategory (String name, Long userId) throws RestaurantException;
	public List<FoodCategory> findCategoryByRestaurantId(Long restaurantId) throws RestaurantException;
	public FoodCategory findCategoryById(Long id) throws RestaurantException;

}
