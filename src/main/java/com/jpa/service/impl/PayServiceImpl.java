package com.jpa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jpa.domain.Pay;
import com.jpa.dto.PayDto;
import com.jpa.repository.PayRepository;
import com.jpa.service.PayService;

@Service("payService")
public class PayServiceImpl implements PayService{

	@Resource(name="payRepository")
	private PayRepository payRepository;

	@Override
	public List<Pay> selectList() throws Exception {
		return payRepository.selectList();
	}

	@Override
	public void insert(PayDto payDto) throws Exception {
		payRepository.insert(payDto);
	}
}
