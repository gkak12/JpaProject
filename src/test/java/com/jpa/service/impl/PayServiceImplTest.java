package com.jpa.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.domain.Pay;
import com.jpa.repository.PayRepository;

@SpringBootTest
@Transactional
class PayServiceImplTest {

	@Autowired
	private PayRepository payRepository;
	
	@Test
	public void 급여_전체_조회_테스트() {
		try {
			List<Pay> list = payRepository.selectList();
			assertNotNull(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


