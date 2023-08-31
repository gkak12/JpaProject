package com.jpa.repository;

import java.util.List;

import com.jpa.domain.Employee;
import com.jpa.dto.EmployeeDto;
import com.jpa.dto.TeamDto;
import com.jpa.param.EmployeeSearchParam;

public interface EmployeeRepository {

	public List<Employee> selectList(EmployeeSearchParam employeeSearchParam) throws Exception;
	
	public List<TeamDto> selectCountByTeam() throws Exception;
	
	public List<Employee> selectListPaging(int pageNum, int pageRow) throws Exception;
	
	public void insertBatch(List<EmployeeDto> list) throws Exception;
}
