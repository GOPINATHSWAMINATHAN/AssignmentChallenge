package com.teluschallenge.mapping.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "assignment")
public class Assignment {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty( "id" )
	@XmlElement( required = true )
	private Long id;
	
	@JsonProperty( "technicianId" )
	@XmlElement( required = true )
	@Column(name = "technician_id")
	private Long technicianId;
	
	@JsonProperty( "startTime" )
	@XmlElement( required = true )
	@Column(name = "start_time")
	private LocalDateTime startTime;
	
	@JsonProperty( "endTime" )
	@XmlElement( required = true )
	@Column(name = "end_time")
	private LocalDateTime endTime;
	
		
	public Assignment() {
	}

	public Assignment(Long id, Long technicianId, LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.id = id;
		this.technicianId = technicianId;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTechnicianId() {
		return technicianId;
	}

	public void setTechnicianId(Long techId) {
		this.technicianId = techId;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "assignment")
	
	private Technician technician;


//	public Technician getTechnician() {
//		return technician;
//	}
//
//	public void setTechnician(Technician technician) {
//		this.technician = technician;
//	}
	
}
