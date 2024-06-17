package com.MyFood.FoodZip.services;

import java.util.List;

import com.MyFood.FoodZip.exception.FoodException;
import com.MyFood.FoodZip.exception.RestaurantException;
import com.MyFood.FoodZip.models.Food;
import com.MyFood.FoodZip.models.FoodCategory;
import com.MyFood.FoodZip.models.Restaurant;
import com.MyFood.FoodZip.requests.CreateFoodRequest;


public interface FoodService {

	public Food createFood(CreateFoodRequest req, FoodCategory category,
						   Restaurant restaurant) throws FoodException, RestaurantException;

	void deleteFood(Long foodId) throws FoodException;
	
	public List<Food> getRestaurantsFood(Long restaurantId,
			boolean isVegetarian, boolean isNonveg, boolean isSeasonal,String foodCategory) throws FoodException;
	
	public List<Food> searchFood(String keyword);
	
	public Food findFoodById(Long foodId) throws FoodException;

	public Food updateAvailibilityStatus(Long foodId) throws FoodException;
}
