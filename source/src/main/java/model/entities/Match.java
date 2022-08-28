package model.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name = "Match")
public class Match implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JoinColumn(name = "FK_Pet_Requester", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Pet requester;
	
	@ManyToOne
	private Pet applicant;
	
	public Match() {
		
	}

	public Integer getId() {
		return id;
	}
	
	public Pet getRequester() {
		return requester;
	}
	
	public Pet getApplicant() {
		return applicant;
	}

	public void setId(Integer id) {
		this.id = id;
	}	

	public void setRequester(Pet requester) {
		this.requester = requester;
	}	

	public void setApplicant(Pet applicant) {
		this.applicant = applicant;
	}
	
}
