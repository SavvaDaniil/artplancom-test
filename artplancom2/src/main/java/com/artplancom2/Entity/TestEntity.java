package com.artplancom2.Entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "testentity")
public class TestEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="te_id", columnDefinition="int(11)")
	private int id;

	@Column(name="username", nullable=true, columnDefinition="varchar(256)")
    private String username;

	@Column(name="password", nullable=true, columnDefinition="varchar(256)")
    private String password;

	@Column(name="auth_key", nullable=true, columnDefinition="varchar(256)")
    private String authKey;

	@Column(name="access_token", nullable=true, columnDefinition="varchar(256)")
    private String accessToken;

	@Column(name="active")
    private int active;

	/*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "emp_testentityconnection",
    joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "id") },
    inverseJoinColumns = {@JoinColumn(name = "workstation_id", referencedColumnName = "id") })
    private TestEntityConnection workStation;
	*/
	/*
	@ManyToOne
	@MapsId
	//@PrimaryKeyJoinColumn(name="userId", referencedColumnName="user_id")
	@JoinColumn(name = "userId", referencedColumnName = "user_id")
	private User userOwner;
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name = "userId", referencedColumnName = "id")
	private User userOwner;

	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name = "animaltypeId", referencedColumnName = "id")
	private AnimalType animalType;
	
	
	@ManyToOne
	@MapsId
	@JoinColumn(name = "animaltypeId", referencedColumnName = "at_id")
	private AnimalType animalType;
	*/
	/*
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@MapsId
	//@PrimaryKeyJoinColumn(name="userId", referencedColumnName="user_id")
	@JoinColumn(name = "userId", referencedColumnName = "user_id")
	private User userOwner;
	*/

	
	
}
