package com.MyFood.FoodZip.controller;

import java.util.List;

import com.MyFood.FoodZip.dto.RestaurantDto;
import com.MyFood.FoodZip.exception.RestaurantException;
import com.MyFood.FoodZip.exception.UserException;
import com.MyFood.FoodZip.models.Restaurant;
import com.MyFood.FoodZip.models.User;
import com.MyFood.FoodZip.repository.UserRepository;
import com.MyFood.FoodZip.services.RestaurantService;
import com.MyFood.FoodZip.services.UserService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;


	@GetMapping("/search")
	public ResponseEntity<List<Restaurant>> findRestaurantByName(
			@RequestParam String keyword) {
		List<Restaurant> restaurant = restaurantService.searchRestaurant(keyword);

		return ResponseEntity.ok(restaurant);
	}


	@GetMapping()
	public ResponseEntity<List<Restaurant>> getAllRestaurants() {

		List<Restaurant> restaurants = restaurantService.getAllRestaurant();
		
		
		return ResponseEntity.ok(restaurants);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Restaurant> findRestaurantById(
			@PathVariable Long id) throws RestaurantException {

			Restaurant restaurant = restaurantService.findRestaurantById(id);
			return ResponseEntity.ok(restaurant);

	}
	
	@PutMapping("/{id}/add-favorites")
	public RestaurantDto addToFavorite(
			@RequestHeader("Authorization") String jwt,
			@PathVariable Long id) throws RestaurantException, ExecutionControl.UserException, UserException {

		Restaurant restaurant = restaurantService.findRestaurantById(id);

		RestaurantDto restaurantDto = new RestaurantDto();
		restaurantDto.setDescription(restaurant.getDescription());
		restaurantDto.setId(restaurant.getId());
		restaurantDto.setImages(restaurant.getImages());
		restaurantDto.setTitle(restaurant.getName());

		User user = userService.findUserProfileByJwt(jwt);


		boolean isFav = false;
		List<RestaurantDto> favs = user.getFavorites();
		for(RestaurantDto r : favs){
			if(r.getId().equals(id)){
				favs.remove(r);
				isFav = true;
				break;
			}
		}
		if(!isFav){
			favs.add(restaurantDto);
		}
		userRepository.save(user);
		return restaurantDto;
	}
}
