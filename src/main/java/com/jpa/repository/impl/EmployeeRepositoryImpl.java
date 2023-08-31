package com.jpa.repository.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.jpa.domain.Employee;
import com.jpa.domain.Grade;
import com.jpa.domain.QEmployee;
import com.jpa.domain.QGrade;
import com.jpa.domain.QTeam;
import com.jpa.domain.Team;
import com.jpa.dto.EmployeeDto;
import com.jpa.dto.TeamDto;
import com.jpa.param.EmployeeSearchParam;
import com.jpa.repository.EmployeeRepository;
import com.jpa.repository.GradeRepository;
import com.jpa.repository.TeamRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository("employeeRepository")
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository{
	
	private final JPAQueryFactory queryFactory;
	
	private final EntityManager entityManager;
	
	@Resource(name="teamRepository")
	private TeamRepository teamRepository;
	
	@Resource(name="gradeRepository")
	private GradeRepository gradeRepository;
	
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
	public List<TeamDto> selectCountByTeam() {
		QEmployee employee = QEmployee.employee;
		QTeam team = QTeam.team;
		
		List<TeamDto> list = queryFactory
								.select(team.name, team.employeeList.size())
								.from(team)
								.join(team.employeeList, employee)
								.groupBy(team.id)
								.fetch()
								.stream()
								.map(tuple -> TeamDto.builder()
												.name(tuple.get(team.name))
												.count(tuple.get(team.employeeList.size()))
												.build())
								.collect(Collectors.toList());
		
		return list;
	}
	
	@Override
	public List<Employee> selectListPaging(int pageNum, int pageRow) {
		QEmployee employee = QEmployee.employee;
		
		List<Employee> list = queryFactory
								.select(employee)
								.from(employee)
								.orderBy(employee.id.asc())
								.offset(pageNum)
								.limit(pageRow)
								.fetch();
		return list;
	}

	@Override
	public void insertBatch(List<EmployeeDto> list) {
		int cnt = 0;
		
		for(EmployeeDto item : list) {
			Employee e = new Employee();
			e.setName(item.getName());
			e.setEmail(item.getEmail());
			e.setContract(item.getContract());
			
			Team team = teamRepository.selectOneById(item.getTeamId());
			e.setTeam(team);
			
			Grade grade = gradeRepository.selectOneById(item.getGradeId());
			e.setGrade(grade);
			
			entityManager.persist(e);
			cnt++;
			
			if(cnt % 5 == 0) {
				entityManager.flush();
				entityManager.clear();
			}
		}
	}
}
