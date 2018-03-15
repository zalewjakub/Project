package project.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "notes")
public class Notes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	@Size(min=2, max = 200)
	private String textInfo;
	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp created;
	@ManyToOne
	private Homeovner homeovner;
	
	
	public Notes() {
		this.created = getCreated();
	}
	
	
	public String getTextInfo() {
		return textInfo;
	}


	public void setTextInfo(String textInfo) {
		this.textInfo = textInfo;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
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

}
