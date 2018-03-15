package project.controller;

import java.util.Collection;
import java.util.List;
import java.util.Random;

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
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import project.model.Flat;
import project.model.Homeovner;
import project.model.Notes;
import project.repository.FlatRepository;
import project.repository.HomeovnerRepository;
import project.repository.NotesRepository;

@Controller
@RequestMapping("/homeovner")
public class HomeovnerController {
	@Autowired
	HomeovnerRepository homeovnerRepository;
	@Autowired
	FlatRepository flatRepository;
	@Autowired
	NotesRepository notesRepository;
	Random r = new Random();

	@ModelAttribute("flats")
	public Collection<Flat> flats() {
		return flatRepository.findAll();
	}

	@ModelAttribute("notes")
	public Collection<Notes> notes() {
		return notesRepository.findAll();
	}

	@GetMapping("")
	public String findAll(Model model) {
		List<Homeovner> homeovners = homeovnerRepository.findAll();
		model.addAttribute("homeovners", homeovners);
		return "homeovners";
	}

	@GetMapping("/add")
	public String form(Model model) {
		model.addAttribute("homeovner", new Homeovner());
		return ("homeovnerForm");
	}

	@PostMapping("/add")
	public String saveToBase(@Valid Homeovner homeovner, BindingResult result, Model model) {
		if (homeovner.getLogin() == null || ("").equals(homeovner.getLogin())) {
			homeovner.setLogin(homeovner.getFirstName() + homeovner.getLastName());
			int a = r.nextInt(100);
			System.out.println("CCCCC" + homeovner.getFirstName() + a);
			homeovner.setPassword(homeovner.getFirstName() + a);
		}
		if (result.hasErrors()) {
			return "homeovnerForm";
		}
		
		homeovnerRepository.save(homeovner);
		Flat flat = homeovner.getFlats().get(0);
		flat.setHomeovner(homeovner);
		flatRepository.save(flat);
		return "redirect:/homeovner";
	}

	@GetMapping("/deleteSure/{id}")
	public String deleteSure(@PathVariable String id, Model model) {
		model.addAttribute("id", id);
		return ("sure");
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable String id, Model model) {
		homeovnerRepository.delete(Long.parseLong(id));
		model.addAttribute("message", "Usunieto Wlasciciela o id: " + id);
		return ("redirect:/homeovner");
	}

	@GetMapping("/update/{id}")
	public String updateId(@PathVariable String id, Model model) {
		Homeovner homeovner = homeovnerRepository.findOne(Long.parseLong(id));
		model.addAttribute("homeovner", homeovner);
		return "homeovnerForm";
	}

	@PostMapping("/getHomeovner")
	public String searchAll(HttpServletRequest request, Model model) {
		String lastName = request.getParameter("lastName");
		List<Homeovner> homeovners = homeovnerRepository.findByLastName(lastName);
		model.addAttribute("homeovners", homeovners);
		return "homeovners";
	}
}
