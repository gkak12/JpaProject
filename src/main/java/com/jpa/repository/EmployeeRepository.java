package com.jpa.repository;

import java.util.List;

import com.jpa.domain.Employee;
import com.jpa.domain.EmployeeSearchParam;
import com.querydsl.core.Tuple;

public interface EmployeeRepository {

	public List<Employee> selectList(EmployeeSearchParam employeeSearchParam);
	
	public List<Tuple> selectCountByTeam();
}
