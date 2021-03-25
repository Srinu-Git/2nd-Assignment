package com.tcs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.entity.DeveloperEntity;
import com.tcs.model.DeveloperModel;
import com.tcs.repo.DevelopersRepository;

/*
 * this service main purpose to write business logic
 */
@Service
public class DeveloperServiceImpl implements DeveloperService {

	@Autowired
	DevelopersRepository developersRepository;

	/*
	 * this method main purpose to return all the developers from database
	 */
	@Override
	public List<DeveloperModel> getAllDevelopers() {
		List<DeveloperModel> allDevelopers = new ArrayList<DeveloperModel>();
		List<DeveloperEntity> developersEntity = developersRepository.findAll();
		for (DeveloperEntity singleDeveloper : developersEntity) {
			DeveloperModel developer = mapEntityToModel(singleDeveloper);
			allDevelopers.add(developer);
		}
		return allDevelopers;
	}

	/*
	 * this method main purpose to create developer to the database
	 *
	 */
	@Override
	public boolean createNewDeveloper(DeveloperModel developersModel) {
		DeveloperEntity entityToMap = new DeveloperEntity();
		DeveloperEntity developerEntity = developersRepository.save((mapModelToEntity(entityToMap, developersModel)));
		if (null != developerEntity.toString())
			return true;

		return false;
	}

	/*
	 * this method main purpose to return the specific developer from database
	 * 
	 * @see com.tcs.service.DeveloperService#getSingleDeveloper(java.lang.Long)
	 */
	@Override
	public DeveloperModel getSingleDeveloper(Long id) {
		DeveloperEntity developersEntity = developersRepository.findOne(id);
		DeveloperModel developer = mapEntityToModel(developersEntity);
		return developer;
	}

	/*
	 * this method main purpose to update the developer to the database
	 * 
	 * @see com.tcs.service.DeveloperService#updateDeveloper(com.tcs.model.
	 * DeveloperModel, java.lang.Long)
	 */
	@Override
	public boolean updateDeveloper(DeveloperModel developersModel, Long id) {
		DeveloperEntity entityToMap = new DeveloperEntity();
		DeveloperEntity developerEntity = developersRepository.save((mapModelToEntity(entityToMap, developersModel)));
		if (null != developerEntity.toString())
			return true;
		return false;
	}

	private DeveloperModel mapEntityToModel(DeveloperEntity developersEntity) {
		DeveloperModel developersModel = new DeveloperModel();
		developersModel.setId(developersEntity.getId());
		developersModel.setName(developersEntity.getName());
		developersModel.setEmail(developersEntity.getEmail());
		developersModel.setSkills(developersEntity.getSkills());
		return developersModel;
	}

	private DeveloperEntity mapModelToEntity(DeveloperEntity entityToMap, DeveloperModel developersModel) {
		DeveloperEntity developersEntity = new DeveloperEntity();
		developersEntity.setId(developersModel.getId());
		developersEntity.setName(developersModel.getName());
		developersEntity.setEmail(developersModel.getEmail());
		developersEntity.setSkills(developersModel.getSkills());
		return developersEntity;
	}

}
