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

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/*
 * this class main purpose to view  the specific  developer from database
 */
@Scope(value = "session")
@Component(value = "viewDeveloper")
@ELBeanName(value = "viewDeveloper")
@Join(path = "/view_developer/{id}", to = "/developers/view-developer.jsf")
public class ViewDeveloperController {

	@Autowired
	DeveloperService developerService;
	@Autowired
	SkillService skillService;

	private DeveloperModel developerModel = new DeveloperModel();
	private List<SkillsModel> skillsModel;

	@Deferred
	@RequestAction
	@IgnorePostback
	public void getOneDeveloper() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String id = request.getParameter("id");
		developerModel = developerService.getSingleDeveloper(Long.parseLong(id));
	}

	public DeveloperModel getDeveloper() {
		return developerModel;
	}

	@Deferred
	@RequestAction
	@IgnorePostback
	public void getGeneralSkillsList() {
		skillsModel = skillService.getAllSkills();
	}

	/*
	 * this method main purpose to return the all the developer skills from database
	 */
	public List<SkillsModel> getSkillsList() {
		return skillsModel;
	}

	/*
	 * this method main purpose to update the developer into database
	 */
	public String updateDeveloperSkills() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String id = request.getParameter("id");
		DeveloperModel currentDeveloperData = developerService.getSingleDeveloper(Long.parseLong(id));
		String skillUpdate = currentDeveloperData.getSkills() + " , " + developerModel.getSkills();
		developerModel.setSkills(skillUpdate);
		boolean developerUpdated = developerService.updateDeveloper(developerModel, Long.parseLong(id));
		if (developerUpdated == true) {
			return "/developers/view-developer/{id}";
		}
		return null;
	}

}
