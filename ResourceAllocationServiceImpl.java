package com.est.resource.allocation.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.est.resource.allocation.entity.Resource;
import com.est.resource.allocation.repository.ResourceRepository;

@Service
public class ResourceAllocationServiceImpl implements ResourceAllocationService {

    @Autowired
    private ResourceRepository resourceRepository;

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
        return resourceRepository.findAll().stream()
                .filter(resource -> resource.getSkills().containsAll(requiredSkills) && resource.getExperience() < maxExperience)
                .collect(Collectors.toList());
    }
}
