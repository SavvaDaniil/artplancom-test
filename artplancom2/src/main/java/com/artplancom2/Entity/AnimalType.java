package com.artplancom2.Entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "animaltype")//, schema="schemaname"
public class AnimalType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", columnDefinition="int(11)")
	private int id;
	
	@Column(name="title", nullable=true, columnDefinition="varchar(256)")
    private String title;

	

    //@OneToOne(fetch = FetchType.LAZY, mappedBy = "animalType")
    //private TestEntity testentity;
	
	/*
	@JoinTable(name = "AnimalTypes_testEntity")
	@OneToMany
	private Set<TestEntity> testEnities;
    
	
	*/
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	
}
