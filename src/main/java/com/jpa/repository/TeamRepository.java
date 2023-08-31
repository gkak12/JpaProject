package com.jpa.repository;

import com.jpa.domain.Team;

public interface TeamRepository {

	public Team selectOneById(int id) throws Exception;
}
