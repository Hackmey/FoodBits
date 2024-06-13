package com.MyFood.FoodZip.models;

import com.MyFood.FoodZip.dto.RestaurantDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fullName;
    private String email;
    private String  password;
    private USER_ROLES role;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,  mappedBy = "customer")
    List<Order> orders = new ArrayList<Order>();

    @ElementCollection
    private List<RestaurantDto> favorites = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();
//    status;
}
