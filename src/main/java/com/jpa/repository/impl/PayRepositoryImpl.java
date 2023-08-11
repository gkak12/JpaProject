package com.jpa.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jpa.domain.Pay;
import com.jpa.domain.QEmployee;
import com.jpa.domain.QPay;
import com.jpa.repository.PayRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository("payRepository")
@RequiredArgsConstructor
public class PayRepositoryImpl implements PayRepository{

	private final JPAQueryFactory queryFactory;
	
	@Override
	public List<Pay> selectList() {
		QPay pay = QPay.pay;
		QEmployee employee = QEmployee.employee;
		
		List<Pay> list = queryFactory
							.selectDistinct(pay)
							.from(pay)
							.join(pay.employee, employee)
							.orderBy(pay.payId.date.asc())
							.fetch();
		
		return list;
	}
}
