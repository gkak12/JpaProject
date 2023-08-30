package com.jpa.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(schema="jpa", name="employee")
@SequenceGenerator(
	name="EMPLOYEE_SEQ_GENERATOR",
	sequenceName="EMPLOYEE_SEQ",
	initialValue=1,
	allocationSize=5
)
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLOYEE_SEQ_GENERATOR")
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="contract")
	private String contract;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="team_id", foreignKey=@ForeignKey(name="employee_team_fk"))
	private Team team;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="grade_id", foreignKey=@ForeignKey(name="employee_grade_fk"))
	private Grade grade;
	
	@OneToMany(mappedBy="employee")
	@JsonManagedReference
	private List<Attendance> attendanceList;
	
	@OneToMany(mappedBy="employee")
	@JsonManagedReference
	private List<Pay> payList;
	
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

//DDL
//CREATE TABLE jpa.employee (
//	id serial NOT NULL,
//	"name" varchar NULL,
//	email varchar NULL,
//	contract varchar NULL,
//	team_id int4 NULL,
//	grade_id int4 NULL,
//	CONSTRAINT employee_pkey PRIMARY KEY (id),
//	CONSTRAINT employee_grade_fk FOREIGN KEY (grade_id) REFERENCES grade(id),
//	CONSTRAINT employee_team_fk FOREIGN KEY (team_id) REFERENCES team(id)
//);