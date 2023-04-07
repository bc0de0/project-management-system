package com.javabytes.projectm.Entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "resources")
public class Resource {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resource_id")
	private Long id;
	private String name;
	@OneToMany(mappedBy = "resources", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Task> tasks = new HashSet<>();
	private String department;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "resource_project", joinColumns = @JoinColumn(name = "resource_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
	private Set<Project> projects = new HashSet<>();

	public Resource(Long id, String name, Set<Task> tasks, String department, Set<Project> projects) {
		this.id = id;
		this.name = name;
		this.tasks = tasks;
		this.department = department;
		this.projects = projects;
	}

	public Resource() {

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

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Resource [id=" + id + ", name=" + name + ", tasks=" + tasks + ", department=" + department
				+ ", projects=" + projects + "]";
	}

}
