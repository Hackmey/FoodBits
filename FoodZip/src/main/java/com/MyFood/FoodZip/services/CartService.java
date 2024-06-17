package com.MyFood.FoodZip.services;


import com.MyFood.FoodZip.exception.CartException;
import com.MyFood.FoodZip.exception.CartItemException;
import com.MyFood.FoodZip.exception.FoodException;
import com.MyFood.FoodZip.exception.UserException;
import com.MyFood.FoodZip.models.Cart;
import com.MyFood.FoodZip.models.CartItem;
import com.MyFood.FoodZip.requests.AddCartItemRequest;

public interface CartService {

	public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws UserException, FoodException, CartException, CartItemException;

	public CartItem updateCartItemQuantity(Long cartItemId,int quantity) throws CartItemException;

	public Cart removeItemFromCart(Long cartItemId, String jwt) throws UserException, CartException, CartItemException;

	public Long calculateCartTotals(Cart cart) throws UserException;
	
	public Cart findCartById(Long id) throws CartException;
	
	public Cart findCartByUserId(Long userId) throws CartException, UserException;
	
	public Cart clearCart(Long userId) throws CartException, UserException;
	

	

}
