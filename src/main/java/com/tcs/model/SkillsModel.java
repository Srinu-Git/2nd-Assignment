package com.tcs.model;

import lombok.Data;

@Data
public class SkillsModel {
	private Long id;
	private String skill;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
}
