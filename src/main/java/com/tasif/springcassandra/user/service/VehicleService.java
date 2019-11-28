package com.tasif.springcassandra.user.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasif.springcassandra.user.dto.VehicleDto;
import com.tasif.springcassandra.user.model.User;
import com.tasif.springcassandra.user.model.Vehicle;
import com.tasif.springcassandra.user.repository.UserRepository;
import com.tasif.springcassandra.user.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private ModelMapper modelmapper;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VehicleRepository vehicleRepository;

	public String createVehicle(VehicleDto createVehicle) {
		Vehicle vehicle = modelmapper.map(createVehicle, Vehicle.class);
		String vehicleId = UUID.randomUUID().toString().replaceAll("-", "");
		vehicle.setVehicleId(vehicleId);
		vehicleRepository.save(vehicle);
		return "Vehicle created successfully";
	}

//	public String addVehicleToUser(String userId, String vehicleId) {
//		User user = userRepository.findById(userId)
//				.orElseThrow(() -> new RuntimeException("User does not exist with userId " + userId));
//		Vehicle vehicle = vehicleRepository.findById(vehicleId)
//				.orElseThrow(() -> new RuntimeException("Vehicle does not exist with vehicleId " + vehicleId));
//		user.getVehicles().add(vehicle);
//		userRepository.save(user);
//		return "Vehicle added to user";
//	}
}
