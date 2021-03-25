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
import com.tcs.service.DeveloperService;

import java.util.List;

/*
 * this class main purpose to return the all the developers from database
 */
@Scope(value = "session")
@Join(path = "/", to = "/developers/developers-list.jsf")
@Component(value = "listDevelopers")
@ELBeanName(value = "listDevelopers")
public class ListDevelopersController {

	@Autowired
	private DeveloperService developerService;

	private List<DeveloperModel> developerModels;

	@Deferred
	@RequestAction
	@IgnorePostback
	public void getDefaultDevelopersList() {
		developerModels = developerService.getAllDevelopers();
	}

	/*
	 * this method main purpose to return the all the developers from database
	 */
	public List<DeveloperModel> getAllDevelopersList() {
		return developerModels;
	}

}
