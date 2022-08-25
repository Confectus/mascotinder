package model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity (name = "Owner")
public class Owner implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String email;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "password")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "owner")
	private List<Pet> misMascotas;
	
	
	public Owner() {}


	

	public Owner(String email, String name, String password, List<Pet> misMascotas) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.misMascotas = misMascotas;
	}




	public List<Pet> getMisMascotas() {
		return misMascotas;
	}




	public void setMisMascotas(List<Pet> misMascotas) {
		this.misMascotas = misMascotas;
	}




	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
}
