package model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity (name = "owner")
public class Owner implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String email;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "password")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "owner")
	private List<Pet> myPets;	
	
	public Owner() {
		super();
	}

	public Owner(String email, String name, String password) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setMyPets(List<Pet> myPets) {
		this.myPets = myPets;
	}	

	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}

	public List<Pet> getMyPets() {
		return myPets;
	}	
	
}
