package com.MyFood.FoodZip.controller;

import java.util.List;

import com.MyFood.FoodZip.exception.RestaurantException;
import com.MyFood.FoodZip.exception.UserException;
import com.MyFood.FoodZip.models.Food;
import com.MyFood.FoodZip.models.FoodCategory;
import com.MyFood.FoodZip.models.User;
import com.MyFood.FoodZip.services.CategoryService;
import com.MyFood.FoodZip.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	public CategoryService categoryService;

	@Autowired
	public UserService userService;
	
	@PostMapping("/admin/category")
	public ResponseEntity<FoodCategory> createCategory(
			@RequestHeader("Authorization")String jwt,
			@RequestBody FoodCategory category) throws RestaurantException, UserException {
		User user=userService.findUserProfileByJwt(jwt);
		
		FoodCategory createdCategory=categoryService.createCategory(category.getName(), user.getId());
		return new ResponseEntity<FoodCategory>(createdCategory,HttpStatus.OK);
	}
	
	@GetMapping("/category/restaurant/{id}")
	public ResponseEntity<List<FoodCategory>> getRestaurantsCategory(
			@PathVariable Long id,
			@RequestHeader("Authorization")String jwt) throws RestaurantException, UserException {
		User user=userService.findUserProfileByJwt(jwt);
		List<FoodCategory> categories=categoryService.findCategoryByRestaurantId(id);
		return new ResponseEntity<>(categories,HttpStatus.OK);
	}

}
