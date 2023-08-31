package com.jpa.service;

import java.util.List;

import com.jpa.domain.Employee;
import com.jpa.dto.EmployeeDto;
import com.jpa.dto.TeamDto;
import com.jpa.param.EmployeeSearchParam;

public interface EmployeeService {

	public List<Employee> selectList(EmployeeSearchParam employeeSearchParam);
	
	public List<TeamDto> selectCountByTeam();
	
	public List<Employee> selectListPaging(int pageNum, int pageRow);
	
	public void insertBatch(List<EmployeeDto> list);
}
