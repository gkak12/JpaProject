package com.jpa.domain;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name="attendance")
public class Attendance {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="employee_id", foreignKey=@ForeignKey(name="attendance_employee_fk"))
	private Employee employee;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_time")
	private Date start_time;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_time")
	private Date end_time;
	
	@Temporal(TemporalType.TIME)
	@Column(name="work_time")
	private Date work_time;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="status", foreignKey=@ForeignKey(name="attendance_status_fk"))
	private AttendanceStatus attendanceStatus;
	
	public void setEmployee(Employee employee) {
		if(this.employee != null) {
			this.employee.getAttendanceList().remove(this);
		}
		
		this.employee = employee;
		employee.getAttendanceList().add(this);
	}
}
