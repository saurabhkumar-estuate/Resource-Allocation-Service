package com.est.resource.allocation.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.est.resource.allocation.entity.Resource;
import com.est.resource.allocation.service.ResourceAllocationService;

@RestController
@RequestMapping("/api/resources")
public class ResourceAllocationController {

    @Autowired
    private ResourceAllocationService resourceAllocationService;

    // Endpoint for microservice resources
    @GetMapping("/microservice")
    public List<Resource> getMicroserviceResources(
            @RequestParam("skills") List<String> requiredSkills) {
        Set<String> skillSet = new HashSet<>(requiredSkills);
        return resourceAllocationService.findResourcesForMicroserviceProject(skillSet);
    }

    // Endpoint for cloud resources
    @GetMapping("/cloud")
    public List<Resource> getCloudResources(
            @RequestParam("skills") List<String> requiredSkills,
            @RequestParam("maxExperience") Integer maxExperience) {
        Set<String> skillSet = new HashSet<>(requiredSkills);
        return resourceAllocationService.findResourcesForCloudProject(skillSet, maxExperience);
    }
}
