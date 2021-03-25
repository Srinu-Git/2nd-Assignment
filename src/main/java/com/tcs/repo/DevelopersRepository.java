package com.tcs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.entity.DeveloperEntity;

/*
 * this repository main purpose to return the all the developers from database
 */
@Repository
public interface DevelopersRepository extends JpaRepository<DeveloperEntity, Long> {

	
}
