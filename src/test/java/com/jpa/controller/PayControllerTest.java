package com.jpa.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.jpa.service.PayService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(
		controllers=PayController.class,
		excludeAutoConfiguration = SecurityAutoConfiguration.class
)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("PayController 테스트 클래스 ")
class PayControllerTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(PayControllerTest.class);
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean(name="payService")
	private PayService payService;
	
	@Test
	@Order(1)
	public void pay_insert_파라미터_전달_테스트() {
		LOGGER.debug("pay_insert_파라미터_전달_테스트");
		
		String url = "/pay/insert.json";
		String content = "{\"payId\": {\"id\": 1, \"date\": \"2023-08-11 12:00:00\"}, \"employee\": {\"id\": 1}, \"salary\": 5000, \"payStatus\": {\"id\": 1}}";
		
		try {
			mockMvc.perform(MockMvcRequestBuilders
								.post(url)
								.contentType(MediaType.APPLICATION_JSON_VALUE)
								.content(content))
					.andExpect(result -> {
						MockHttpServletResponse response = result.getResponse();
						String res = response.getContentAsString();
						
						LOGGER.debug("================== " + res + " ==================");
						assertTrue(res.contains("SUCCESS"));
					});
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
		}
	}

}



