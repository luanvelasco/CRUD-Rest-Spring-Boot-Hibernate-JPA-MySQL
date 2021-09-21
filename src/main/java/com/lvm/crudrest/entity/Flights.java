package com.lvm.crudrest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flights {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	private String flightCompany;
	private String aircraftModel;
	private String aircraftIdentificationCode;
	
	
	public String getFlightCompany() {
		return flightCompany;
	}
	public void setFlightCompany(String flightCompany) {
		this.flightCompany = flightCompany;
	}
	public String getAircraftModel() {
		return aircraftModel;
	}
	public void setAircraftModel(String aircraftModel) {
		this.aircraftModel = aircraftModel;
	}
	public String getAircraftIdentificationCode() {
		return aircraftIdentificationCode;
	}
	public void setAircraftIdentificationCode(String aircraftIdentificationCode) {
		this.aircraftIdentificationCode = aircraftIdentificationCode;
	}

	
	
}
