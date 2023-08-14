package com.jpa.repository.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.jpa.domain.Pay;
import com.jpa.domain.PayStatus;
import com.jpa.domain.QEmployee;
import com.jpa.domain.QPay;
import com.jpa.domain.id.PayId;
import com.jpa.dto.PayDto;
import com.jpa.repository.PayRepository;
import com.jpa.repository.PayStatusRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository("payRepository")
@RequiredArgsConstructor
public class PayRepositoryImpl implements PayRepository{

	private final JPAQueryFactory queryFactory;
	
	private final EntityManager entityManager;
	
	@Resource(name="payStatusRepository")
	private PayStatusRepository payStatusRepository;
	
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

	@Override
	public void insert(PayDto payDto) {
		PayId payId = new PayId(payDto.getEmployeeId(), payDto.getDate());
		PayStatus payStatus = payStatusRepository.selectOne(payDto.getPayStatusId());
		
		Pay pay = new Pay();
		pay.setPayId(payId);
		pay.setSalary(payDto.getSalary());
		pay.setPayStatus(payStatus);
		
		entityManager.persist(pay);
	}
}
