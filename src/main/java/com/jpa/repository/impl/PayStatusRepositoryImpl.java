package com.jpa.repository.impl;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.jpa.domain.PayStatus;
import com.jpa.domain.QPayStatus;
import com.jpa.repository.PayStatusRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository("payStatusRepository")
@RequiredArgsConstructor
public class PayStatusRepositoryImpl implements PayStatusRepository{

	private final JPAQueryFactory queryFactory;
	
	private final EntityManager entityManager;

	@Override
	public PayStatus selectOne(int payStatusId) {
		QPayStatus payStatus = QPayStatus.payStatus;
		
		PayStatus one = queryFactory
							.select(payStatus)
							.from(payStatus)
							.where(payStatus.id.eq(payStatusId))
							.fetchOne();
		
		return one;
	}
}
