package com.MyFood.FoodZip.services;

import com.MyFood.FoodZip.exception.UserException;
import com.MyFood.FoodZip.models.User;

import java.util.List;

public interface UserService {

	public User findUserProfileByJwt(String jwt) throws UserException;
	
	public User findUserByEmail(String email) throws UserException;

	public List<User> findAllUsers();
//
//	public List<User> getPenddingRestaurantOwner();
//
//	void updatePassword(User user, String newPassword);
//
//	void sendPasswordResetEmail(User user);

}
