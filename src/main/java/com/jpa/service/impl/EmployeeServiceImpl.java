package com.jpa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jpa.domain.Employee;
import com.jpa.domain.EmployeeSearchParam;
import com.jpa.repository.EmployeeRepository;
import com.jpa.service.EmployeeService;
import com.querydsl.core.Tuple;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Resource(name="employeeRepository")
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> selectList(EmployeeSearchParam employeeSearchParam) {
		return employeeRepository.selectList(employeeSearchParam);
	}

	@Override
	public List<Tuple> selectCountByTeam() {
		return employeeRepository.selectCountByTeam();
	}
}
