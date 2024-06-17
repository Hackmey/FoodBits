package com.MyFood.FoodZip.controller;

import java.util.List;

import com.MyFood.FoodZip.models.IngredientCategory;
import com.MyFood.FoodZip.models.Ingredients;
import com.MyFood.FoodZip.requests.CreateIngredientCategoryRequest;
import com.MyFood.FoodZip.requests.CreateIngredientRequest;
import com.MyFood.FoodZip.services.IngredientsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/admin/ingredients")
public class IngredientsController {
	
	@Autowired
	private IngredientsService ingredientService;

	@PostMapping("/category")
	public ResponseEntity<IngredientCategory> createIngredientCategory(
			@RequestBody CreateIngredientCategoryRequest req) throws Exception{
		IngredientCategory items=ingredientService.createIngredientsCategory(req.getName(), req.getRestaurantId());
		return new ResponseEntity<>(items,HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Ingredients> createIngredient(
			@RequestBody CreateIngredientRequest req) throws Exception{

		Ingredients item=ingredientService.createIngredientsItem(req.getRestaurantId(),req.getName(),req.getIngredientCategoryId());
		return new ResponseEntity<>(item,HttpStatus.OK);
	}
	
	@PutMapping("/{id}/stock")
	public ResponseEntity<Ingredients> updateStock(@PathVariable Long id) throws Exception{
		Ingredients item=ingredientService.updateStock(id);
		return new ResponseEntity<Ingredients>(item,HttpStatus.OK);
	}
	
	@GetMapping("/restaurant/{id}")
	public ResponseEntity<List<Ingredients>> restaurantsIngredient(
			@PathVariable Long id) throws Exception{
		List<Ingredients> items=ingredientService.findRestaurantsIngredients(id);
		return new ResponseEntity<>(items,HttpStatus.OK);
	}

	@GetMapping("/restaurant/{id}/category")
	public ResponseEntity<List<IngredientCategory>> restaurantsIngredientCategory(
			@PathVariable Long id) throws Exception{
		List<IngredientCategory> items=ingredientService.findIngredientsCategoryByRestaurantId(id);
		return new ResponseEntity<>(items,HttpStatus.OK);
	}

}
