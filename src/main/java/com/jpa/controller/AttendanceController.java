package com.jpa.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.common.Ajax;
import com.jpa.service.AttendanceService;

@RestController
@RequestMapping(value="/attendance")
public class AttendanceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AttendanceController.class);
	
	@Resource(name="attendanceService")
	private AttendanceService attendanceService;
	
	@GetMapping(value="/selectList.json")
	public Map<Ajax, Object> selectList(){
		Map<Ajax, Object> res = new HashMap<Ajax, Object>();
		
		try {
			res.put(Ajax.LIST, attendanceService.selectList());
			res.put(Ajax.MSG, Ajax.SUCCESS);
		} catch (Exception e) {
			res.put(Ajax.MSG, Ajax.FAIL);
			LOGGER.debug(e.toString());
		}
		
		return res;
	}
}
