package com.jpa.service;

import java.util.List;

import com.jpa.domain.Attendance;

public interface AttendanceService {

	public List<Attendance> selectList() throws Exception;
}
