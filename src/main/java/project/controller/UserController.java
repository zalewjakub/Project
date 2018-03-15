package project.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import project.model.Flat;
import project.model.Homeovner;
import project.model.Notes;
import project.repository.BuildingRepository;
import project.repository.FlatRepository;
import project.repository.HomeovnerRepository;
import project.repository.NotesRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	HomeovnerRepository homeovnerRepository;
	@Autowired
	FlatRepository flatRepository;
	@Autowired
	BuildingRepository buildingRepository;
	@Autowired
	NotesRepository notesRepository;
	private long id;

	@ModelAttribute("notes")
	public Collection<Notes> notes() {
		return notesRepository.findById(id);
	}

	// @ModelAttribute("building")
	// public Building building() {
	// return buildingRepository.findOne(buildingId);
	// }

	@ModelAttribute("flats")
	public List<Flat> flats() {
		return flatRepository.findByHomeovner_Id(this.id);
	}

	@RequestMapping("")
	public String homepage(Model model) {
		Homeovner homeovner = homeovnerRepository.findOneById(this.id);
		model.addAttribute("homeovner", homeovner);
		// Notes note = notesRepository.findOneByHomeovner_Id(this.id);
		// model.addAttribute("note", note);
		Notes notes = new Notes();
		model.addAttribute("notes", notes);
		return "userData";
	}
	@PostMapping("")
	public String homepageChange(@Valid Homeovner homeovner, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "homeovnerForm";
		}
		homeovnerRepository.save(homeovner);
		model.addAttribute("homeovner", homeovner);
		// Notes note = notesRepository.findOneByHomeovner_Id(this.id);
		// model.addAttribute("note", note);
		Notes notes = new Notes();
		model.addAttribute("notes", notes);
		return "userData";
	}
	
	
	
	@PostMapping("/addNotes")
	public String addNotes(@Valid Notes notes, BindingResult result, Model model) {
		System.out.println("AAAAA");

		if (result.hasErrors()) {
			return "notesAdd";
		}
		System.out.println("bbbb" + notes.getTextInfo());
		notesRepository.save(notes);
		return "redirect:/user";
	}

	@GetMapping("/loginUser")
	public String showLogin() {
		return "login";
	}

	@PostMapping("/loginUser")
	public String login(HttpSession sess, @RequestParam String login, @RequestParam String password) {

		Homeovner homeovner = homeovnerRepository.findOneByLogin(login);
		if (homeovner != null && BCrypt.checkpw(password, homeovner.getPassword())) {
			sess.setAttribute("logged", true);
			this.id = homeovner.getId();
			return "redirect:/user";
		}
		sess.setAttribute("logged", false);
		String message = "";
		try {
			message = URLEncoder.encode("Błędny login lub hasło", "UTF-8");
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		return "redirect:/user/loginUser?message=" + message;
	}

	//
	// @GetMapping("/adminSearch/{value}")
	// public String getSearch(@PathVariable String value, Model model) {
	// System.out.println("aaaaaaa" + value);
	// if (("Building").equals(value)) {
	// model.addAttribute("building", new Building());
	// return "buildingSearch";
	// } else if (("Homeowner").equals(value)) {
	// model.addAttribute("homeovner", new Homeovner());
	// System.out.println("aaaaaaa");
	// return "homeovnerSearch";
	// } else if (("Flat").equals(value)) {
	// model.addAttribute("flat", new Flat());
	// return "flatSearch";
	// }
	// return "admin";
	// }

}
