package com.MyFood.FoodZip.repository;

import com.MyFood.FoodZip.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartItemRepository extends JpaRepository<CartItem, Long> {


//    CartItem findByFoodIsContaining

}
