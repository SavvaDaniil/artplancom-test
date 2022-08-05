package com.artplancom2.Entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", columnDefinition="int(11)")
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

	//@Column(name="firstname", nullable=true, columnDefinition="varchar(256)")
    //private String firstname;

	@Column(name="dateOfAdd", nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateOfAdd;


	@Column(name="loginTryCount")
    private int loginTryCount;

	@Column(name="dateLoginLastTry", nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateLoginLastTry;



    //@OneToOne(fetch = FetchType.LAZY, mappedBy = "userOwner")
    //private TestEntity testentity;
	
	/*
	@JoinTable(
            name = "User_testEntity",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "te_id")
    )
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<TestEntity> testEnities;
	*/
	
	
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAuthKey() {
		return authKey;
	}


	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}


	public String getAccessToken() {
		return accessToken;
	}


	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}


	public int getActive() {
		return active;
	}


	public void setActive(int active) {
		this.active = active;
	}
	


	public int getLoginTryCount() {
		return loginTryCount;
	}


	public void setLoginTryCount(int loginTryCount) {
		this.loginTryCount = loginTryCount;
	}



	public java.util.Date getDateOfAdd() {
		return dateOfAdd;
	}


	public void setDateOfAdd(java.util.Date dateOfAdd) {
		this.dateOfAdd = dateOfAdd;
	}


	public java.util.Date getDateLoginLastTry() {
		return dateLoginLastTry;
	}


	public void setDateLoginLastTry(java.util.Date dateLoginLastTry) {
		this.dateLoginLastTry = dateLoginLastTry;
	}


	
	
	
}
