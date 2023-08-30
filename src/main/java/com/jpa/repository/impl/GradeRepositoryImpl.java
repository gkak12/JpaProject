package com.jpa.repository.impl;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.jpa.domain.Grade;
import com.jpa.domain.QGrade;
import com.jpa.dto.GradeDto;
import com.jpa.repository.GradeRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository("gradeRepository")
@RequiredArgsConstructor
public class GradeRepositoryImpl implements GradeRepository{

	private final JPAQueryFactory queryFactory;
	
	private final EntityManager entityManager;

	@Override
	public Grade selectOneById(int id) {
		QGrade grade = QGrade.grade;
		
		Grade g = queryFactory
					.select(grade)
					.from(grade)
					.where(grade.id.eq(id))
					.fetchOne();
		
		return g;
	}
	
	@Override
	public void insert(GradeDto gradeDto) {
		Grade grade = new Grade();
		grade.setName(gradeDto.getName());
		
		entityManager.persist(grade);
	}
}
