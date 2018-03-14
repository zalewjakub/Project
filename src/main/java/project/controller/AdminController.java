package project.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import project.model.Admin;
import project.model.Building;
import project.model.Flat;
import project.model.Homeovner;
import project.repository.AdminRepository;
import project.repository.BuildingRepository;
import project.repository.FlatRepository;

@Controller
@RequestMapping("")
public class AdminController {
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	FlatRepository flatRepository;
	@Autowired
	BuildingRepository buildingRepository;

	@ModelAttribute("flats")
	public Collection<Flat> flats() {
		return flatRepository.findAll();
	}

	
	@ModelAttribute("buildings")
	public Collection<Building> buildings() {
		return buildingRepository.findAll();
	}

	@RequestMapping("")
	public String homepage(Model model) {
		return "homePage";
	}

	@RequestMapping("/add")
	@ResponseBody
	public String add() {
		Admin author = new Admin();
		author.setLogin("kubazalew");
		author.setPassword("myszk");
		adminRepository.save(author);
		return "Id dodanego admina to:" + author.getId();
	}

	@GetMapping("/loginAdmin")
	public String showLogin() {
		return "login";
	}

	@PostMapping("/loginAdmin")
	public String login(HttpSession sess, @RequestParam String login, @RequestParam String password) {

		Admin admin = adminRepository.findOneByLogin(login);

		if (admin != null && BCrypt.checkpw(password, admin.getPassword())) {
			sess.setAttribute("logged", true);
			return "redirect:/loggedAdmin";
		}
		sess.setAttribute("logged", false);
		String message = "";
		try {
			message = URLEncoder.encode("Błędny login lub hasło", "UTF-8");
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		return "redirect:/loginAdmin?message=" + message;
	}

	@GetMapping("/loggedAdmin")
	public String adminLogged() {
		return "admin";
	}

	@GetMapping("/adminAdd/{value}")
	public String getClass(@PathVariable String value, Model model) {
		if (("Building").equals(value)) {
			model.addAttribute("building", new Building());
			return "buildingForm";
		} else if (("Homeowner").equals(value)) {
			model.addAttribute("homeovner", new Homeovner());
			return "homeovnerForm";
		} else if (("Flat").equals(value)) {
			model.addAttribute("flat", new Flat());
			return "flatForm";
		}
		return "admin";
	}
	
	@GetMapping("/adminSearch/{value}")
	public String getSearch(@PathVariable String value, Model model) {
		System.out.println("aaaaaaa" + value);
		if (("Building").equals(value)) {
			model.addAttribute("building", new Building());
			return "buildingSearch";
		} else if (("Homeowner").equals(value)) {
			model.addAttribute("homeovner", new Homeovner());
			System.out.println("aaaaaaa");
			return "homeovnerSearch";
		} else if (("Flat").equals(value)) {
			model.addAttribute("flat", new Flat());
			return "flatSearch";
		}
		return "admin";
	}

}
