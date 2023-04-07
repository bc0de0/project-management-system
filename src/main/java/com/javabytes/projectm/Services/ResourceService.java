package com.javabytes.projectm.Services;

import org.springframework.http.ResponseEntity;

import com.javabytes.projectm.Entities.Resource;

public interface ResourceService {

	public ResponseEntity<Resource> createNewResource(Resource resource);
}
