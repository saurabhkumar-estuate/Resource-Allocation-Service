package com.est.resource.allocation.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.est.resource.allocation.entity.Resource;
import com.est.resource.allocation.repository.ResourceRepository;

@Service
public class ResourceAllocationServiceImpl implements ResourceAllocationService {

    @Autowired
    private ResourceRepository resourceRepository;
    
    private static final Logger logger = LoggerFactory.getLogger(ResourceAllocationServiceImpl.class);


    @Override
    public List<Resource> findResourcesForMicroserviceProject(Set<String> requiredSkills) {
        List<Resource> resources = resourceRepository.findAll();

        // Filter resources based on the required skills
        return resources.stream()
                .filter(resource -> resource.getSkills().containsAll(requiredSkills))
                .collect(Collectors.toList());
    }

    @Override
    public List<Resource> findResourcesForCloudProject(Set<String> requiredSkills, Integer maxExperience) {
        logger.info("Required skills: {}", requiredSkills);
        logger.info("Max experience: {}", maxExperience);
        List<Resource> resources = resourceRepository.findBySkillsAndExperience(requiredSkills, maxExperience, (long) requiredSkills.size());
        logger.info("Found resources: {}", resources);
        return resources;
    }
}
