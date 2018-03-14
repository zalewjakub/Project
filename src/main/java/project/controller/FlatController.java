package project.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.model.Building;
import project.model.Flat;
import project.repository.BuildingRepository;
import project.repository.FlatRepository;

@Controller
@RequestMapping("/flat")
public class FlatController {
	@Autowired
	FlatRepository flatRepository;
	@Autowired
	BuildingRepository buildingRepository;

	@ModelAttribute("buildings")
	public Collection<Building> buildings() {
		return buildingRepository.findAll();
	}

	@GetMapping("")
	public String findAll(Model model) {
		List<Flat> flats = flatRepository.findAll();
		model.addAttribute("flats", flats);
		return "flats";
	}

	@PostMapping("/add")
	public String saveToBase(@Valid Flat flat, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "";
		}
		flat.setName(flat.getBuilding().getName());
		flatRepository.save(flat);
		return "redirect:/flat";
	}

	@GetMapping("/deleteSure/{id}")
	public String deleteSure(@PathVariable String id, Model model) {
		model.addAttribute("id", id);
		return ("sure");
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable String id, Model model) {
		flatRepository.delete(Long.parseLong(id));
		model.addAttribute("message", "Usunieto mieszkanie o id: " + id);
		return ("redirect:/flat");
	}

	@GetMapping("/update/{id}")
	public String updateId(@PathVariable String id, Model model) {
		Flat flat = flatRepository.findOne(Long.parseLong(id));
		model.addAttribute("flat", flat);
		return "flatForm";
	}
	
	@PostMapping("/getFlats")
	public String searchAll(HttpServletRequest request, Model model) {
		long buildingId = Long.parseLong(request.getParameter("buildingId"));
		List<Flat> flats = flatRepository.findByBuilding_Id(buildingId);
		model.addAttribute("flats", flats);
		return "flats";
	}
	
	
}
