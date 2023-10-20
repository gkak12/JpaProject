package com.jpa.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

import com.jpa.service.EmployeeService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(
		controllers=EmployeeController.class,
		excludeAutoConfiguration = SecurityAutoConfiguration.class
)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("EmployeeController 테스트 클래스 ")
class EmployeeControllerTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeControllerTest.class);
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean(name="employeeService")
	private EmployeeService employeeService;

	@ParameterizedTest
	@CsvSource({"0, 5", "5, 5", "10, 5"})
	public void employee_페이징_파라미터_전달_테스트(int pageNum, int pageRow) {
		StringBuilder sb = new StringBuilder();
		String url = "/employee/selectListPaging.json";
		String pageUrl =  sb.append(url)
			.append("?pageNum=").append(pageNum)
			.append("&pageRow=").append(pageRow).toString();
		
		try {
			LOGGER.debug(pageUrl);
			
			mockMvc.perform(MockMvcRequestBuilders
								.get(pageUrl)
								.contentType(MediaType.APPLICATION_JSON_VALUE))
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
