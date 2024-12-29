package com.est.resource.allocation.service;

import java.util.List;
import java.util.Set;

import com.est.resource.allocation.entity.Resource;

public interface ResourceAllocationService {

    // Method to find resources for a microservice project based on required skills
    List<Resource> findResourcesForMicroserviceProject(Set<String> requiredSkills);

    // Method to find resources for a cloud-based project based on required skills and max experience
    List<Resource> findResourcesForCloudProject(Set<String> requiredSkills, Integer maxExperience);
}
