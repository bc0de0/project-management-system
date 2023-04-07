package com.javabytes.projectm.Entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Cacheable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "projects")
@Cacheable
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@ManyToMany(mappedBy = "projects", fetch = FetchType.LAZY)
	private Set<Resource> resources = new HashSet<>();
	@OneToMany(mappedBy = "projects", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Task> tasks = new HashSet<>();

	public Project(Long id, String name, Set<Resource> resources, Set<Task> tasks) {
		this.id = id;
		this.name = name;
		this.resources = resources;
		this.tasks = tasks;
	}

	public Project() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Resource> getResources() {
		return resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", resources=" + resources + ", tasks=" + tasks + "]";
	}

}
