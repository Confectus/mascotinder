package model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "Preference")
public class Preference implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "specie")
	private String specie;
	
	@Column(name = "minimunAge")
	private Integer minimumAge;
	
	@Column(name = "maximumAge")
	private Integer maximumAge;
	
	@JoinColumn(name = "FK_Pet")
	@OneToOne
	private Pet pet;
	
	public Preference(){}
	
	
	
	public Preference(Integer id, String type, String specie, Integer minimumAge, Integer maximumAge, Pet pet) {
		super();
		this.id = id;
		this.type = type;
		this.specie = specie;
		this.minimumAge = minimumAge;
		this.maximumAge = maximumAge;
		this.pet = pet;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSpecie() {
		return specie;
	}
	public void setSpecie(String specie) {
		this.specie = specie;
	}
	public Integer getMinimumAge() {
		return minimumAge;
	}
	public void setMinimumAge(Integer minimumAge) {
		this.minimumAge = minimumAge;
	}
	public Integer getMaximumAge() {
		return maximumAge;
	}
	public void setMaximumAge(Integer maximumAge) {
		this.maximumAge = maximumAge;
	}
	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}

	@Override
	public String toString() {
		return "Preference [id=" + id + ", type=" + type + ", specie=" + specie + ", minimumAge=" + minimumAge
				+ ", maximumAge=" + maximumAge + ", pet=" + pet + "]";
	}
	
	
	
	
	

}
