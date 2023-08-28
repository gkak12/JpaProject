package com.jpa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jpa.dto.GradeDto;
import com.jpa.repository.GradeRepository;
import com.jpa.service.GradeService;

@Service("gradeService")
public class GradeServiceImpl implements GradeService{

	@Resource(name="gradeRepository")
	private GradeRepository gradeRepository;
	
	@Override
	public void insert(GradeDto gradeDto) {
		gradeRepository.insert(gradeDto);
	}
}
