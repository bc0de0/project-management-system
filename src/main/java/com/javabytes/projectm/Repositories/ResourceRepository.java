package com.javabytes.projectm.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javabytes.projectm.Entities.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Long> {

}
