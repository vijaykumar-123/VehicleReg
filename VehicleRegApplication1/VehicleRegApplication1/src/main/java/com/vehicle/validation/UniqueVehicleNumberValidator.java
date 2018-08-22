package com.vehicle.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.vehicle.service.VehicleService;

public class UniqueVehicleNumberValidator implements ConstraintValidator<UniqueVehicleNumber, String> {

	@Autowired
	private VehicleService vehicleService;

	@Override
	public void initialize(UniqueVehicleNumber constraintAnnotation) {
	}

	@Override
	public boolean isValid(String vehiclenumber, ConstraintValidatorContext context) {


		return vehiclenumber != null && !vehicleService.isVehicleNumberNotAlreadyInUse(vehiclenumber);
	}

}
