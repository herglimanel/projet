package com.formation.restaurant.Services;

import java.util.List;
import java.util.Map;

import com.formation.restaurant.Models.restaurant;

public interface restaurantService {
	public List<restaurant> findAll();
	public restaurant findById(String id);
	public String create(restaurant resttoo);
	public void update(String identifiant, restaurant resttoo);
	public void partialUpdate(String identifiant, Map<String, Object> updates);
	}

