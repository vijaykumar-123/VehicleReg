package com.vehicle.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.vehicle.validation.UniqueVehicleNumber;

@Entity
@Table(name = "vehicle_table")
public class Vehicle implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	@NotNull
	private int vid;

	@Column(unique = true)
	@UniqueVehicleNumber
	private String vehiclenumber;

	@Column
	@NotNull
	private String model;

	@Column
	@NotNull
	private String engine;

	@Column
	@NotNull
	private String ownername;

	@Column
	@NotNull
	private int price;

	@Column
	@NotNull
	private String cars;
	
	private String errorMsg;

	public String getCars() {
		return cars;
	}

	public void setCars(String cars) {
		this.cars = cars;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getVehiclenumber() {
		return vehiclenumber;
	}

	public void setVehiclenumber(String vehiclenumber) {
		this.vehiclenumber = vehiclenumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String error) {
		this.errorMsg = error;
	}

}