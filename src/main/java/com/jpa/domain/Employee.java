package com.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="EMPLOYEE")
public class Employee {

	@Id @GeneratedValue
	@Column(name="ID")
	private String id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="CONTRACT")
	private String contract;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TEAM_ID")
	private Team team;
}
