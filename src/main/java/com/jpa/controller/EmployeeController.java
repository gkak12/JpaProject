package com.jpa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.common.Ajax;
import com.jpa.dto.EmployeeDto;
import com.jpa.param.EmployeeSearchParam;
import com.jpa.service.EmployeeService;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Resource(name="employeeService")
	private EmployeeService employeeService;
	
	@GetMapping(value="/selectList.json")
	public Map<Ajax, Object> selectList(EmployeeSearchParam employeeSearchParam){
		Map<Ajax, Object> res = new HashMap<Ajax, Object>();
		
		try {
			res.put(Ajax.LIST, employeeService.selectList(employeeSearchParam));
			res.put(Ajax.MSG, Ajax.SUCCESS);
		} catch (Exception e) {
			res.put(Ajax.MSG, Ajax.FAIL);
			LOGGER.debug(e.toString());
		}
		
		return res;
	}
	
	@GetMapping(value="/selectCountByTeam.json")
	public Map<Ajax, Object> selectCountByTeam(){
		Map<Ajax, Object> res = new HashMap<Ajax, Object>();
		
		try {
			res.put(Ajax.LIST, employeeService.selectCountByTeam());
			res.put(Ajax.MSG, Ajax.SUCCESS);
		} catch (Exception e) {
			res.put(Ajax.MSG, Ajax.FAIL);
			LOGGER.debug(e.toString());
		}
		
		return res;
	}
	
	@GetMapping(value="/selectListPaging.json")
	public Map<Ajax, Object> selectListPaging(@RequestParam(name="pageNum", required=true) int pageNum, @RequestParam(name="pageRow", required=true) int pageRow){
		Map<Ajax, Object> res = new HashMap<Ajax, Object>();
		
		try {
			res.put(Ajax.LIST, employeeService.selectListPaging(pageNum, pageRow));
			res.put(Ajax.MSG, Ajax.SUCCESS);
		} catch (Exception e) {
			res.put(Ajax.MSG, Ajax.FAIL);
			LOGGER.debug(e.toString());
		}
		
		return res;
	}
	
	@PostMapping(value="/insertBatch.json")
	public Map<Ajax, String> insertBatch(@RequestBody List<EmployeeDto> list){
		Map<Ajax, String> res = new HashMap<Ajax, String>();
		
		try {
			employeeService.insertBatch(list);
			res.put(Ajax.MSG, Ajax.SUCCESS.upperCase());
		} catch (Exception e) {
			res.put(Ajax.MSG, Ajax.FAIL.upperCase());
			LOGGER.debug(e.toString());
		}
		
		return res;
	}
}
