package com.formation.restaurant.Models.dao;

import org.springframework.data.repository.CrudRepository;

import com.formation.restaurant.Models.restaurant;

public interface RestaurantRepository extends CrudRepository<restaurant, String> {

}
