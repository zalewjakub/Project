package project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "flat")
public class Flat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Min(value = 1)
	@Max(value = 100)
	private long number;
	@Size(max = 300)
	private String notes;
	@Min(value = (long) 20.0)
	private double area;
	@ManyToOne()
	@JoinColumn(name = "building_id")
	@NotNull
	private Building building;
	@ManyToOne()
	@JoinColumn(name = "homeowner_id")
	private Homeovner homeovner;
	private String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name + " mieszkania " + this.number;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public Building getBuilding() {
		return building;
	}
	public void setBuilding(Building building) {
		this.building = building;
	}
	public long getId() {
		return id;
	}
	
	public Homeovner getHomeovner() {
		return homeovner;
	}
	public void setHomeovner(Homeovner homeovner) {
		this.homeovner = homeovner;
	}
	public Flat() {
		super();
	}
	
	
}
