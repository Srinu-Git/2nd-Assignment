package com.tcs.service;

import java.util.List;

import com.tcs.model.DeveloperModel;

public interface DeveloperService {

	public List<DeveloperModel> getAllDevelopers();

	public boolean createNewDeveloper(DeveloperModel developersModel);

	public DeveloperModel getSingleDeveloper(Long id);

	public boolean updateDeveloper(DeveloperModel developersModel, Long id);

}
