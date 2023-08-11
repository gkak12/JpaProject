package com.jpa.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jpa.domain.Attendance;
import com.jpa.domain.QAttendance;
import com.jpa.domain.QEmployee;
import com.jpa.repository.AttendanceRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository("attendanceRepository")
@RequiredArgsConstructor
public class AttendanceRepositoryImpl implements AttendanceRepository{
	
	private final JPAQueryFactory queryFactory;

	@Override
	public List<Attendance> selectList() {
		QAttendance attendance = QAttendance.attendance;
		QEmployee employee = QEmployee.employee;
		
		List<Attendance> list = queryFactory
									.selectDistinct(attendance)
									.from(attendance)
									.join(attendance.employee, employee)
									.fetch();
		
		return list;
	}
}
