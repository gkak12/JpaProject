package com.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="contract")
	private String contract;
	
	@ManyToOne(fetch=FetchType.LAZY) @JsonBackReference
	@JoinColumn(name="team_id", foreignKey=@ForeignKey(name="employee_team_fk"))
	private Team team;
	
	@ManyToOne(fetch=FetchType.LAZY) @JsonBackReference
	@JoinColumn(name="grade_id", foreignKey=@ForeignKey(name="employee_grade_fk"))
	private Grade grade;
	
	public void setTeam(Team team) {
		if(this.team != null) {
			this.team.getEmployeeList().remove(this);
		}
		
		this.team = team;
		team.getEmployeeList().add(this);
	}
	
	public void setGrade(Grade grade) {
		if(this.grade != null) {
			this.grade.getEmployeeList().remove(this);
		}
		
		this.grade = grade;
		grade.getEmployeeList().add(this);
	}
}
