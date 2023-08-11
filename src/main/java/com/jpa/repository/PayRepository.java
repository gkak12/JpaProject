package com.jpa.repository;

import java.util.List;

import com.jpa.domain.Pay;

public interface PayRepository {

	public List<Pay> selectList();
}
