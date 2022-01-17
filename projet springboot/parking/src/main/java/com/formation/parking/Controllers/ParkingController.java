package com.formation.parking.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.formation.parking.Models.Parking;
import com.formation.parking.Services.ParkingService;

@RestController
public class ParkingController {
	@Autowired
	private ParkingService parkingService;

	@RequestMapping(path = "/api/parkings", method = RequestMethod.GET)
	public List<Parking> getListeParkings() {

		ArrayList<Parking> liste = new ArrayList<Parking>();

		return parkingService.getListeParkings();
	}
}