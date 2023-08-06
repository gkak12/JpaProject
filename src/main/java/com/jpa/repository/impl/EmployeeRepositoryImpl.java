package com.jpa.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jpa.domain.Employee;
import com.jpa.domain.EmployeeSearchParam;
import com.jpa.domain.QEmployee;
import com.jpa.repository.EmployeeRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository("employeeRepository")
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository{
	private final JPAQueryFactory queryFactory;
	
	@Override
	public List<Employee> selectList(EmployeeSearchParam employeeSearchParam) {
		QEmployee employee = QEmployee.employee;

		List<Employee> list = queryFactory
								.selectFrom(employee)
								.where(employee.id.contains(employeeSearchParam.getId()))
								.fetch();

		return list;
	}
}
