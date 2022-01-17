package com.formation.restaurant.REst;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.formation.restaurant.Models.restaurant;
import com.formation.restaurant.Services.restaurantService;
import com.formation.restaurant.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/restaurants")
public class restaurantController {
	@Autowired
	private restaurantService restoService;

	@GetMapping
	public List<restaurant> findAll() {
		return restoService.findAll();
	}
	



	@GetMapping("/{id}")
	public restaurant findById(@PathVariable("id") String identifiant) {
		restaurant reponse = restoService.findById(identifiant);
		if(reponse == null) {
			throw new ResourceNotFoundException();
			
		}
		return reponse;
	}
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public String create (@RequestBody restaurant resttoo) {
		return restoService.create(resttoo);
	}
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void update(@PathVariable("id") String identifiant, @RequestBody restaurant resttoo) {
		if(restoService.findById(identifiant) == null) {
			throw new ResourceNotFoundException();
		}
		restoService.update(identifiant, resttoo);
	}
	
	public void partialUpdate(@PathVariable("id") String identifiant, @RequestBody Map<String, Object> updates) {
	
		restoService.partialUpdate(identifiant, updates);
}
}

