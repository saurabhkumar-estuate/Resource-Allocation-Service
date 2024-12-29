package com.est.resource.allocation.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.est.resource.allocation.entity.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

    // Query to find resources by skills (matching skills in the input set)
	@Query("SELECT r FROM Resource r JOIN r.skills s " +
		       "WHERE LOWER(s) IN :skills " +
		       "GROUP BY r.id " +
		       "HAVING COUNT(DISTINCT s) = :skillCount")
		List<Resource> findBySkills(@Param("skills") Set<String> skills, @Param("skillCount") Long skillCount);


    // Query to find resources by matching skills and experience level (using JOIN for skills)
	@Query("SELECT DISTINCT r FROM Resource r JOIN r.skills s " +
		       "WHERE s IN :skills AND r.experience <= :experience " +
		       "GROUP BY r.id " +
		       "HAVING COUNT(DISTINCT s) = :skillCount")
		List<Resource> findBySkillsAndExperience(
		    @Param("skills") Set<String> skills,
		    @Param("experience") int experience,
		    @Param("skillCount") Long skillCount
		);


}
