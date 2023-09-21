package com.amdocs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARGO")
public class Cargo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cargoId;
	private String cargoName;
	private String clientName;
	private String email;
	private Integer cargoWeight;
	private String cargoType;
	public Integer getCargoId() {
		return cargoId;
	}
	public void setCargoId(Integer cargoId) {
		this.cargoId = cargoId;
	}
	public String getCargoName() {
		return cargoName;
	}
	public void setCargoName(String cargoName) {
		this.cargoName = cargoName;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getCargoWeight() {
		return cargoWeight;
	}
	public void setCargoWeight(Integer cargoWeight) {
		this.cargoWeight = cargoWeight;
	}
	public String getCargoType() {
		return cargoType;
	}
	public void setCargoType(String cargoType) {
		this.cargoType = cargoType;
	}

	public Cargo() {
		
	}
	public Cargo(Integer cargoId, String cargoName, String clientName, String email, Integer cargoWeight,
			String cargoType) {
		this.cargoId = cargoId;
		this.cargoName = cargoName;
		this.clientName = clientName;
		this.email = email;
		this.cargoWeight = cargoWeight;
		this.cargoType = cargoType;
	}
	

}
