package com.est.resource.allocation.entity;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "resources", schema = "saurabh_estuate")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resource {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String name;
    private Integer experience;
    
    @ElementCollection
    @CollectionTable(name = "resource_skills", joinColumns = @jakarta.persistence.JoinColumn(name = "resource_id"))
    @Column(name = "skill")
    private Set<String> skills;

}
