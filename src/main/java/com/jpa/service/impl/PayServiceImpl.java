package com.jpa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jpa.domain.Pay;
import com.jpa.repository.PayRepository;
import com.jpa.service.PayService;

@Service("payService")
public class PayServiceImpl implements PayService{

	@Resource(name="payRepository")
	private PayRepository payRepository;

	@Override
	public List<Pay> selectList() {
		return payRepository.selectList();
	}
}
