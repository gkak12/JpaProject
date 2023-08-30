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
@Table(schema="jpa", name="grade")
public class Grade {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="grade")
	@JsonManagedReference
	private List<Employee> employeeList;
}

//DDL
//CREATE TABLE jpa.grade (
//		id serial NOT NULL,
//		"name" varchar NULL,
//	CONSTRAINT grade_pkey PRIMARY KEY (id)
//);