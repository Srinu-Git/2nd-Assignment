package com.tcs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.entity.SkillEntity;
import com.tcs.model.SkillsModel;
import com.tcs.repo.SkillsRepository;

/*
 * this service main purpose to write business logic
 */
@Service
public class SkillServiceImpl implements SkillService {
	@Autowired
	SkillsRepository skillsRepository;

	/*
	 * this method main purpose to get the all skills from the database
	 */
	public List<SkillsModel> getAllSkills() {
		List<SkillsModel> allSkills = new ArrayList<SkillsModel>();
		List<SkillEntity> skillsEntity = skillsRepository.findAll();
		for (SkillEntity singleSkill : skillsEntity) {
			SkillsModel skill = mapEntityToModel(singleSkill);
			allSkills.add(skill);
		}
		return allSkills;
	}

	/*
	 * this method converts entity to model
	 */
	private SkillsModel mapEntityToModel(SkillEntity skillEntity) {
		SkillsModel skillsModel = new SkillsModel();
		skillsModel.setId(skillEntity.getId());
		skillsModel.setSkill(skillEntity.getSkill());
		return skillsModel;
	}
}
