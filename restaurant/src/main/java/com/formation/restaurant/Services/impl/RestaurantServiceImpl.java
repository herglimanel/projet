package com.formation.restaurant.Services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.restaurant.Models.restaurant;
import com.formation.restaurant.Models.dao.RestaurantRepository;
import com.formation.restaurant.Services.restaurantService;

@Service
public class RestaurantServiceImpl implements restaurantService {
	@Autowired

	private RestaurantRepository restRepository;

	@Override
	public List<restaurant> findAll() {
		List<restaurant> liste = new ArrayList<restaurant>();
		restRepository.findAll().forEach(liste::add);
		;

		return liste;

	}

	@Override
	public restaurant findById(String id) {
		if(restRepository.findById(id).isPresent()) {
			return restRepository.findById(id).get();
		}
		return null;
	}
	@Override
	public String create(restaurant resttoo) {
		return restRepository.save(resttoo).getId();
	}
	
	
@Override
	public void update(String identifiant, restaurant resttoo) {
		resttoo.setId(identifiant);
		restRepository.save(resttoo);
	}


@Override
public void partialUpdate(String identifiant, Map<String, Object> updates) {
	// TODO Auto-generated method stub
	 restaurant restoToUpdate=restRepository.findById(identifiant).get();
	 restRepository.save(restoToUpdate);
}




}


