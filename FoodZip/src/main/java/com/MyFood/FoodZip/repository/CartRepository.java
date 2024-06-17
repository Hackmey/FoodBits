package com.MyFood.FoodZip.repository;

import java.util.Optional;

import com.MyFood.FoodZip.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepository extends JpaRepository<Cart, Long> {

	 Optional<Cart> findByCustomer_Id(Long userId);
}
