package project.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name = "homeovner")
public class Homeovner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	@Size(min = 3, max = 20)
	private String firstName;
	@NotBlank
	@Size(min = 3, max = 40)
	private String lastName;
	@Size(max = 300)
	private String description;
	@Email
	private String email;
	private String password;
	private String login;
	private String phone;
	@OneToMany(cascade = { CascadeType.MERGE }, mappedBy = "homeovner")
	private List<Notes> notes;
	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER, mappedBy = "homeovner")
	private List<Flat> flats;
	
	public Homeovner() {
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {		
		this.login = login;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public List<Notes> getNotes() {
		return notes;
	}

	public void setNotes(List<Notes> notes) {
		this.notes = notes;
	}

	public List<Flat> getFlats() {
		return flats;
	}

	public void setFlats(List<Flat> flats) {
		this.flats = flats;
	}

	@Override
	public String toString() {
		return String.format("%s %s", firstName, lastName);
	}
	
	
}
