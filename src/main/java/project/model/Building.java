package project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "building")
public class Building {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	@Size(min = 3)
	private String city;
	@NotBlank
	@Size(min = 3)
	private String street;
	@Min(value = 1)
	@Max(value = 200)
	private long number;
	private String extNumber;
	@Size(max = 300)
	private String notes;
	private String name;
	

	
	
	public String getName() {
		return name;
	}

	public void setName() {
		this.name = city + " " + street + " " + number + extNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public void setId(long id) {
		this.id = id;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}



	public long getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getExtNumber() {
		return extNumber;
	}

	public void setExtNumber(String extNumber) {
		this.extNumber = extNumber;
	}

	public Building() {
		super();
	}
	
	
}
