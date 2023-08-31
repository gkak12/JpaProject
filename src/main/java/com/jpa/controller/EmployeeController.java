package com.jpa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.dto.EmployeeDto;
import com.jpa.param.EmployeeSearchParam;
import com.jpa.service.EmployeeService;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {

	@Resource(name="employeeService")
	private EmployeeService employeeService;
	
	@GetMapping(value="/selectList.json")
	public Map<String, Object> selectList(EmployeeSearchParam employeeSearchParam){
		Map<String, Object> res = new HashMap<String, Object>();
		
		try {
			res.put("LIST", employeeService.selectList(employeeSearchParam));
			res.put("RESULT", "SUCCESS");
		} catch (Exception e) {
			res.put("RESULT", "FAIL");
			res.put("MSG", e.toString());
		}
		
		return res;
	}
	
	@GetMapping(value="/selectCountByTeam.json")
	public Map<String, Object> selectCountByTeam(){
		Map<String, Object> res = new HashMap<String, Object>();
		
		try {
			res.put("LIST", employeeService.selectCountByTeam());
			res.put("RESULT", "SUCCESS");
		} catch (Exception e) {
			res.put("RESULT", "FAIL");
			res.put("MSG", e.toString());
		}
		
		return res;
	}
	
	@GetMapping(value="/selectListPaging.json")
	public Map<String, Object> selectListPaging(@RequestParam(name="pageNum", required=true) int pageNum, @RequestParam(name="pageRow", required=true) int pageRow){
		Map<String, Object> res = new HashMap<String, Object>();
		
		try {
			res.put("LIST", employeeService.selectListPaging(pageNum, pageRow));
			res.put("RESULT", "SUCCESS");
		} catch (Exception e) {
			res.put("RESULT", "FAIL");
			res.put("MSG", e.toString());
		}
		
		return res;
	}
	
	@PostMapping(value="/insertBatch.json")
	public Map<String, String> insertBatch(@RequestBody List<EmployeeDto> list){
		Map<String, String> res = new HashMap<String, String>();
		
		try {
			employeeService.insertBatch(list);
			res.put("RESULT", "SUCCESS");
		} catch (Exception e) {
			res.put("RESULT", "FAIL");
			res.put("MSG", e.toString());
		}
		
		return res;
	}
}
