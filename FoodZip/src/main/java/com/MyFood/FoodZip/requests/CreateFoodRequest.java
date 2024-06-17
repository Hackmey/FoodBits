package com.MyFood.FoodZip.requests;



import java.util.List;


import com.MyFood.FoodZip.models.FoodCategory;
import com.MyFood.FoodZip.models.Ingredients;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFoodRequest {
	

    
    private String name;
    private String description;
    private Long price;
    
  
    private FoodCategory category;
    private List<String> images;

   
    private Long restaurantId;
    
    private boolean vegetarian;
    private boolean seasonal;
    
    
    private List<Ingredients> ingredients;
	

}
