package com.amdocs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.entity.TruckEntity;
import com.amdocs.exception.TruckNotFoundException;
import com.amdocs.service.TruckService;

@RestController
@RequestMapping("/trucks")
public class TruckController {
	
	private TruckService truckService;
	
	@Autowired
	public TruckController(TruckService truckService) {
		this.truckService = truckService;
	}
	
	@PostMapping("/insert")
	public TruckEntity saveTruck(@RequestBody TruckEntity truck) {
		return truckService.saveTruck(truck);
	}
	
	@GetMapping("/allTrucks")
	public List<TruckEntity> getAllTrucks() {
		return truckService.getAllTrucks();
	}
	
	@GetMapping("/{truckId}")
	public TruckEntity updateTruck(@PathVariable Integer truckId, @RequestBody TruckEntity truck) {
		try {
			return truckService.updateTruck(truckId, truck);
		} catch (TruckNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return null;
	}
	
	@DeleteMapping("/delete/{truckId}")
	public void deleteTruck(@PathVariable Integer truckId) {
		truckService.deleteTruck(truckId);
	}
	
}
