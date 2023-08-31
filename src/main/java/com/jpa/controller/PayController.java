package com.jpa.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.common.Ajax;
import com.jpa.dto.PayDto;
import com.jpa.service.PayService;

@RestController
@RequestMapping(value="/pay")
public class PayController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PayController.class);
	
	@Resource(name="payService")
	private PayService payService;

	@GetMapping(value="/selectList.json")
	public Map<Ajax, Object> selectList(){
		Map<Ajax, Object> res = new HashMap<Ajax, Object>();
		
		try {
			res.put(Ajax.LIST, payService.selectList());
			res.put(Ajax.MSG, Ajax.SUCCESS);
		} catch (Exception e) {
			res.put(Ajax.MSG, Ajax.FAIL);
			LOGGER.debug(e.toString());
		}
		
		return res;
	}
	

	@PostMapping(value="/insert.json")
	public Map<Ajax, String> insert(@RequestBody PayDto payDto){
		Map<Ajax, String> res = new HashMap<Ajax, String>();
		LOGGER.debug(payDto.toString());

		try {
			payService.insert(payDto);
			res.put(Ajax.MSG, Ajax.SUCCESS.upperCase());
		} catch (Exception e) {
			res.put(Ajax.MSG, Ajax.FAIL.upperCase());
			LOGGER.debug(e.toString());
		}
		
		return res;
	}
}
