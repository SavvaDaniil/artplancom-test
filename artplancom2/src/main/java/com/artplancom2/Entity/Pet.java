package com.artplancom2.Entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pet")
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", columnDefinition="int(11)")
	private int id;
	
	@Column(name="name", nullable=true, columnDefinition="varchar(256)")
    private String name;

	@Column(name="datebirthday", nullable=true)
    private Date datebirthday;

	@Column(name="sex")
    private int sex;

	@OneToOne(cascade = CascadeType.ALL)
	//@MapsId
	@JoinColumn(name = "userId", referencedColumnName = "id")
	private User userOwner;

	@OneToOne(cascade = CascadeType.ALL)
	//@MapsId
	@JoinColumn(name = "animaltypeId", referencedColumnName = "id")
	private AnimalType animalType;

	@Column(name="dateOfAdd", nullable=true)
    private Date dateOfAdd;

	@Column(name="dateOfUpdate", nullable=true)
    private Date dateOfUpdate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDatebirthday() {
		return datebirthday;
	}

	public void setDatebirthday(Date datebirthday) {
		this.datebirthday = datebirthday;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public User getUserOwner() {
		return userOwner;
	}

	public void setUserOwner(User userOwner) {
		this.userOwner = userOwner;
	}

	public AnimalType getAnimalType() {
		return animalType;
	}

	public void setAnimalType(AnimalType animalType) {
		this.animalType = animalType;
	}

	public Date getDateOfAdd() {
		return dateOfAdd;
	}

	public void setDateOfAdd(Date dateOfAdd) {
		this.dateOfAdd = dateOfAdd;
	}

	public Date getDateOfUpdate() {
		return dateOfUpdate;
	}

	public void setDateOfUpdate(Date dateOfUpdate) {
		this.dateOfUpdate = dateOfUpdate;
	}
	
	
}
