package com.jpa.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.service.PayService;

@RestController
@RequestMapping(value="/pay")
public class PayController {
	
	@Resource(name="payService")
	private PayService payService;

	@GetMapping(value="/selectList.json")
	public Map<String, Object> selectList(){
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("LIST", payService.selectList());
		return res;
	}
}
