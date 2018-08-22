package com.vehicle.dao;

import java.util.List;

import com.vehicle.model.Vehicle;

public interface VehicleDAO {

	public void addVehicle(Vehicle vehicle);

	public List<Vehicle> getAllVehicles();

	public void deleteVehicle(Integer vehicleId);

	public Vehicle updateVehicle(Vehicle vehicle);

	public Vehicle getVehicle(int vehicleid);

	public Vehicle getActiveVehicle(String vehiclenumber);

}
