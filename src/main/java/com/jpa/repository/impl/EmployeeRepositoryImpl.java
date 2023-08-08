package com.jpa.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jpa.domain.Employee;
import com.jpa.domain.EmployeeSearchParam;
import com.jpa.domain.QEmployee;
import com.jpa.domain.QGrade;
import com.jpa.domain.QTeam;
import com.jpa.domain.Team;
import com.jpa.repository.EmployeeRepository;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository("employeeRepository")
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository{
	private final JPAQueryFactory queryFactory;
	
	@Override
	public List<Employee> selectList(EmployeeSearchParam employeeSearchParam) {
		QEmployee employee = QEmployee.employee;
		QTeam team = QTeam.team;
		QGrade grade = QGrade.grade;

		List<Employee> list = queryFactory
								.selectDistinct(employee)
								.from(employee)
								.join(employee.team, team)
								.join(employee.grade, grade)
								.where(employee.id.eq(employeeSearchParam.getId()))
								.fetch();

		return list;
	}

	@Override
	public List<Tuple> selectCountByTeam() {
		QEmployee employee = QEmployee.employee;
		QTeam team = QTeam.team;
		
		List<Tuple> list = queryFactory
								.select(team.name, team.employeeList.size())
								.from(team)
								.join(team.employeeList, employee)
								.groupBy(team.id)
								.fetch();
		return list;
	}
}
