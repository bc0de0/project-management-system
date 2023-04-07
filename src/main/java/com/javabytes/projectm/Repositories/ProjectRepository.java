package com.javabytes.projectm.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javabytes.projectm.Entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	
    Optional<Project> findById(Long id);

}
