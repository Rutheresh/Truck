package com.amdocs.service;

import java.util.List;

import com.amdocs.entity.Cargo;

public interface CargoService {
	
	public boolean addCargo(Cargo cargo);
	
	public List<Cargo> getAllCargo();
	
	public Cargo getCargoId(int id);
	
	public boolean updateCargoDetails(Cargo cargo);
	
	public boolean deleteCargo(int id);
}
