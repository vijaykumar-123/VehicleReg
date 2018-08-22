package com.vehicle.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.dao.DataIntegrityViolationException;

import com.vehicle.model.Vehicle;

@Repository
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class VehicleDAOImpl implements VehicleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Vehicle getActiveVehicle(String vehiclenumber) {

		Vehicle vehicle;

		try {

			vehicle = (Vehicle) sessionFactory.getCurrentSession().createQuery("from Vehicle v where v.vehiclenumber = :vehiclenumber")
					.setParameter("vehiclenumber", vehiclenumber).uniqueResult();
        } 

		catch (NonUniqueResultException e) {
			vehicle = null;
		}

		return vehicle;
	}

	//@ExceptionHandler(DataIntegrityViolationException.class)
	public void addVehicle(Vehicle vehicle) {
		
	    sessionFactory.getCurrentSession().saveOrUpdate(vehicle);
	}

	@SuppressWarnings("unchecked")
	public List<Vehicle> getAllVehicles() {

		return sessionFactory.getCurrentSession().createQuery("from Vehicle").list();
	}

	@Override
	public void deleteVehicle(Integer vehicleId) {
		Vehicle vehicle = (Vehicle) sessionFactory.getCurrentSession().load(Vehicle.class, vehicleId);
		if (null != vehicle) {
			this.sessionFactory.getCurrentSession().delete(vehicle);
		}

	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		sessionFactory.getCurrentSession().update(vehicle);
		return vehicle;
	}

	@Override
	public Vehicle getVehicle(int vehid) {

		return (Vehicle) sessionFactory.getCurrentSession().get(Vehicle.class, vehid);
	}

}