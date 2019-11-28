package com.tasif.springcassandra.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tasif.springcassandra.user.dto.VehicleDto;
import com.tasif.springcassandra.user.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@PostMapping
	public String create(@RequestBody VehicleDto vehicle) {
		String response = vehicleService.createVehicle(vehicle);
		return response;
	}

//	@PostMapping("/addtouser")
//	public String addVehicle(@RequestParam String userId, @RequestParam String vehicleId) {
//		String response = vehicleService.addVehicleToUser(userId, vehicleId);
//		return response;
//	}
}
