package com.jpa.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.service.AttendanceService;

@RestController
@RequestMapping(value="/attendance")
public class AttendanceController {

	@Resource(name="attendanceService")
	private AttendanceService attendanceService;
	
	@GetMapping(value="/selectList.json")
	public Map<String, Object> selectList(){
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("LIST", attendanceService.selectList());
		return res;
	}
}
