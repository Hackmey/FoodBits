package com.MyFood.FoodZip.services;

import java.util.List;
import java.util.Optional;

import com.MyFood.FoodZip.exception.RestaurantException;
import com.MyFood.FoodZip.models.IngredientCategory;
import com.MyFood.FoodZip.models.Ingredients;
import com.MyFood.FoodZip.models.Restaurant;
import com.MyFood.FoodZip.repository.IngredientsCategoryRepository;
import com.MyFood.FoodZip.repository.IngredientsItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IngredientsServiceImplementation implements IngredientsService {

	@Autowired
	private IngredientsCategoryRepository ingredientsCategoryRepo;
	
	@Autowired
	private IngredientsItemRepository ingredientsItemRepository;
	
	
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Override
	public IngredientCategory createIngredientsCategory(
			String name,Long restaurantId) throws RestaurantException {


		
		IngredientCategory isExist=ingredientsCategoryRepo
				.findByRestaurantIdAndNameIgnoreCase(restaurantId,name);
		
		if(isExist!=null) {
			return isExist;
		}

		Restaurant restaurant=restaurantService.findRestaurantById(restaurantId);
		
		IngredientCategory ingredientCategory=new IngredientCategory();
		ingredientCategory.setRestaurant(restaurant);
		ingredientCategory.setName(name);
		
		IngredientCategory createdCategory = ingredientsCategoryRepo.save(ingredientCategory);
		
		return createdCategory;
	}

	@Override
	public IngredientCategory findIngredientsCategoryById(Long id) throws Exception {
		Optional<IngredientCategory> opt=ingredientsCategoryRepo.findById(id);
		if(opt.isEmpty()){
			throw new Exception("ingredient category not found");
		}
		return opt.get();
	}

	@Override
	public List<IngredientCategory> findIngredientsCategoryByRestaurantId(Long id) throws Exception {
		return ingredientsCategoryRepo.findByRestaurantId(id);
	}

	@Override
	public List<Ingredients> findRestaurantsIngredients(Long restaurantId) {

		return ingredientsItemRepository.findByRestaurantId(restaurantId);
	}
	

	@Override
	public Ingredients createIngredientsItem(Long restaurantId,
											 String ingredientName, Long ingredientCategoryId) throws Exception {
		
		IngredientCategory category = findIngredientsCategoryById(ingredientCategoryId);
		
//		Ingredients isExist = ingredientsItemRepository.
//				findByRestaurantIdAndNameIngoreCase(restaurantId, ingredientName,category.getName());
//		if(isExist!=null) {
//			System.out.println("is exists-------- item");
//			return isExist;
//		}
		
		Restaurant restaurant=restaurantService.findRestaurantById(
				restaurantId);
		Ingredients item=new Ingredients();
		item.setName(ingredientName);
		item.setRestaurant(restaurant);
		item.setIngredientCategory(category);
		
		Ingredients savedIngredients = ingredientsItemRepository.save(item);
		category.getIngredients().add(savedIngredients);

		return savedIngredients;
	}


	@Override
	public Ingredients updateStock (Long id) throws Exception {
		Optional<Ingredients> item=ingredientsItemRepository.findById(id);
		if(item.isEmpty()) {
			throw new Exception("ingredient not found with id "+item);
		}
		Ingredients ingredient=item.get();
		ingredient.setInStock(!ingredient.isInStock());
		return ingredientsItemRepository.save(ingredient);
	}

	

	

}
