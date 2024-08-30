package com.jpa.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jpa.domain.Attendance;
import com.jpa.repository.AttendanceRepository;
import com.jpa.service.impl.AttendanceServiceImpl;

@ExtendWith(MockitoExtension.class)
class AttendanceControllerTest {

	@Mock
	private AttendanceRepository attendanceRepository;
	
	@InjectMocks
	private AttendanceServiceImpl attendanceService;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void 근태_조회_테스트() throws Exception {
		// Given
        List<Attendance> expList = new ArrayList<>();
        expList.add(new Attendance()); // Add mock data if needed
        when(attendanceRepository.selectList()).thenReturn(expList);

        // When
        List<Attendance> result = attendanceService.selectList();

        // Then
        assertEquals(expList.size(), result.size());
	}
}
