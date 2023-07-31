package com.jpa.repository.impl;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.jpa.domain.Employee;
import com.jpa.domain.EmployeeSearchParam;
import com.jpa.domain.QEmployee;
import com.jpa.domain.QTeam;
import com.jpa.repository.EmployeeRepository;
import com.querydsl.jpa.JPQLQuery;

@Repository("employeeRepository")
public class EmployeeRepositoryImpl extends QuerydslRepositorySupport implements EmployeeRepository{

	public EmployeeRepositoryImpl() {
		super(Employee.class);
	}
	
	@Override
	public List<Employee> selectList(EmployeeSearchParam employeeSearchParam) {
		QEmployee employee = QEmployee.employee;
		QTeam team = QTeam.team;

		JPQLQuery query = from(employee);
		query
			.leftJoin(employee.team, team)
			.where(employee.name.contains(employeeSearchParam.getName()));
		
		return query.fetch();
	}
}
