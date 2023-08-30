package com.jpa.repository;

import java.util.List;

import com.jpa.domain.Employee;
import com.jpa.dto.EmployeeDto;
import com.jpa.dto.TeamDto;
import com.jpa.param.EmployeeSearchParam;

public interface EmployeeRepository {

	public List<Employee> selectList(EmployeeSearchParam employeeSearchParam);
	
	public List<TeamDto> selectCountByTeam();
	
	public void insertBatch(List<EmployeeDto> list);
}
