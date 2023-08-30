package com.jpa.dto;

import lombok.Data;

@Data
public class EmployeeDto {

	private String name;
	
	private String email;
	
	private String contract;
	
	private int teamId;
	
	private int gradeId;
}
