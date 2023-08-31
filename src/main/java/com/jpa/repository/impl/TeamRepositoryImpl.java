package com.jpa.repository.impl;

import org.springframework.stereotype.Repository;

import com.jpa.domain.QTeam;
import com.jpa.domain.Team;
import com.jpa.repository.TeamRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository("teamRepository")
@RequiredArgsConstructor
public class TeamRepositoryImpl implements TeamRepository{

	private final JPAQueryFactory queryFactory;
	
	@Override
	public Team selectOneById(int id) throws Exception {
		QTeam team = QTeam.team;
		
		Team t = queryFactory.select(team).from(team).where(team.id.eq(id)).fetchOne();
		return t;
	}
}
