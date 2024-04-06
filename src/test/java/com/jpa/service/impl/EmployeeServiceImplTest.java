package com.jpa.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jpa.domain.Employee;
import com.jpa.repository.EmployeeRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="classpath:application.yml")
class EmployeeServiceImplTest {

	@Resource(name="employeeRepository")
	private EmployeeRepository employeeRepository;
	
	@Test
	void 직원_페이징_테스트() {
		try {
			List<Employee> list = employeeRepository.selectListPaging(0, 5);
			assertTrue(list.size() > 0, "SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
