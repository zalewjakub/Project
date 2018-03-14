package project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.model.Building;
import project.repository.BuildingRepository;

@Controller
@RequestMapping("/building")
public class BuildingController {
	@Autowired
	BuildingRepository buildingRepository;

	@GetMapping("")
	public String findAll(Model model) {
		List<Building> buildings = buildingRepository.findAll();
		model.addAttribute("buildings", buildings);
		return "buildings";
	}

	@PostMapping("/add")
	public String saveToBase(@Valid Building building, BindingResult result,Model model) {
		if (result.hasErrors()) {
			return "";
		}
		building.setName();
		buildingRepository.save(building);
		return "redirect:/building";
	}

	@GetMapping("/deleteSure/{id}")
	public String deleteSure(@PathVariable String id, Model model) {
		model.addAttribute("id", id);
		return ("sure");
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable String id, Model model) {
		buildingRepository.delete(Long.parseLong(id));
		model.addAttribute("message", "Usunieto budynek o id: " + id);
		return ("redirect:/building");
	}

	@GetMapping("/update/{id}")
	public String updateId(@PathVariable String id, Model model) {
		Building building = buildingRepository.findOne(Long.parseLong(id));
		model.addAttribute("building", building);
		return "buildingForm";
	}
	
	@GetMapping("/more/{id}")
	public String more(@PathVariable String id, Model model) {
		model.addAttribute("building", buildingRepository.findOne(Long.parseLong(id)));
		return ("buildingInfo");
	}
}
