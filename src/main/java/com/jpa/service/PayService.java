package com.jpa.service;

import java.util.List;

import com.jpa.domain.Pay;
import com.jpa.dto.PayDto;

public interface PayService {

	public List<Pay> selectList() throws Exception;
	
	public void insert(PayDto payDto) throws Exception;
}
