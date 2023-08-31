package com.jpa.repository;

import com.jpa.domain.Grade;
import com.jpa.dto.GradeDto;

public interface GradeRepository {
	
	public Grade selectOneById(int id) throws Exception;
	
	public void insert(GradeDto gradeDto) throws Exception;

}
