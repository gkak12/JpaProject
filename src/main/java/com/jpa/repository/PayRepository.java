package com.jpa.repository;

import java.util.List;

import com.jpa.domain.Pay;
import com.jpa.dto.PayDto;

public interface PayRepository {

	public List<Pay> selectList();
	
	public void insert(PayDto payDto);
}
