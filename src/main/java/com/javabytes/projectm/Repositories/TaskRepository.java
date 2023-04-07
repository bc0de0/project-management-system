package com.javabytes.projectm.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javabytes.projectm.Entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
