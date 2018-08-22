package com.vehicle.service;

import java.util.List;

import com.vehicle.model.Vehicle;

public interface VehicleService {

	public void addVehicle(Vehicle vehicle);

	public List<Vehicle> getAllVehicles();

	public void deleteVehicle(Integer vehicleId);

	public Vehicle getVehicle(int vehicleid);

	public Vehicle updateVehicle(Vehicle vehicle);

	boolean isVehicleNumberNotAlreadyInUse(String vehiclenumber);
}