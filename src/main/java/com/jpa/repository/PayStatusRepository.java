package com.jpa.repository;

import com.jpa.domain.PayStatus;

public interface PayStatusRepository {

	public PayStatus selectOne(int payStatusId);
}
