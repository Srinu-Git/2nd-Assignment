package com.tcs.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.entity.SkillEntity;

/*
 * this repository main purpose to return the all the developers skills from database
 */
@Repository
public interface SkillsRepository extends JpaRepository<SkillEntity, Long> {
}
