package com.teluschallenge.mapping.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "technician")
@JsonIgnoreProperties(ignoreUnknown = true )
public class Technician {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty( "id" )
	@XmlElement( required = true )
	private Long id;

	@JsonProperty( "firstName" )
	@XmlElement( required = true )
	@Column(name = "first_name")
	private String firstName;
	

	@JsonProperty( "lastName" )
	@XmlElement( required = true )
	@Column(name = "last_name")
	private String lastName;
	
	
	@JsonProperty( "email" )
	@XmlElement( required = true )
	@Column(name = "email")
	private String email;

	public Technician() {

	}

	public Technician(Long id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "technician_id")

	private Assignment assignment;

//	public Assignment getAssignment() {
//		return assignment;
//	}
//
//	public void setAssignment(Assignment assignment) {
//		this.assignment = assignment;
//	}
}
