package com.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(schema="jpa", name="attendance_status")
public class AttendanceStatus {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
}

//DDL
//CREATE TABLE jpa.attendance_status (
//	id serial NOT NULL,
//	"name" varchar NULL,
//	CONSTRAINT attendance_status_pkey PRIMARY KEY (id)
//);