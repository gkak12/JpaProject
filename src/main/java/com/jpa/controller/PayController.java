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

import com.jpa.dto.PayDto;
import com.jpa.service.PayService;

@RestController
@RequestMapping(value="/pay")
public class PayController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PayController.class);
	
	@Resource(name="payService")
	private PayService payService;

	@GetMapping(value="/selectList.json")
	public Map<String, Object> selectList(){
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("LIST", payService.selectList());
		return res;
	}
	

	@PostMapping(value="/insert.json")
	public Map<String, String> insert(@RequestBody PayDto payDto){
		LOGGER.debug(payDto.toString());
		
		Map<String, String> res = new HashMap<String, String>();
		payService.insert(payDto);
		
		res.put("MSG", "SUCCESS");
		return res;
	}
}
