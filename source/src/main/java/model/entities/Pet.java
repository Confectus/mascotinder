package model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity (name = "Pet")
public class Pet implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "specie")
	private String specie;
	
	@Column(name = "age")
	private int age;
	
	@JoinColumn(name = "FK_Pet_Owner")
	@ManyToOne
	private Owner owner;
	
	public Pet() {}

	public Pet(Integer id, String name, String type, String specie, int age) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.specie = specie;
		this.age = age;
	}
	
	/* Getters */
	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getSpecie() {
		return specie;
	}

	public int getAge() {
		return age;
	}
	
	/* Setters */
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", type=" + type + ", specie=" + specie + ", age=" + age
				+  "]";
	}
	
	
	
}
