package com.vehicle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.vehicle.dao.VehicleDAO;
import com.vehicle.model.Vehicle;

@Service("vehicleService")
@Transactional
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleDAO vehicleDAO;
	boolean vehicleInDb = false;
	
	@Override
	@Transactional
	public boolean isVehicleNumberNotAlreadyInUse(String vehiclenumber) {

		
		if (vehicleDAO.getActiveVehicle(vehiclenumber) == null) {
			vehicleInDb = true;
		}

		return vehicleInDb;
	}

	@Override
	@Transactional
	public void addVehicle(Vehicle vehicle) {
		vehicleDAO.addVehicle(vehicle);
	}
	
	@Override
	@Transactional
	public List<Vehicle> getAllVehicles() {
		return vehicleDAO.getAllVehicles();
	}

	@Override
	@Transactional
	public void deleteVehicle(Integer vehicleId) {
		vehicleDAO.deleteVehicle(vehicleId);
	}

	public Vehicle getVehicle(int vehid) {
		return vehicleDAO.getVehicle(vehid);
	}

	public Vehicle updateVehicle(Vehicle vehicle) {
		return vehicleDAO.updateVehicle(vehicle);
	}

	public void setEmployeeDAO(VehicleDAO vehicleDAO) {
		this.vehicleDAO = vehicleDAO;
	}

}