package com.MyFood.FoodZip.services;

import java.util.List;

import com.MyFood.FoodZip.exception.RestaurantException;
import com.MyFood.FoodZip.models.IngredientCategory;
import com.MyFood.FoodZip.models.Ingredients;

public interface IngredientsService {
	
	public IngredientCategory createIngredientsCategory(
			String name,Long restaurantId) throws RestaurantException;

	public IngredientCategory findIngredientsCategoryById(Long id) throws Exception;

	public List<IngredientCategory> findIngredientsCategoryByRestaurantId(Long id) throws Exception;
	
	public List<Ingredients> findRestaurantsIngredients(
			Long restaurantId);

	
	public Ingredients createIngredientsItem(Long restaurantId,
			String ingredientName,Long ingredientCategoryId) throws Exception;

	public Ingredients updateStock(Long id) throws Exception;
	
}
