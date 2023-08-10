package com.jpa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jpa.domain.Attendance;
import com.jpa.repository.AttendanceRepository;
import com.jpa.service.AttendanceService;

@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceService{

	@Resource(name="attendanceRepository")
	private AttendanceRepository attendanceRepository;

	@Override
	public List<Attendance> selectList() {
		return attendanceRepository.selectList();
	}
}
