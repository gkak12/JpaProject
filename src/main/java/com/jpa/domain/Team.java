package com.jpa.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(schema="jpa", name="team")
public class Team {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="team")
	@JsonManagedReference
	private List<Employee> employeeList;
}

//DDL
//CREATE TABLE jpa.team (
//	id serial NOT NULL,
//	"name" varchar NULL,
//	CONSTRAINT team_pkey PRIMARY KEY (id)
//);