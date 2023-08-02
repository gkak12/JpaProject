package com.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="grade")
public class Grade {

	@Id @GeneratedValue
	@Column(name="id")
	private String id;
	
	@Column(name="name")
	private String name;
}
