package com.amdocs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amdocs.entity.Cargo;
import com.amdocs.service.impl.CargoServiceImpl;

@Controller
public class CargoController {
	
	private CargoServiceImpl cargoServiceImpl;
	
	@Autowired
	public CargoController(CargoServiceImpl cargoServiceImpl) {
		this.cargoServiceImpl = cargoServiceImpl;
		
	}
	
	@RequestMapping("/")
	public String loadForm(Model model) {
		Cargo cargo = new Cargo();
		model.addAttribute("cargo", cargo);
		
		return "cargo";
	}
	
	@RequestMapping("insert")
	public String handleCargoForm(@ModelAttribute("cargo")Cargo cargo, Model model) {
		
		boolean addCargo = cargoServiceImpl.addCargo(cargo);
		
		String msg = "";
		
		if(addCargo)
			msg = "Data Inserted Successfully";
		else
			msg = "Data Insertion Failed";
		
		model.addAttribute("msg",msg);
		return "cargo";
	}
	
	@RequestMapping("/viewAll")
	public String viewAllCargo(Model model) {
		List<Cargo> allCargo = cargoServiceImpl.getAllCargo();
		
		model.addAttribute("cargo", allCargo);
		return "view";
	}
	
	@RequestMapping("/deleteCargo")
	public String deleteCargo(@RequestParam("id") int id) {
		boolean flag = cargoServiceImpl.deleteCargo(id);
		
		if(flag)
			return "redirect:/view";
		return "redirect:/view";
	}
	
	@RequestMapping("/editCargo")
	public String editCargo(@RequestParam("cargoId") int id, Model model) {
		Cargo cargo = cargoServiceImpl.getCargoId(id);
		
		model.addAttribute("cargo", cargo);
		return "editCargo";
	}
	
	@RequestMapping("/update")
	public String updateEmployee(Cargo cargo) {
		boolean updateCargo = cargoServiceImpl.updateCargoDetails(cargo);
		
		return "redirect:/view";
	}
	

}
