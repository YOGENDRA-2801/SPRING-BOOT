package com.yoy.hms.dto;

import org.springframework.stereotype.Component;

import com.yoy.hms.type.BloodGroup;

@Component
public class BGCount 
{
	private BloodGroup bg ;
	private Long count ;
	
	public BGCount() {
		super();
	}
	public BGCount(BloodGroup bg, Long count) {
		super();
		this.bg = bg;
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "BGCount [bg=" + bg + ", count=" + count + "]";
	}	
}
