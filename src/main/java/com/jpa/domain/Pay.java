package com.jpa.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jpa.domain.id.PayId;

import lombok.Data;

@Data
@Entity
@Table(name="pay")
public class Pay {
	
	@EmbeddedId
	private PayId payId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="employee_id", insertable = false, updatable = false, foreignKey=@ForeignKey(name="pay_employee_fk"))
	private Employee employee;
	
	@Column(name="salary")
	private int salary;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="status", foreignKey=@ForeignKey(name="pay_status_fk"))
	private PayStatus payStatus;
	
	public void setEmployee(Employee employee) {
		if(this.employee != null) {
			this.employee.getPayList().remove(this);
		}
		
		this.employee = employee;
		employee.getPayList().add(this);
	}
}

//DDL
//CREATE TABLE jpa.pay (
//	employee_id int4 NOT NULL,
//	"date" timestamp NOT NULL,
//	salary int4 NULL,
//	status int4 NULL,
//	CONSTRAINT pay_pk PRIMARY KEY (employee_id, date),
//	CONSTRAINT pay_employee_fk FOREIGN KEY (employee_id) REFERENCES employee(id),
//	CONSTRAINT pay_status_fk FOREIGN KEY (status) REFERENCES pay_status(id)
//);