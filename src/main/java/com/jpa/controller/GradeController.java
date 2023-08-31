package com.jpa.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.dto.GradeDto;
import com.jpa.service.GradeService;

@RestController
@RequestMapping(value="/grade")
public class GradeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(GradeController.class);
	
	@Resource(name="gradeService")
	private GradeService gradeService;
	
	@PostMapping(value="/insert.json")
	public Map<String, String> insert(@RequestBody GradeDto gradeDto){
		Map<String, String> res = new HashMap<String,String>();
		LOGGER.debug(gradeDto.toString());
		
		try {
			gradeService.insert(gradeDto);
			res.put("RESULT", "SUCCESS");
		} catch (Exception e) {
			res.put("RESULT", "FAIL");
			res.put("MSG", e.toString());
		}
		
		return res;
	}
}
