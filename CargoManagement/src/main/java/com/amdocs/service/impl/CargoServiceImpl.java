package com.amdocs.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.amdocs.entity.Cargo;
import com.amdocs.repo.CargoRepository;
import com.amdocs.service.CargoService;

@Service
public class CargoServiceImpl implements CargoService {

	private CargoRepository cargoRepo;
	
	@Override
	public boolean addCargo(Cargo cargo) {
		Cargo addCargo = cargoRepo.save(cargo);
		boolean flag = false;
		
		if(addCargo != null)
			flag = true;
		
		return flag;
	}

	@Override
	public List<Cargo> getAllCargo() {
		List<Cargo> cargoRecords = cargoRepo.findAll();
		return cargoRecords;
	}

	@Override
	public Cargo getCargoId(int id) {
		Optional<Cargo> cargoId = cargoRepo.findById(id);
		Cargo cargo = cargoId.get();
		return cargo;
	}

	@Override
	public boolean updateCargoDetails(Cargo cargo) {
		return addCargo(cargo);
	}

	@Override
	public boolean deleteCargo(int id) {
		Cargo cargo = getCargoId(id);
		boolean flag = false;
		
		if(cargo != null) {
			cargoRepo.delete(cargo);
			flag = true;
		}
		return flag;
	}

}
