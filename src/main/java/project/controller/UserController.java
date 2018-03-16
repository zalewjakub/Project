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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import project.model.Admin;
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


	@ModelAttribute("flats")
	public List<Flat> flats() {
		return flatRepository.findByHomeovner_Id(this.id);
	}

	@GetMapping("/{id}")
	public String user(@PathVariable String id, Model model) {
		System.out.println("aAAAAA" + id);
		Homeovner homeovner = homeovnerRepository.findOneById(Long.parseLong(id));
		model.addAttribute("homeovner", homeovner);
		List<Flat> flat = flatRepository.findByHomeovner_Id(Long.parseLong(id));
		model.addAttribute("flat", flat);
		List<Notes> notes = notesRepository.findAllByHomeovner_Id(Long.parseLong(id));
		model.addAttribute("notes", notes);
		return "homeovner";
	}
	
	@RequestMapping("")
	public String homepage(Model model) {
		Homeovner homeovner = homeovnerRepository.findOneById(this.id);
		model.addAttribute("homeovner", homeovner);
		Notes note = notesRepository.findUsingCreationTime(this.id);
		model.addAttribute("note", note);
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
		Notes note = notesRepository.findOneByHomeovner_Id(this.id);
		model.addAttribute("note", note);
		Notes notes = new Notes();
		model.addAttribute("notes", notes);
		return "userData";
	}
	
	
	@PostMapping("/addNotes")
	public String addNotes(@RequestParam String textInfo, Model model) {
		Notes note = new Notes();
		note.setTextInfo(textInfo);
		note.setHomeovner(homeovnerRepository.findOneById(id));
		notesRepository.save(note);
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

	@RequestMapping("/add")
	@ResponseBody
	public String add() {
		Notes note = new Notes();
		note.setTextInfo("To nowa wiadomosc");
		note.setHomeovner(homeovnerRepository.findOneById(id));
		notesRepository.save(note);
		return "Id dodanego admina to:" + note.getId();
	}

}
