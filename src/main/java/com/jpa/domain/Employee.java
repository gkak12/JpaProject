package com.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employee")
public class Employee {

	@Id @GeneratedValue
	@Column(name="id")
	private String id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="contract")
	private String contract;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="team_id", foreignKey=@ForeignKey(name="employee_team_fk"))
	private Team team;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="grade_id", foreignKey=@ForeignKey(name="employee_grade_fk"))
	private Grade grade;
}
