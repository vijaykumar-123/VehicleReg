package com.vehicle.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.vehicle.model.Vehicle;
import com.vehicle.service.VehicleService;
import org.springframework.validation.Errors;

@Controller
@ControllerAdvice
public class VehicleController {

	private static final Logger logger = Logger.getLogger(VehicleController.class);


	public VehicleController() {
		System.out.println("VehicleController Validation()");
	}
	@Autowired
	private VehicleService vehicleService;
	Errors errors;
	@RequestMapping(value = "/")
	public ModelAndView listVehicle(ModelAndView model) throws IOException {
		List<Vehicle> listVehicle = vehicleService.getAllVehicles();
		model.addObject("listVehicle", listVehicle);
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/newVehicle", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Vehicle vehicle = new Vehicle();
		model.addObject("vehicle", vehicle);
		model.setViewName("VehicleForm");
		return model;
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	@RequestMapping(value = "/saveVehicle", method = RequestMethod.POST)
	public ModelAndView saveVehicle(@ModelAttribute Vehicle vehicle) {
		
		if (!vehicleService.isVehicleNumberNotAlreadyInUse(vehicle.getVehiclenumber())) 
		{
			ModelAndView model = new ModelAndView("VehicleForm");
			model.addObject("vehicle", vehicle);
			model.addObject("errorMsg", "Vehicle Number already in use!!");
			return model;
		}
		else {
				vehicleService.addVehicle(vehicle);
				return new ModelAndView("redirect:/");
	    }
}

    @RequestMapping(value = "/deleteVehicle", method = RequestMethod.GET)
	public ModelAndView deleteVehicle(HttpServletRequest request) {
		int vehicleId = Integer.parseInt(request.getParameter("vid"));
		vehicleService.deleteVehicle(vehicleId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editVehicle", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int vehicleId = Integer.parseInt(request.getParameter("vid"));
		Vehicle vehicle = vehicleService.getVehicle(vehicleId);
		ModelAndView model = new ModelAndView("VehicleForm");
		model.addObject("vehicle", vehicle);

		return model;
	}

}
