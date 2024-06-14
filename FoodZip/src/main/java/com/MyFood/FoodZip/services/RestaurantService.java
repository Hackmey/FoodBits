package com.MyFood.FoodZip.services;

import java.util.List;

import com.MyFood.FoodZip.dto.RestaurantDto;
import com.MyFood.FoodZip.exception.RestaurantException;
import com.MyFood.FoodZip.models.Restaurant;
import com.MyFood.FoodZip.models.User;
import com.MyFood.FoodZip.requests.CreateRestaurantRequest;
import org.springframework.stereotype.Service;


public interface RestaurantService {

	public Restaurant createRestaurant(CreateRestaurantRequest req, User user);

	public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updatedRestaurant)
			throws RestaurantException;

	public void deleteRestaurant(Long restaurantId) throws RestaurantException;

	public List<Restaurant>getAllRestaurant();

	public List<Restaurant>searchRestaurant(String keyword);
	
	public Restaurant findRestaurantById(Long id) throws RestaurantException;

	public Restaurant getRestaurantsByUserId(Long userId) throws RestaurantException;
	
	public RestaurantDto addToFavorites(Long restaurantId, User user) throws RestaurantException;

	public Restaurant updateRestaurantStatus(Long id)throws RestaurantException;
}
