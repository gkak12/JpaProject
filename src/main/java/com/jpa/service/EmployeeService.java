package com.jpa.service;

import java.util.List;

import com.jpa.domain.Employee;
import com.jpa.domain.EmployeeSearchParam;

public interface EmployeeService {

	public List<Employee> selectList(EmployeeSearchParam employeeSearchParam);
}
