package model.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "age")
	private int age;
	
	@JoinColumn(name = "FK_Pet_Owner")
	@ManyToOne
	private Owner owner;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "pet")
	private Preference preference;
	
	
	
	
	
	public Pet() {}

	public Pet(Integer id, String name, String type, String sex, int age,Owner owner) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.sex = sex;
		this.age = age;
		this.owner=owner;
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

	

	public int getAge() {
		return age;
	}
	
	public Owner getOwner() {
		return owner;
	}
	
	public String getSex() {
		return sex;
	}

	
	/* Setters */
	

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", type=" + type + ", specie=" + sex + ", age=" + age
				+  "]";
	}


	
	
	
}
