package com.MyFood.FoodZip.services;

import java.util.List;
import java.util.Optional;

import com.MyFood.FoodZip.exception.RestaurantException;
import com.MyFood.FoodZip.models.FoodCategory;
import com.MyFood.FoodZip.models.Restaurant;
import com.MyFood.FoodZip.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImplementation implements CategoryService {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public FoodCategory createCategory(String name, Long userId) throws RestaurantException {
		Restaurant restaurant=restaurantService.getRestaurantsByUserId(userId);
		FoodCategory createdCategory=new FoodCategory();
		
		createdCategory.setName(name);
		createdCategory.setRestaurant(restaurant);
		return categoryRepository.save(createdCategory);
	}

	@Override
	public List<FoodCategory> findCategoryByRestaurantId(Long id) throws RestaurantException {
		Restaurant restaurant=restaurantService.findRestaurantById(id);
		return categoryRepository.findByRestaurantId(id);
	}

	@Override
	public FoodCategory findCategoryById(Long id) throws RestaurantException {
		Optional<FoodCategory> opt=categoryRepository.findById(id);
		
		if(opt.isEmpty()) {
			throw new RestaurantException("category not exist with id "+id);
		}
		
		return opt.get();
	}

}
