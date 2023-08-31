package com.jpa.repository;

import java.util.List;

import com.jpa.domain.Attendance;

public interface AttendanceRepository {

	public List<Attendance> selectList() throws Exception;
}
