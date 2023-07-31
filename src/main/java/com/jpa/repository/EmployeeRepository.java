package com.jpa.repository;

import java.util.List;

import com.jpa.domain.Employee;
import com.jpa.domain.EmployeeSearchParam;

public interface EmployeeRepository {

	public List<Employee> selectList(EmployeeSearchParam employeeSearchParam);
}
