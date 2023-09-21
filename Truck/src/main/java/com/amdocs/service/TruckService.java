package com.amdocs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.entity.TruckEntity;
import com.amdocs.exception.TruckNotFoundException;
import com.amdocs.repo.TruckRepository;

@Service
public class TruckService {

	private TruckRepository truckRepo;
	
	@Autowired
	public TruckService(TruckRepository truckRepo) {
		this.truckRepo = truckRepo;
	}
	
	public TruckEntity saveTruck(TruckEntity truck) {
		return truckRepo.save(truck);
		
	}
	
	public List<TruckEntity> getAllTrucks() { 
		return truckRepo.findAll();
	}
	
	public TruckEntity getTruckById(Integer truckId) {
		return truckRepo.findById(truckId).orElse(null);
	}
	
	public TruckEntity updateTruck(Integer truckId, TruckEntity truck) throws TruckNotFoundException{
		TruckEntity existingTruck = truckRepo.findById(truckId).orElse(null);
		
		if(existingTruck != null) {
			existingTruck.setLicensePlate(truck.getLicensePlate());
			existingTruck.setModelName(truck.getModelName());
			existingTruck.setPurchaseDate(truck.getPurchaseDate());
			existingTruck.setRc(truck.getRc());
			existingTruck.setTonnage(truck.getTonnage());
			return truckRepo.save(existingTruck);
		}
		throw new TruckNotFoundException("No truck found");
	}
	
	public void deleteTruck(Integer truckId) {
		truckRepo.deleteById(truckId);
	}
}
