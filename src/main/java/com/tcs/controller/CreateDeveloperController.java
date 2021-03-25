package com.tcs.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tcs.model.DeveloperModel;
import com.tcs.model.SkillsModel;
import com.tcs.service.DeveloperService;
import com.tcs.service.SkillService;

import java.util.List;

/*
 * this controller main purpose to get the request from UI
 *  and and that request send it to the service and get the response from the service and that response send it to the UI
 */
@Scope(value = "session")
@Component(value = "createDeveloper")
@ELBeanName(value = "createDeveloper")
@Join(path = "/add_developer", to = "/developers/developer-form.jsf")
public class CreateDeveloperController {

	@Autowired
	private DeveloperService developerService;
	@Autowired
	private SkillService skillService;

	private DeveloperModel developerModel = new DeveloperModel();
	private List<SkillsModel> skillsModel;

	/*
	 * this method main purpose to add a new developer into database
	 */
	public String addNewDeveloper() {
		boolean developerCreated = developerService.createNewDeveloper(developerModel);
		if (developerCreated == true) {
			return "/developers/developers-list.xhtml?faces-redirect=true";
		}
		return null;
	}

	public DeveloperModel getDeveloperModel() {
		return developerModel;
	}

	@Deferred
	@RequestAction
	@IgnorePostback
	public void getGeneralSkillsList() {
		skillsModel = skillService.getAllSkills();
	}

	/*
	 * this method main purpose to get the all developers skills from DB
	 */
	public List<SkillsModel> getSkillsList() {
		return skillsModel;
	}

}
