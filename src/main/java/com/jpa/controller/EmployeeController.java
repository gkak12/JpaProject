package com.jpa.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.domain.EmployeeSearchParam;
import com.jpa.service.EmployeeService;

@RestController
public class EmployeeController {

	@Resource(name="employeeService")
	private EmployeeService employeeService;
	
	@GetMapping(value="/list.json")
	public Map<String, Object> list(EmployeeSearchParam employeeSearchParam){
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("LIST", employeeService.selectList(employeeSearchParam));
		return res;
	}
}
