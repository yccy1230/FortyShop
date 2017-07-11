package com.pb.entity;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private String gender;
	private String profile;
	private String usertype;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String username, String password, String gender,
			String usertype) {
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.usertype = usertype;
	}

	/** full constructor */
	public Users(String username, String password, String gender,
			String profile, String usertype) {
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.profile = profile;
		this.usertype = usertype;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProfile() {
		return this.profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getUsertype() {
		return this.usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

}