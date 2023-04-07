package com.javabytes.projectm.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.javabytes.projectm.Entities.Resource;
import com.javabytes.projectm.Repositories.ResourceRepository;

public class ResourceServiceImpl implements ResourceService {
	
	@Autowired
	ResourceRepository resourceRepository;

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public ResponseEntity<Resource> createNewResource(Resource resource) {
		Resource resourceObj = resourceRepository.save(resource);
		return new ResponseEntity<>(resourceObj, HttpStatus.CREATED);
	}

}
