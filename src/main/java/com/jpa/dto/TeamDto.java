package com.jpa.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamDto {

	private String name;
	
	private Integer count;
}
